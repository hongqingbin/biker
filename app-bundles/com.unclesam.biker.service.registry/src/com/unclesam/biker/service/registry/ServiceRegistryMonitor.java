/**
 * 
 */
package com.unclesam.biker.service.registry;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig.ConfigException;
import org.osgi.framework.BundleContext;

/**
 * 服务注册监听器
 * @author ThinkPad
 *
 */
public class ServiceRegistryMonitor extends ZooKeeperServerMain {
	
	private Thread thread;
	
	public void start(final BundleContext bundleContext) throws Exception {
		this.thread = new Thread(new Runnable() {
			
			public void run() {
				File dir = bundleContext.getDataFile("zookeeper");
				Properties props = new Properties();  
		        props.setProperty("tickTime", "2000");  
		        props.setProperty("dataDir", dir.getAbsolutePath());  
		        props.setProperty("clientPort", "6789");  
		        props.setProperty("initLimit", "10");  
		        props.setProperty("syncLimit", "5");  
		        QuorumPeerConfig quorumConfig = new QuorumPeerConfig();  
		        try {
					quorumConfig.parseProperties(props);
					ServerConfig config = new ServerConfig(); 
			        config.readFrom(quorumConfig);
					runFromConfig(config);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ConfigException e) {
					e.printStackTrace();
				}
		        
			}
		});
		this.thread.start();
		
	}
	
	public void stop(BundleContext bundleContext) {
		shutdown();
		this.thread.interrupt();
	}

}
