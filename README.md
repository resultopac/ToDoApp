# ToDoApp - AI-Powered Sprint Planning Application

A REST API application that allows you to create **daily, weekly, monthly, and yearly routines**. You can also create **sprints** for tasks that need to be completed within specific time periods.

> **Note:** This is a backend-only application. The API can be accessed via Swagger UI and FastAPI documentation interfaces.

## 🚀 Features

- **AI-Powered Planning**  
  Enter your sprint tasks as prompts, and AI will create a **balanced distribution** of tasks across days within your sprint timeframe.

- **Manual Control**  
  Manually edit your sprints, add or remove tasks as needed.

- **Routine Management**  
  Organize your daily, weekly, monthly, and yearly routines.

- **REST API**  
  Complete backend API accessible via Swagger UI.

## 🛠️ Tech Stack

- **Backend:** Java Spring Boot
- **AI Service:** Python (FastAPI)
- **Database:** MySQL
- **API Documentation:** Swagger UI, FastAPI docs

## ⚙️ Setup

### Prerequisites

- Java 17+
- Python 3.8+
- MySQL 8.0+
- Maven

### 1. Clone Repository

```bash
git clone https://github.com/resultopac/ToDoApp.git
cd ToDoApp
```

### 2. Python AI Service

1. Navigate to AI service directory:
   ```bash
   cd src/main/python/ai_service/
   ```

2. Create and activate virtual environment:
   ```bash
   python -m venv venv
   source venv/bin/activate   # Linux / Mac
   venv\Scripts\activate      # Windows
   ```

3. Install requirements:
   ```bash
   pip install -r requirements.txt
   ```

4. Setup environment variables:
    - Copy `env_example.txt` to `.env`
    - Fill in required API keys and variables

5. Start the AI service:
   ```bash
   uvicorn main:app --reload --port 8000
   ```

   ⚠️ **Note:** If using a different port, update the URL in Java `WebClientService` class: `http://localhost:8000/api/create-sprint`

### 3. MySQL Database

1. Start your MySQL server
2. Create a new database:
   ```sql
   CREATE DATABASE todoapp_db;
   ```

### 4. Spring Boot Backend

1. Configure `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todoapp_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## 🚦 API Access

Once both services are running:

- **Spring Boot API:** `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui.html`

- **Python AI Service:** `http://localhost:8000`
    - FastAPI docs: `http://localhost:8000/docs`
    - ReDoc: `http://localhost:8000/redoc`

## 📁 Project Structure

```
ToDoApp/
├── src/
│   └── main/
│       ├── java/            # Java Spring Boot source code
│       ├── resources/       # Configuration files
│       └── python/
│           └── ai_service/  # Python AI service
└── README.md
```

## 🤝 Contributing

1. Fork this repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

---

## 📌 Notes

- AI service and Java Spring application work together
- Make sure MySQL connection is properly configured
- Don't forget to fill in all variables in `.env` file
- This is a work-in-progress project