# multitenancy-demo-app (Multitenancy demo application)

## Implementation Details
Application developed following the [article](http://anakiou.blogspot.com/2015/08/multi-tenant-application-with-spring.html)

Source code  : https://github.com/anakiou/multitenancy

### Features
- Spring Boot 1.5.6
- Tenant id found from URL
- HTTP interceptor used to extract current tenant id from URL which is then used by CurrentTenantIdentifierResolverImpl
- MultiTenancyJpaConfiguration switches database connection, defined in DataSourceConfig
- JPA with Spring data repository model
- 3x PostgreSQL database
- Lombok annotations

## TODO
Track all things to do here.

1. [Use datasource routing]( http://howtodoinjava.com/spring/spring-orm/spring-3-2-5-abstractroutingdatasource-example)
