package com.metafour.multitenancy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Inject multiple JDBC data sources as Spring beans into IOC. <br>
 * Database configurations are taken from {@code multitenant.properties} file and structured using {@link MultitenancyProperties}.
 * 
 * <pre>
 * <code>
 * spring.multitenancy.datasource1.url = jdbc:postgresql://localhost:5432/tenant_1
 * spring.multitenancy.datasource1.username = username
 * spring.multitenancy.datasource1.password = password
 * spring.multitenancy.datasource1.driver-class-name = org.postgresql.Driver
 * </code>
 * </pre>
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-25
 * @see MultitenancyProperties
 */
@EnableConfigurationProperties(MultitenancyProperties.class)
@Configuration
@PropertySource("classpath:multitenant.properties")
public class DataSourceConfig {

	@Autowired
	private MultitenancyProperties multitenancyProperties;

	@Bean(name = { "dataSource", "dataSource1" })
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource1")
	public DataSource dataSource1() {
		return buildDS(this.multitenancyProperties.getDatasource1());
	}

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource2")
	public DataSource dataSource2() {
		return buildDS(this.multitenancyProperties.getDatasource2());
	}

	@Bean(name = "dataSource3")
	@ConfigurationProperties(prefix = "spring.multitenancy.datasource3")
	public DataSource dataSource3() {
		return buildDS(this.multitenancyProperties.getDatasource3());
	}

	private DataSource buildDS(DataSourceProperties dsprop) {
		DataSourceBuilder factory = DataSourceBuilder
				.create(dsprop.getClassLoader())
				.driverClassName(dsprop.getDriverClassName())
				.username(dsprop.getUsername())
				.password(dsprop.getPassword())
				.url(dsprop.getUrl());
		return factory.build();
	}
}
