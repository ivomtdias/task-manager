# Task Manager Application

The Task Manager Application is a Kotlin Spring Boot application using MongoDB that allows users to have basic CRUD operations.

The objective of this project it's not the backend itself but to demonstrate how to build and deploy to AWS using CI/CD with GitHub actions.

When a pull request is merged with master after running all the tests it will create a docker image and push it to an ECR that will be used in an ECS.

All of this using Infrastructure as Code (IAC)

## Features

- Create new tasks with a title and description
- Update and delete tasks

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Gradle build tool

## Getting Started

### 1. Clone the repository

```
git clone https://github.com/ivomtdias/task-manager.git
```
### 2. Build the application

```
cd task-manager
./gradlew build
```

### 3. Run the application
```
./gradlew bootRun
```

The application will start running on http://localhost:8080.
