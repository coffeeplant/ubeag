# u-beag: A URL Shortening service

u-beag is a URL shortener that takes input of a url and returns a unique shortened link. When the link is entered into a browser it redirects to the original link.

Available at https://ubeag-1623079243765.azurewebsites.net

This project was built with Maven Java Spring Boot, Java JDK 11. It connects to a SQL Server database. Both are deployed to Azure, App Services and Azure SQL Server respectively.

The brief requested a short amount of time for development. For this reason the Spring Boot, SQL Server design was chosen due to developer familiarity. With more time a more appropriate design would be a serverless Azure Function with HTTP trigger and Cosmos DB.

## Possible Additional Features:
- Redirect to HTTP.BAD_REQUEST for null original URL
- The algorithm to create the shortlink is a Base10 to Base62 conversion. Currently, this runs in order according to the ID of the Link table. Further development would see slugs created in a non-sequential nature.
- A user log-in and saving links to a user account was not noted in the requirements. But this functionality would allow users to create, track and delete links
- Custom links
- An expiration date 
- Creation of Docker container




## Endpoints for testing on Postman:

**POST** https://ubeag-1623079243765.azurewebsites.net/ubeag/createshort

{HTTP Body} - This must contain a url beginning with http:// or https://

This will return the shortlink in the form 'ubeag/{uniqueslug}'


**GET** https://ubeag-1623079243765.azurewebsites.net/ubeag/{uniqueslug}

This will redirect to the original url



## Running locally:

$ git clone https://github.com/coffeeplant/ubeag.git

Change the application.properties file to point to your own SQL Server Database

Endpoints:
localhost:8080/ubeag/createshort
localhost:8080/ubeag{uniqueslug}


### Invoking on command line using bash:

     * 1. curl -d "HTTP Body" {your host}/ubeag
     * 2. curl "{your host}/api/ubeag/

Change Hibernate to 'create/drop' when making relevant changes to database and 'update' in other instances.



## Deployment to Azure
An Azure subscription, login and CLI is necessary
This project was deployed to Azure using the following commands:

```
./mvnw com.microsoft.azure:azure-webapp-maven-plugin:1.14.0:config
```
This creates the appropriate plug-in in the pom.xml file. The settings are input according to instructions on a step-by-step basis.

``` 
az login
```
An Azure subscription and login is necessary

```
mvn clean package
```

To package up the .jar file using Maven
The Spring start-up must be seen when building. If not, check your Java version to ensure the correct $JAVA_HOME is set

```
mvn mvn azure:webapp deploy
```


