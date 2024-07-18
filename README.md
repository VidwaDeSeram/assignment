
# Event Management System Backend

## Table of Contents

- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Description

This is the backend service for the Event Management System, built using Spring Boot. The service provides RESTful API endpoints for managing events and attendees. The backend uses PostgreSQL/MySQL for data storage.

## Features

- CRUD operations for events and attendees
- RESTful API design
- Exception handling
- Input validation
- CORS configuration
- Logging

## Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- PostgreSQL/MySQL
- Maven

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher
- Maven 3.6.3 or higher
- PostgreSQL/MySQL (depending on your configuration)

## Installation

1. **Clone the repository**

    ```bash
    git clone https://github.com/yourusername/event-management-backend.git
    cd event-management-backend
    ```

2. **Configure the database**

    Update the `application.properties` file in `src/main/resources` with your database configurations.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Install dependencies**

    ```bash
    mvn clean install
    ```

## Running the Application

To run the application locally, use the following command:

```bash
mvn spring-boot:run
