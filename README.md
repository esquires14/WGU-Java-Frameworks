Bits & Bytes Custom PC Shop - Spring Boot E-Commerce Application
A full-stack e-commerce web application for a custom PC parts and systems shop, built with Spring Boot and Thymeleaf. Features comprehensive inventory management, validation, and purchasing capabilities.
🎓 Academic Context
Completed as part of D287 - Java Frameworks coursework at Western Governors University (December 2025)
🚀 Features
Core Functionality

Product & Parts Management - Full CRUD operations for PC components and complete systems
Inventory Tracking - Real-time inventory with minimum/maximum stock level enforcement
Purchase System - "Buy Now" functionality with automatic inventory decrementing
Validation System - Comprehensive validation to prevent overselling and maintain stock levels
Responsive UI - Custom-styled Thymeleaf templates with Bootstrap

Inventory Management

Add, update, and delete parts (in-house and outsourced)
Add, update, and delete complete PC systems
Set and enforce minimum/maximum inventory thresholds
Automatic validation prevents inventory from falling below minimum or exceeding maximum

Business Logic

Parts can be associated with multiple products
Purchasing a product decrements product inventory only (parts remain unchanged)
Success/failure messages for all transactions
Error handling for invalid inventory operations

🛠️ Technologies Used
Backend:

Java 11+
Spring Boot 2.x
Spring Data JPA
Hibernate
H2 Database (development)
Maven

Frontend:

Thymeleaf
HTML5/CSS3
Bootstrap 4

Testing:

JUnit
Spring Boot Test

📋 Prerequisites

JDK 11 or higher
Maven 3.6+
IDE (IntelliJ IDEA recommended)

⚙️ Installation & Setup

Clone the repository

bashgit clone https://github.com/esquires14/WGU-Java-Frameworks-PC-Shop.git
cd WGU-Java-Frameworks-PC-Shop

Build the project

bashmvn clean install

Run the application

bashmvn spring-boot:run

Access the application


Main page: http://localhost:8080
About page: http://localhost:8080/about
H2 Console: http://localhost:8080/h2-console (if enabled)

📦 Sample Inventory
The application comes pre-loaded with sample data:
Parts (5):

CPU, GPU, RAM, Storage, Power Supply
Each with configurable min/max inventory levels

Products (5):

Complete PC systems (Gaming, Workstation, Budget, etc.)
Associated parts for each build

🧪 Testing
Run unit tests:
bashmvn test
```

## 📁 Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── bootstrap/       # Data initialization
│   │       ├── controllers/     # Spring MVC controllers
│   │       ├── domain/          # Entity classes
│   │       ├── repositories/    # JPA repositories
│   │       ├── services/        # Business logic
│   │       └── validators/      # Custom validators
│   └── resources/
│       ├── templates/           # Thymeleaf views
│       └── application.properties
└── test/
└── java/                    # Unit tests
📝 License
This project was completed as academic coursework. Please refer to your institution's academic integrity policy before using this code.
👤 Author
Emily Squires

GitHub: @esquires14
LinkedIn: emily-squires-swe
