# Fetch REST API
In the repo I have setup maven spring boot project for Fetch REST Api
Tools, Libraries and language used:
1) Eclipse
2) MySQL Workbench 8.0.34
3) Postman
4) Java
5) Maven

To implement this repo please follow the below steps:
1) Install Java SE 17 or any java version such SE 8 or SE 11 but make sure you change the java version in pom.xml and any relevant code!
2) Install and setup Maven on your system.
3) I used Eclipse IDE but you can use any editor you wish...
4) Install MySQL Workbench 8.0.34 to use as database.
5) I used Postman to use the Fetch REST API but you are free to use anything that works.
6) Now clone this repo onto your system and import it as 'maven project' in eclipse.
![alt text](https://github.com/[tirukovelamanoj]/[fetch-api]/blob/[main]/1.png?raw=true)
7) You can now run the code and use the Fetch REST Api.

Note:
Make sure you change the below properties in application.properties file
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.url=jdbc:mysql://localhost:3306/fetchapi

spring.datasource.username=root

spring.datasource.password=root
```
