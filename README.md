# OPD Management System

A full-stack OPD (Out Patient Department) Management System built using **Spring Boot**, **Angular**, and **MySQL**.

This project helps hospitals/clinics manage:
- Patient records
- Appointments
- Doctor consultations
- OPD workflow

---

# Tech Stack

## Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Frontend
- Angular
- TypeScript
- HTML
- CSS

## Database
- MySQL

---

# Features

## Patient Management
- Add patient
- View all patients
- Store patient details in database
- Search/select patients from frontend

## Appointment Management
- Create appointments
- Assign doctor
- Store appointment time
- Fetch all appointments

## Consultation Management
- Add consultation notes
- Link consultation with patient
- Store doctor observations

---

# Project Structure

## Backend Structure (Spring Boot)

```bash
src/main/java/com/example/opdmanagement
│
├── controller
│   ├── PatientController.java
│   ├── AppointmentController.java
│   └── ConsultationController.java
│
├── model
│   ├── Patient.java
│   ├── Appointment.java
│   └── Consultation.java
│
├── repository
│   ├── PatientRepository.java
│   ├── AppointmentRepository.java
│   └── ConsultationRepository.java
│
├── service
│   ├── PatientService.java
│   ├── AppointmentService.java
│   └── ConsultationService.java
│
└── OpdManagementApplication.java
```

---

## Frontend Structure (Angular)

```bash
src/app
│
├── patient-list
├── appointment-list
├── consultation-list
├── services
│   └── api.service.ts
│
├── app.component.html
├── app.component.ts
└── app.routes.ts
```

---

# Backend Flow

## 1. Client Request
Frontend sends HTTP request.

Example:

```http
POST /api/patients
```

---

## 2. Controller Layer
Controller receives request.

```java
@RestController
@RequestMapping("/api/patients")
public class PatientController {
```

Controller handles:
- API endpoints
- Request mapping
- Sending response

---

## 3. Service Layer
Business logic is written here.

Example:

```java
public Patient savePatient(Patient patient) {
    return patientRepository.save(patient);
}
```

Responsibilities:
- Validation
- Business logic
- Data processing

---

## 4. Repository Layer
Repository communicates with database using JPA.

```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
```

Responsibilities:
- Database queries
- CRUD operations

---

## 5. Database
Data is stored in MySQL tables.

Example tables:
- patients
- appointments
- consultations

---

# API Endpoints

## Patient APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/patients` | Get all patients |
| POST | `/api/patients` | Add new patient |
| GET | `/api/patients/{id}` | Get patient by ID |

---

## Appointment APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/appointments` | Get all appointments |
| POST | `/api/appointments` | Create appointment |

---

## Consultation APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/consultations` | Get all consultations |
| POST | `/api/consultations` | Add consultation |

---

# Database Configuration

## application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/opd_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# How to Run Backend

## Step 1: Clone Repository

```bash
git clone <repository-url>
```

---

## Step 2: Open Backend

Open project in:
- IntelliJ IDEA
- VS Code
- Eclipse

---

## Step 3: Configure MySQL

Create database:

```sql
CREATE DATABASE opd_db;
```

Update username/password in:

```properties
application.properties
```

---

## Step 4: Run Spring Boot

Run:

```bash
mvn spring-boot:run
```

Backend runs on:

```bash
http://localhost:8080
```

---

# How to Run Frontend

## Step 1: Open Angular Project

```bash
cd frontend
```

---

## Step 2: Install Dependencies

```bash
npm install
```

---

## Step 3: Run Angular App

```bash
ng serve
```

Frontend runs on:

```bash
http://localhost:4200
```

---

# Frontend-Backend Integration

Angular frontend communicates with Spring Boot backend using HTTP APIs.

Example:

```typescript
this.http.get('http://localhost:8080/api/patients')
```

Data Flow:

```text
Angular Frontend
       ↓
REST API Call
       ↓
Spring Boot Controller
       ↓
Service Layer
       ↓
Repository Layer
       ↓
MySQL Database
```

---

# Sample JSON

## Add Patient

```json
{
  "name": "Rahul Sharma",
  "age": 24,
  "gender": "Male"
}
```

---

## Create Appointment

```json
{
  "patientId": 1,
  "doctorName": "Dr. Mehta",
  "appointmentTime": "2026-05-09T15:30:00"
}
```

---

## Add Consultation

```json
{
  "patientId": 1,
  "doctorName": "Dr. Shah",
  "notes": "Patient has mild fever"
}
```

---

# Future Improvements

- JWT Authentication
- Role-based access
- Doctor dashboard
- Prescription management
- Search and filters
- Pagination
- Email/SMS reminders
- Deployment on cloud

---

# Learning Outcomes

This project demonstrates:
- Full-stack development
- REST API development
- CRUD operations
- Angular-Spring Boot integration
- MySQL database handling
- Layered architecture
- API testing

---

# Author

Developed by Vivek.

---

# Screenshots

Add project screenshots here before uploading to GitHub.

Example:

```md
![Home Page](screenshots/home.png)
```

---

# License

This project is for educational and learning purposes.

