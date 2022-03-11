#Centralized Configuration Service based on Spring Cloud Config. Client part.

* `spring.config.import` - config server address. This property should be used instead of legacy bootstrap use or instead of `spring.cloud.config.uri`.
"optional" allows run application without config server if `spring.cloud.config.enabled` is true. For example `optional:configserver:http://localhost:8888` 
* `spring.cloud.config.enabled` - check running config server and existence of needed configuration on it. `false` - don't let start app when server is not available
* `spring.cloud.config.label` - optional field of file name component on server. Is used as git branch name.
* `spring.cloud.config.name` - can be used instead of spring.application.name to name first part of the needed file
* `spring.profiles.active` - standard spring field. For client application this values can be loaded in the order of enumeration. 
  When there are default property (application.properties) and profiled settings (application-profile.properties) then at the beginning default is loaded and profiled after.