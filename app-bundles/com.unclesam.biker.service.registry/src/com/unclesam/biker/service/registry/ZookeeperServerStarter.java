package com.unclesam.biker.service.registry;

import java.io.File;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * ZookeeperServer 启动器
 * @author unclesam
 *
 */
public class ZookeeperServerStarter extends ZooKeeperServerMain implements BundleActivator {
	
	public void start(BundleContext bundleContext) throws Exception {
		File dir = bundleContext.getDataFile("zookeeper");
		ServerConfig config = new ServerConfig();
		config.parse(new String[] { "6789", dir.getAbsolutePath() });
		runFromConfig(config);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		shutdown();
		System.out.println("ZookeeperServer stop.");
	}

}
