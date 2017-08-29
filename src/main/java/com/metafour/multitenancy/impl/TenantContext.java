package com.metafour.multitenancy.impl;

/**
 * Context for each tenant in application context. <br>
 * NOTE: Manually managing threads ?
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-28
 */
public class TenantContext {
	public static final String TENANT_ID_STR = "tenantid";
	public static final String CURRENT_TENANT_ID_STR = "CURRENT_TENANT_IDENTIFIER";
	/** Id of default tenant */
	public static final String DEFAULT_TENANT_ID = "tenant_1";

	private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();

	public static void setCurrentTenant(Object tenant) {
		currentTenant.set(tenant);
	}

	public static Object getCurrentTenant() {
		return currentTenant.get();
	}
}
