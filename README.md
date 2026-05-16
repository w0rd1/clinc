# Surgeon - Hospital Dashboard & Resource Management API

A Spring Boot application designed to manage hospital operations, including patient scheduling, medical staff assignments, operation room allocations, and surgery dashboards.

## Features & Functionalities

The application exposes RESTful APIs categorized into two main modules: **Dashboard Management** and **Resource Management**.

### 1. Dashboard Management API (`/api/v1/dashboard`)
Responsible for handling patient schedules and surgery data aggregation.
* **Get Surgery Summary** (`GET /summary`): Fetches a detailed summary of surgeries, including scheduled dates, patient names, operation room departments, and assigned medical staff. It supports filtering by patient name and a specific date range using JPA Specifications.
* **Insert Patient** (`POST /insert/patient`): Registers a new patient. The system automatically generates and assigns a unique Medical Record Number (MRN) to the patient.
* **Insert Surgery** (`POST /insert/surgery`): Schedules a new surgery. This endpoint intelligently cross-references existing records to link the correct Patient, Operation Room, and Medical Staff based on the provided request body, creating a unified `Surgery` schedule entity.

### 2. Resource Management API (`/api/v1/resource`)
Responsible for managing the physical and human resources of the hospital.
* **Insert Operation Room** (`POST /room`): Registers a new operation room into the hospital database, categorizing it by an identifier and the specific medical department (e.g., UROLOGY).
* **Insert Medical Staff** (`POST /staff`): Registers a new medical staff member, capturing their specific role tag (e.g., surgeon, nurse) and license number.

## Entity & Table Relationships

The core of the database centers around the `Surgery` entity, which ties together patients, staff, and facilities.

1. **`Surgery` <-> `Patient` (Many-to-One)**
   * A single patient can have multiple surgeries scheduled over time.
   * Each surgery record references exactly one patient.

2. **`Surgery` <-> `OperationRoom` (Many-to-One)**
   * Multiple surgeries can take place in a single operation room (scheduled at different times).
   * Each surgery is assigned to exactly one operation room.

3. **`Surgery` <-> `MedicalStaff` (Many-to-Many)**
   * A single surgery requires a team, meaning it can have multiple medical staff members (e.g., a primary surgeon, an anesthesiologist, and nurses) assigned to it.
   * Conversely, a medical staff member can participate in multiple different surgeries over time.

## Technical Details

* **Java & Spring Boot**: Core framework for building the application.
* **Spring Data JPA & Hibernate**: Manages entities and database relationships. Uses advanced concepts like `Specification` for dynamic filtering and `@EntityGraph` for mitigating N+1 query problems.
* **Lombok**: Reduces boilerplate code (Getters, Setters, Builders, Constructors).
* **Projections**: Uses Spring Data interface projections (`SurgerySummaryProjection`) to efficiently fetch and map complex nested payload responses without over-fetching unused entity fields.
