package com.metafour.multitenancy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import lombok.Data;

/**
 * Configuration bean to hold tenant configuration.
 * NOTE: new idea.
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-28
 */
@Data
public class TenantConfig {
	private String name;

	@Value("datasource")
	private DataSourceProperties datasource;

	/** JDBC url of the database. */
	private String url;

	/** Login user of the database. */
	private String username;

	/** Login password of the database. */
	private String password;

	/** Fully qualified name of the JDBC driver. Auto-detected based on the URL by default. */
	private String driverClassName;

}
