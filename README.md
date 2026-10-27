# Employee Leave Management System

## 1. Project Overview

The Employee Leave Management System is a REST API application
developed using Spring Boot and MySQL.

It allows users to create, view, update, and delete employee
leave records. It also provides input validation and error
handling for invalid requests and missing records.

## 2. Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Bean Validation
- REST API
- PowerShell for API testing

## 3. Features

- Create an employee leave record
- Retrieve all leave records
- Retrieve a leave record by ID
- Update an existing leave record
- Delete a leave record
- Validate request data
- Return appropriate HTTP error status codes
- Store records in a MySQL database

## 4. Project Architecture

The application follows a layered architecture:

Controller -> Service -> Repository -> MySQL Database

- Entity: Represents the employee leave record.
- Repository: Performs database operations using Spring Data JPA.
- Service: Contains application business logic.
- Controller: Exposes REST API endpoints.
- Exception: Handles missing records and invalid input.

## 5. Prerequisites

Install the following before running the application:

- Java Development Kit
- MySQL Server
- Maven, or use the included Maven Wrapper
- An IDE such as Visual Studio Code or IntelliJ IDEA

## 6. Database Configuration

Create the database in MySQL:

```sql
CREATE DATABASE employee_leave_db;
```

Configure the database connection in:

src/main/resources/application.properties

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_leave_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

Set DB_USERNAME and DB_PASSWORD in your environment before
starting the application. Use your own MySQL credentials.

Note: The application must include the MySQL Connector/J dependency.

## 7. Run the Application

Open PowerShell in the project directory.

Compile the project:

```powershell
.\mvnw.cmd clean compile
```

Run the application:

```powershell
.\mvnw.cmd spring-boot:run
```

The API base URL is:

http://localhost:8080/api/leaves

Keep the application terminal running while testing the APIs.

## 8. REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/leaves | Retrieve all leave records |
| GET | /api/leaves/{id} | Retrieve a leave record by ID |
| POST | /api/leaves | Create a leave record |
| PUT | /api/leaves/{id} | Update a leave record |
| DELETE | /api/leaves/{id} | Delete a leave record |

### Create a Leave Record

POST /api/leaves

Request body:

```json
{
  "employeeName": "Janardhan",
  "leaveType": "Sick Leave",
  "numberOfDays": 2,
  "reason": "Not feeling well"
}
```

### Update a Leave Record

PUT /api/leaves/1

Request body:

```json
{
  "employeeName": "Janardhan",
  "leaveType": "Casual Leave",
  "numberOfDays": 3,
  "reason": "Personal work"
}
```

### Example Error Responses

- 400 Bad Request: Request validation failed.
- 404 Not Found: The requested leave record does not exist.
- 204 No Content: Leave record deleted successfully.

## 9. Validation Rules

- Employee name is required and cannot be blank.
- Leave type is required and cannot be blank.
- Number of leave days must be at least 1.
- Reason is required and cannot be blank.

## 10. Testing

The following operations have been tested manually:

- Create, retrieve, update, and delete leave records.
- Retrieve a missing record and verify the 404 response.
- Submit invalid data and verify the 400 response with validation messages.

## 11. Future Enhancements

- Employee registration and authentication
- Leave approval and rejection workflow
- Leave balance management
- Employee and administrator roles
- Automated unit and integration tests
- Frontend user interface

## 12. Author

Developed as a Spring Boot learning project.
