# Rest-ws-using-Spring-boot-JPA

Created REST web services using Spring boot and JPA using GET, POST, PUT, DELETE operations.
For POST, PUT and DELETE operations I've used POSTMAN google extension.
Used in-memory database which is H2 database.
To use other database, we need to put the corresponding Maven dependency and configure the driver connections in application.properties file as below:

DataBase related

spring.datasource.url=jdbc:mysql://localhost:port/databasename

spring.datasource.username=username

spring.datasource.password=password

spring.datasource.driver-class-name=com.mysql.jdbc.Driver

JPA related

spring.jpa.show-sql=true // Shows the sql queries in the log related to JPA

spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect  // Corresponding database Dialect

spring.jpa.hibernate.ddl-auto = create //creates the tables of the database everytime we start the server and the application.

Created front end application which makes use of the above created REST services by calling using RestTemplate.
This is just a simple front end application which allows the user to register and log in and view the corresponding orders of the logged in user.
It makes call to the above REST services and fetches the required results and compares the results and displays the corresponding details.
I've used Spring boot and JSP to create this application.

I made these two applications run parallelly on different ports so that one application can make use of other to fetch the required results.
For this I've used, server.port = portnumber in application.properties file.

localhost:1111/Login is the URL to launch the login page of the front end application and 8080 is the port on which the REST services are bieng run.
