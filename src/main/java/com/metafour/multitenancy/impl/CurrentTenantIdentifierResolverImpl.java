package com.metafour.multitenancy.impl;

import static com.metafour.multitenancy.impl.TenantContext.*;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.metafour.multitenancy.config.MultiTenancyJpaConfiguration;

/**
 * {@link CurrentTenantIdentifierResolver} implementation to resolve tenant id from HTTP request path.
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-25
 * @see MultiTenancyJpaConfiguration
 * @see <a href="http://anakiou.blogspot.com/2015/08/multi-tenant-application-with-spring.html">
 *      Multi-tenant application with Spring Boot + Spring Data JPA + Hibernate + MySQL + Thymeleaf</a>
 */
@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	@Override
	public String resolveCurrentTenantIdentifier() {
		return resolveTenantByRequestPath();
	}

	private String resolveTenantByRequestPath() {
		RequestAttributes attr = RequestContextHolder.getRequestAttributes();
		if (attr != null) {
			String id = (String) attr.getAttribute(CURRENT_TENANT_ID_KEY, RequestAttributes.SCOPE_REQUEST);
			if (id != null) return id;
		}
		return DEFAULT_TENANT_ID;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
