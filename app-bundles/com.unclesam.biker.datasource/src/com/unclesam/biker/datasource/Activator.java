package com.unclesam.biker.datasource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.datasource.mysql.DataSourceHolder;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		FileInputStream inputStream = null;
		ByteArrayOutputStream outStream = null;
		try {
			File configFile = bundleContext.getDataFile("datasource.json");
			inputStream = new FileInputStream(configFile);
			byte[] content = new byte[1024];
			outStream = new ByteArrayOutputStream();
			while(inputStream.read(content) != -1) {
				IOUtils.write(content, outStream);
			}
			String configStr = new String(outStream.toByteArray());
			JSONObject dataSourceConfig = JSON.parseObject(configStr);
			DataSourceHolder.initDataSource(dataSourceConfig);
		}finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if(outStream != null) {
				outStream.close();
			}
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
