package com.metafour.multitenancy.impl;

import static com.metafour.multitenancy.impl.TenantContext.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.metafour.multitenancy.config.WebMvcConfig;

/**
 * HTTP request interceptor to extract tenant id from HTTP URL path. <br>
 * Added to Spring {@link InterceptorRegistry interceptor registry} using {@link WebMvcConfigurerAdapter}.
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-25
 * @see WebMvcConfig
 */
public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		Map<String, Object> vars = (Map<String, Object>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		if (vars.containsKey(TENANT_ID_KEY)) req.setAttribute(CURRENT_TENANT_ID_KEY, vars.get(TENANT_ID_KEY));
		return true;
	}
}
