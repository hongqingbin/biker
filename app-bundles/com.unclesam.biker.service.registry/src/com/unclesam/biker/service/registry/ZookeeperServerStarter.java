package com.unclesam.biker.service.registry;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * ZookeeperServer 启动器
 * @author unclesam
 *
 */
public class ZookeeperServerStarter implements BundleActivator {
	
	private ServiceRegistryMonitor serviceMonitor;
	
	public void start(BundleContext bundleContext) throws Exception {
		this.serviceMonitor = new ServiceRegistryMonitor();
		this.serviceMonitor.start(bundleContext);
		System.out.println("ZookeeperServer start.");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		this.serviceMonitor.stop(bundleContext);
		this.serviceMonitor = null;
		System.out.println("ZookeeperServer stop.");
	}

}
