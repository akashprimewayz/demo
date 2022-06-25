
# Demo Application (for java 1.8 ) (tested with Java 1.8)



Technology Used

- Springdoc-openapi-ui for Documenttation
- Framework: Spring boot 2.7
- Packaging: maven
- Java: java 8
- Database: Postgresql
- Database access objects : NamedParameterJdbcTemplate 
- Codebase versioning Github
- Database Versioning flyway-core

API documentation:
-------------------

[http://localhost:8080/documentation.html](http://localhost:8080/documentation.html)

# Open API URL: http://localhost:8080/demo-openapi

Get the source code:
-------------------
Clone the repository:
     
	 $ git clone [https://github.com/akashprimewayz/demo.git](https://github.com/akashprimewayz/demo.git)
	 
If this is your first time using Github, review http://help.github.com to learn the basics.

You can also download the zip file containing the code from [https://github.com/akashprimewayz/demo](https://github.com/akashprimewayz/demo) 

To build the application:
-------------------

From the command line:

	$ cd demo
	$ mvnw clean install
	$ mvnw spring-boot:run

### Access the application:
-------------------

Access the headless web application at: http://localhost:8080/swagger-ui.html

### Prerequisite
# Install Java 1.8
# Install Postgres database
# add password "root" for default postgres user
