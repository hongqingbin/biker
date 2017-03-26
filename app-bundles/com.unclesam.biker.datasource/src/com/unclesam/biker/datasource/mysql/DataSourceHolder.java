/**
 * 
 */
package com.unclesam.biker.datasource.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unclesam.biker.datasource.BikerDataSource;
import com.unclesam.biker.datasource.exception.DataSourceConfigException;

/**
 * mysql数据源持有器（支持主从库）
 * @author ThinkPad
 *
 */
public final class DataSourceHolder {
	
	private static BikerDataSource[] dataSource;
	
	
	/**
	 * 获取主数据源
	 * @return
	 */
	public static final DruidDataSource getMasterDataSource() {
		validateDataSource();
		BikerDataSource master = null;
		for(BikerDataSource source : dataSource) {
			if(source.isMaster()) {
				master = source;
				break ;
			}
		}
		return master;
	}
	
	/**
	 * 获取从数据源
	 * @return
	 */
	public static final DruidDataSource getSlaveDataSource() {
		validateDataSource();
		BikerDataSource slave = null;
		for(BikerDataSource source : dataSource) {
			if(slave != null) {
				if(!source.isMaster() && source.getHoldCount() < slave.getHoldCount()) {
					slave = source;
				}
			}else {
				slave = source;
			}
		}
		return slave;
	}
	
	/**
	 * 选举主数据源
	 */
	public static final void electMasterDataSource() {
		validateDataSource();
		BikerDataSource master = null;
		for(BikerDataSource source : dataSource) {
			source.setMaster(false);
			if(master != null && master.getWeightFactor() < source.getWeightFactor()) {
				master = source;
			} 
		}
		if(master != null) {
			master.setMaster(true);;
		}
	}
	
	/**
	 * 初始化数据源
	 * @param dataSourceConfig 数据源配置文件
	 */
	public static final void initDataSource(JSONObject dataSourceConfig) {
		JSONArray config = dataSourceConfig.getJSONArray("datasource");
		int length = config.size();
		dataSource = new BikerDataSource[length];
		for(int index = 0; index < length; index ++) {
			dataSource[index] = new BikerDataSource(config.getJSONObject(index));
		}
	}
	
	private static final void validateDataSource() {
		if(dataSource == null || dataSource.length ==  0) {
			throw new DataSourceConfigException("数据源没有配置");	
		}
	}

}
