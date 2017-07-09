# Sample microservice with scala 
- AKKA HTTP 
- SLICK (Postgres)
- FLYWAY (Database Migration)
- SPRAY JSON
- Guice (Dependency Injection)

This repo is part of my learning exercise to build production ready microservice in scala.
# Things that I wanted to cover in this project
- Restful API
- Database Integration
- 3rd party service call
- Oauth2 Authentication 
- Redis Cache Integration 
- Elasticsearch Integration for Search
 
I will also introduce on the steps I followed to build this project.

## About the microservice 

### DIY
- This microservice is simple restful service for logging and sharing all your **Do it yourself** projects.


Project

| Id      | Title            | Description        | Tasks                 | User  | Tags         |
|---------|:----------------:|:------------------:|:---------------------:|-------|--------------|
| xyz-123 | my first project | fancy description  | 1. do this 2 do that  | Vijay | test,random  |


#### Use cases and Scenarios
 - User
    - CRUD
    - Authenticate
    - Search Projects 
    - Heart Projects
   
 - Project
    - CRUD
    - Publish
    
    
## RUN Locally
```sbtshell
sbt flyway migrate
```
```sbtshell
sbt run
```

 