/**
 * 
 */
package com.unclesam.biker.datasource;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;

/**
 * 数据源（对DruidDataSource二次封装，支持主从库选举机制）
 * @author ThinkPad
 *
 */
public final class BikerDataSource extends DruidDataSource {
	
	private static final long serialVersionUID = 1L;

	private boolean master;
	
	private volatile int holdCount = 0;
	
	private int weightFactor;
	
	public BikerDataSource(JSONObject config) {
		this.setName(config.getString("name"));
		this.setDbType(config.getString("dbType"));
		this.setUrl(config.getString("jdbcUrl"));
		this.setUsername(config.getString("username"));
		this.setPassword(config.getString("password"));
		this.setInitialSize(config.getIntValue("initialSize"));
		this.setMinIdle(config.getIntValue("minIdle"));
		this.setMaxActive(config.getIntValue("maxActive"));
		this.setMaxWait(config.getIntValue("maxWait"));
		this.setRemoveAbandoned(config.getBooleanValue("removeAbandoned"));
		this.setRemoveAbandonedTimeout(config.getIntValue("removeAbandonedTimeout"));
		this.setTimeBetweenEvictionRunsMillis(config.getIntValue("timeBetweenEvictionRunsMillis"));
		this.setMinEvictableIdleTimeMillis(config.getIntValue("minEvictableIdleTimeMillis"));
		this.setValidationQuery(config.getString("validationQuery"));
		this.setMaxPoolPreparedStatementPerConnectionSize(config.getIntValue("maxPoolPreparedStatementPerConnectionSize"));
		try {
			this.setFilters(config.getString("filters"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			this.setExceptionSorter(config.getString("exceptionSorter"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setPoolPreparedStatements(config.getBooleanValue("poolPreparedStatements"));
	}
	
	public void hold() {
		this.holdCount ++;
	}
	
	public void release() {
		this.holdCount --;
	}

	public int getHoldCount() {
		return this.holdCount;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public int getWeightFactor() {
		return weightFactor;
	}

	public void setWeightFactor(int weightFactor) {
		this.weightFactor = weightFactor;
	}
	
}
