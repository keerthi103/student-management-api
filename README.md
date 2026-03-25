# Student Management REST API

A RESTful API built with Spring Boot and MySQL for managing student records.

## Tech Stack
- Java 17
- Spring Boot 4.0.3
- Spring Data JPA
- MySQL
- Maven

## Features
- Add a new student
- Get all students
- Get student by ID
- Update student details
- Delete a student
- Exception handling with proper HTTP status codes

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Add new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## How to Run
1. Clone the repository
2. Create MySQL database: `CREATE DATABASE studentdb;`
3. Update `application.properties` with your MySQL password
4. Run `StudentappApplication.java`
5. API runs on `http://localhost:8080`

## Sample Request (POST /students)
```json
{
    "name": "Keerthi",
    "email": "keerthi@gmail.com",
    "department": "ISE"
}
```
