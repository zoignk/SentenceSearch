# Sentence Search

This repository contains service with only one task:
Find all sentences in a file that contain a given word.

Beside solving specific task I'm using this repository to try out 
[Dropwizard](https://www.dropwizard.io) Java framework.

## Prerequisites
Install:
* Java 11
* Maven 

## Installation

* Clone this repository.
* Put textual file in resources folder.
* Set sourceFile name in `config.yml`

To start application run these commands from project folder:
```shell script
$ mvn clean install
... ...
... ...
$ java -jar target/SentenceSearch-1.0-SNAPSHOT.jar
```

## Usage

To use this service locally you can call this command. Replace value with searched word.
```shell script
$ curl localhost:8080/count?word=value
```

As a response you should receive prettified JSON with sentences that contain a given word, similar to this:
```json
    {
      "word": "value", 
      "sentences": [
        {"sentence": "Value or not value?", "count": 2},
        {"sentence": "Many people don't like value.", "count": 1}
      ]
    }
```

## Improvements

1. Currently, server is loading a file on each request. It would be nice to load a file on application startup only once.
2. I've added only unit tests for service methods. It would be nice to have E2E and API tests.
3. Basic parameter validation is present, but some more complex Error handler could be added.
4. Add API specification with OpenAPI or Swagger
   
