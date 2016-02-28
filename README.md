# teklabs

Here is a FizzBuzz application.

#####Task description:
+         Create a publicly available RESTful API
+         The API should implement rules of Fizz Buzz game
+         A user gives a number (or many) and expects a reply with numbers divisible by three replaced with the word "fizz" and numbers 
divisible by five with the word "buzz".
          See more detailed description: http://en.wikipedia.org/wiki/Fizz_buzz
+         The API has to be written in a JVM language
+         The API has to run on a public PaaS (Heroku, Pivotal Web Services, Openshift, Google App Engine, etc.)
+         Develop the API as you would be developing actual production software
+         We want to see and test your API, so make the code repository available to us. E.g. from GitHub or BitBucket
+         Provide us with the necessary credentials for accessing the API. (If applicable)
+         If you want, you can create a web-based UI for the API. This is not mandatory.


#####What you can find here:
* Spring Boot application
* RESTful application
* JUnit unit tests
* SingleSignOn with GitHub
* Simple UI in jQuery

#####How I can play with it?
Application is deployed to Heroku PAAS. The permanent link is [https://enigmatic-cove-35851.herokuapp.com/](https://enigmatic-cove-35851.herokuapp.com/)


#####How to run in IntelliJ Idea
* Just run it as a Spring Boot application. (or just java application)  Main class is `TekLabsApplication.java`

#####How to run as standalone:
* build the application using maven `mvn clean install`
* run the applcaiton as a `jar` file form `target` forlder: `java -jar teklabs-0.0.1-SNAPSHOT.jar`
