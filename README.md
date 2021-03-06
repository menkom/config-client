#Centralized Configuration Service based on Spring Cloud Config. Client part.

* `spring.config.import` - config server address. This property should be used instead of legacy bootstrap use or instead of `spring.cloud.config.uri`.
"optional" allows run application without config server if `spring.cloud.config.enabled` is true. For example `optional:configserver:http://localhost:8888` 
* `spring.cloud.config.enabled` - check running config server and existence of needed configuration on it. `false` - don't let start app when server is not available
* `spring.cloud.config.label` - optional field of file name component on server. Is used as git branch name.
* `spring.cloud.config.name` - can be used instead of spring.application.name to name first part of the needed file
* `spring.profiles.active` - standard spring field. For client application this values can be loaded in the order of enumeration. 
  When there are default property (application.properties) and profiled settings (application-profile.properties) then at the beginning default is loaded and profiled after.


There is a compatibility matrix of Spring-boot and Spring-cloud. https://spring.io/projects/spring-cloud#overview

For current moment

| Boot version | Cloud version |
|--------------|---------------|
| 2.5.4        | 2020.0.5      |
| 2.6.4        | 2021.0.1      |

###Refreshable without restart

To make it possible to update settings without restart of client application you need to 

1. Add `spring-boot-starter-actuator` dependency to gradle or maven file
2. Turn on refresh option for necessary endpoints in application.properties 
at property `management.endpoints.web.exposure.include` (* - all of them or enumerate needed from `refresh`, `bus-refresh`, `beans`, `env`) 
or exclude with property `management.endpoints.web.exposure.exclude`.
3. Add `@RefreshScope` annotation on bean to refresh `@Value`. For properties with `@ConfigurationProperties` use of `@RefreshScope` is redundant.

Notice:
1. If property is not covered with `@RefreshScope` or `@ConfigurationProperties` then you have to restart application to update its' value.
2. If you don't need to load properties only on start then you don't need all this settings 