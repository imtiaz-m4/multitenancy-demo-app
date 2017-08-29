package com.metafour.multitenancy.impl;

import org.springframework.util.Assert;

/**
 * Context for each tenant in application context. <br>
 * NOTE: Manually managing threads ?
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-28
 */
public class TenantContext {
	/** Key to identify {@code Tenant id} from HTTP URL */
	public static final String TENANT_ID_KEY = "tenantid";
	/** Key to identify current {@code tenant id} stored in HTTP request attribute */
	public static final String CURRENT_TENANT_ID_KEY = "CURRENT_TENANT_IDENTIFIER";
	/** Id of default tenant */
	public static final String DEFAULT_TENANT_ID = "tenant_1";

	private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();

	public static void setCurrentTenant(Object tenant) {
		Assert.notNull(tenant, "Tenant id can not be null");
		currentTenant.set(tenant);
	}

	public static Object getCurrentTenant() {
		return currentTenant.get();
	}
}
