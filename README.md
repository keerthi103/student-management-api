# Student Management REST API

A secure RESTful API built with Spring Boot and MySQL for managing student records.

## Tech Stack
- Java 17
- Spring Boot 4.0.3
- Spring Security + JWT
- Spring Data JPA + Hibernate
- MySQL
- Maven

## Features
- Add, get, update, delete students (Full CRUD)
- Subject management (Regular and Open Elective)
- Many-to-Many relationship between Students and Subjects
- Get student with all their subjects in single API call
- JWT Authentication — all endpoints secured
- Global exception handling with proper HTTP status codes

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/login | Login and get JWT token |

### Students
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID with subjects |
| POST | /students | Add new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

### Subjects
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /subjects | Add new subject |
| GET | /subjects | Get all subjects |
| POST | /subjects/assign/{studentId}/{subjectId} | Assign subject to student |
| GET | /subjects/student/{studentId} | Get all subjects of a student |

## How to Run
1. Clone the repository
2. Create MySQL database: `CREATE DATABASE studentdb;`
3. Update `application.properties` with your MySQL password
4. Run `StudentappApplication.java`
5. API runs on `http://localhost:8080`

## Sample Login Request
```json
{
    "username": "keerthi",
    "password": "password123"
}
```
