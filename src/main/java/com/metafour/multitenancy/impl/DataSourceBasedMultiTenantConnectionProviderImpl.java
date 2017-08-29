package com.metafour.multitenancy.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metafour.multitenancy.config.MultiTenancyJpaConfiguration;

/**
 * Database connection provider implementation for multitenant scenario.
 *  
 * @author Imtiaz Rahi
 * @since 2017-08-25
 * @see MultiTenancyJpaConfiguration
 */
@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
	private static final long serialVersionUID = 8168907057647334460L;

	@Autowired
	private DataSource dataSource1;

	@Autowired
	private DataSource dataSource2;

	@Autowired
	private DataSource dataSource3;

	private Map<String, DataSource> map;

	@PostConstruct
	public void load() {
		map = new HashMap<>();
		map.put("tenant_1", dataSource1);
		map.put("tenant_2", dataSource2);
		map.put("tenant_3", dataSource3);
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return map.get(TenantContext.DEFAULT_TENANT_ID);
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		return map.get(tenantIdentifier);
	}
}
