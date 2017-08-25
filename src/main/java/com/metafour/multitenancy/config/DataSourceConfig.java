package com.metafour.multitenancy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(MultitenancyProperties.class)
@Configuration
public class DataSourceConfig {

	@Autowired
	private MultitenancyProperties multitenancyProperties;

	@Bean(name = { "dataSource", "dataSource1" })
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource1")
	public DataSource dataSource1() {
		return getDS(this.multitenancyProperties.getDatasource1());
	}

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource2")
	public DataSource dataSource2() {
		return getDS(this.multitenancyProperties.getDatasource2());
	}

	@Bean(name = "dataSource3")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource3")
	public DataSource dataSource3() {
		return getDS(this.multitenancyProperties.getDatasource3());
	}

	private DataSource getDS(DataSourceProperties dsprop) {
		DataSourceBuilder factory = DataSourceBuilder
				.create(dsprop.getClassLoader())
				.driverClassName(dsprop.getDriverClassName())
				.username(dsprop.getUsername())
				.password(dsprop.getPassword())
				.url(dsprop.getUrl());
		return factory.build();
	}
}
