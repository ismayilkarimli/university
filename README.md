# University

This Spring Boot mini-project simulates a university API.

## Usage
* Ports 5432 (Postgres) and 8080 (Tomcat) should be free.

* Usage information about the end-points can be obtained from ```/swagger-ui/``` or ```/v3/api-docs``` endpoints.

## Features
* REST endpoints for Student (```/student```), Lecture (```/lecture```), Instructor (```/instructor```), and Classroom (```/classroom```).
* CRUD for Student, Lecture, Instructor, and Classroom.
* Unit tests for all Services

## Installation & Running
Install:

```bash
git clone https://github.com/ismayilkarimli/university
```

Run:
```bash
docker-compose up -d # wait around 40 seconds for the application to start before sending a request
```
