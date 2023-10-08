# Fetch REST API <br />
In the repo I have setup maven spring boot project for Fetch REST API<br /><br />
Tools, Libraries and language used:<br />
1) Eclipse
2) MySQL Workbench 8.0.34
3) Postman
4) Java, JPA
5) Maven
6) SpringBoot

To implement this repo please follow the below steps:<br />
1) Install Java SE 17 or any java version such SE 8 or SE 11 but make sure you change the java version in pom.xml and any relevant code!
2) Install and setup Maven on your system.
3) I used Eclipse IDE but you can use any editor you wish...
4) Install MySQL Workbench 8.0.34 to use as database.<br />
![3](https://github.com/tirukovelamanoj/fetch-api/assets/48385975/de59da50-ae16-4cb1-b696-087272381132)
5) I used Postman to use the Fetch REST API but you are free to use anything that works.<br />
![2](https://github.com/tirukovelamanoj/fetch-api/assets/48385975/0bc352c1-a004-45c7-ac3f-60e489f49812)
6) Now clone this repo onto your system and import it as 'maven project' in eclipse.<br />
![1](https://github.com/tirukovelamanoj/fetch-api/assets/48385975/8dcfb1f0-0b98-44de-b4b2-7f923cf74bbc)
7) You can now run the code and use the Fetch REST Api.

Note: Make sure you change the below properties in application.properties file<br />
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.url=jdbc:mysql://localhost:3306/fetchapi

spring.datasource.username=root

spring.datasource.password=root
```
