## User API

### Description

This project is a web application which offers 4 APIs. 

* One to create a monaco service 
* One to update a monaco service
* One to display a monaco service by Id
* One that lists all monaco services.

This web application was designed with : 

springBoot framework,
swagger 3 to test API more easily and to manage the optional parameters :   http://localhost:8080/swagger-ui.html
jdbcTemplate for the security

I also put an embedded database H2. Please note that data persistence is reinitialized each time the server is started (fictitious database). 
Logs have been put with self4J and error messages are returned as an exception in the event of an error.
I exported also a collection Postman for test API

### Tests :

Regarding the tests, I only tested the relevant parts:

I used Junit and mockito in order to be able to mock the DAO layer when I test the service.
I am using H2 for persistence, I have not tested the DAO layer because it's not relevent in this case.
Regarding the controlller, it not been tested because it directly returns the service which is tested.

### Prerequisite : 

* Maven
* Java 11

### How to run app in local without docker: 

* mvn clean install
* Run main class : ServiceManagementApplication.class

And after try the API with postman or with the url of swagger-ui : http://localhost:8080/swagger-ui.html

### How to run app with docker: 

docker build -t monaco-service-docker .
docker run -dp 8080:8080 monaco-service-docker

