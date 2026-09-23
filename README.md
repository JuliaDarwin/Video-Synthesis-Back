# Video Synthesis - Backend API (`tfmBack`)

> The backend RESTful API powering the **Video Synthesis** platform, a specialized video editing and motion graphics portfolio for ocean science and marine conservation.

This repository serves as the core data processing and business logic layer. It handles secure authentication, manages case study content, processes form submissions, and interacts with external services like Resend for email notifications.

## 🚀 Tech Stack

- **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
- **Language:** Java 21
- **Database:** MongoDB
- **Security:** Spring Security + JWT (JSON Web Tokens)
- **Integrations:** [Resend API](https://resend.com/) (Email sending), OkHttp3
- **Testing:** JUnit 5, Mockito, Spring Boot Test

## ✨ Key Features

- **Secure Authentication:** User login and session management powered by Spring Security and JWT.
- **Content Management API:** CRUD operations for portfolio case studies.
- **File Uploads:** Endpoint handling for secure media and document uploads.
- **Email Notifications:** Automated email dispatch via the Resend API for contact forms and estimate requests.
- **Role-Based Access Control:** Differentiates between public access and administrative actions.

## 📋 Prerequisites

Before running the backend, make sure you have the following installed:
- **Java Development Kit (JDK) 21**
- **Maven** (optional, as the Maven Wrapper `mvnw` is included)
- **MongoDB** (running locally or a cloud URI like MongoDB Atlas)

## 🛠️ Environment Variables

The application requires specific environment variables to function correctly, particularly for security and third-party integrations. Ensure the following are set in your environment or within your `application-local.properties` / `application.properties`:

```properties
# Example configuration
RESEND_API_KEY=your_resend_api_key_here
JWT_SECRET=your_very_long_secure_jwt_secret_key_here
spring.data.mongodb.uri=mongodb://localhost:27017/your_db_name
```

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd tfmBack
   ```

2. **Run the application using Maven Wrapper:**

   *On macOS / Linux:*
   ```bash
   ./mvnw spring-boot:run
   ```
   *On Windows:*
   ```cmd
   mvnw.cmd spring-boot:run
   ```

The server will start by default on `http://localhost:8080`.

## 🏗️ Building the Executable

To build a standalone executable JAR file:
```bash
./mvnw clean package
```
The compiled `.jar` will be located in the `target/` directory and can be run using `java -jar target/tfmBack-0.0.1-SNAPSHOT.jar`.

## 🧪 Testing

To run the automated test suite:
```bash
./mvnw test
```

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the issues page.
