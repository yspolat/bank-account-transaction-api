# Bank Account-Transaction REST API

## About

This open source REST API for banks that enables account holders to interact with their bank accounts and transactions


## Setup

The project uses Maven as its build tool and Spring Boot as framework.


To build the project 

```
mvn clean package
```

Run application without IDE 
```
java -jar bank-account-transaction-api-0.0.1-SNAPSHOT.jar
```

OR import the project as Maven to your favorite IDE and run Spring Boot application

## Database

The default database for testing is H2 DB

Go to http://localhost:8080/h2-console/ in order to access H2 web console

Credentials: ```admin/admin111```

## Endpoints

### API Resources

```http
GET /account/all
```
```http
POST /account
```
```http
GET /customer/all
```
```http
GET /customer/{customer_id}
```

### Postman

To play with API, you could use Postman on your local

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/ea0d5b419fd33e39e3dd)
