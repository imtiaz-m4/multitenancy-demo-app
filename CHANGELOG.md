# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]
Unrelease changes are tracked here.

## [0.1.1] - 2017-08-28
### Added
- namespace for multitenancy implementation custom classes
- Necessary comments added to classes with creation date

### Changed
- Multitenancy implementation custom classes moved to new namespace
- tenant identifier key names to understand usage of them

## [0.0.1] - 2017-08-28
### Added
- Multitenancy demo application following the [article](http://anakiou.blogspot.com/2015/08/multi-tenant-application-with-spring.html)
- Spring Boot 1.5.6
- Tenant id found from URL
- HTTP interceptor used to extract current tenant id from URL which is then used by CurrentTenantIdentifierResolverImpl
- MultiTenancyJpaConfiguration switches database connection, defined in DataSourceConfig
- JPA with Spring data repository model
- 3x PostgreSQL database
- Lombok annotations


## [version] - 2017-06-20
### Added [new features]
### Changed [changes in existing functionality]
### Deprecated [soon-to-be removed features]
### Removed [removed features]
### Fixed [bug fixes]
### Security [vulnerabilities]