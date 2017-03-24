package com.unclesam.biker.netty.client;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private ZooKeeper zookeeper;
	
	/**
	 * bundle启动的时候，设置节点内容
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Watcher watcher = new Watcher() {  
            public void process(WatchedEvent event) {  
                System.out.println("event: " + event.getType()+" path="+event.getPath());  
            }  
        };
		zookeeper = new ZooKeeper("localhost:6789", 10000,  watcher);  
   
	}

	/**
	 * bundle停止的时候，删除zookeeper节点内容
	 */
	public void stop(BundleContext bundleContext) throws Exception {
        zookeeper.close();
	}

}
