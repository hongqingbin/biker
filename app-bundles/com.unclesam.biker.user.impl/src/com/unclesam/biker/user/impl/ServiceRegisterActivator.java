package com.unclesam.biker.user.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.unclesam.biker.user.impl.server.HttpSnoopServerInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 * @author JoinBean
 *
 */
public class ServiceRegisterActivator implements BundleActivator {

	static final boolean SSL = System.getProperty("ssl") != null;
	static final int PORT = Integer.parseInt(System.getProperty("port", SSL ? "8443" : "8080"));

	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	private Channel channel;

	public void start(BundleContext context) throws Exception {
		final SslContext sslCtx;
		if (SSL) {
			SelfSignedCertificate ssc = new SelfSignedCertificate();
			sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
		} else {
			sslCtx = null;
		}
		bossGroup = new NioEventLoopGroup(1);
		workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpSnoopServerInitializer(sslCtx));

		channel = b.bind(PORT).sync().channel();

		System.err.println("Open your web browser and navigate to " + (SSL ? "https" : "http") + "://127.0.0.1:" + PORT + '/');
	}

	public void stop(BundleContext context) throws Exception {
		channel.close();
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
		workerGroup = null;
		bossGroup = null;
	}

}
