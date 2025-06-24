# Campus Question Hub

A full-stack web application built with Spring Boot that allows **Admin users** to securely upload academic question papers categorized by Course, Subject, and Year. The application supports **role-based login** and provides students with access to browse and download papers (feature coming soon).

---

## 🚀 Tech Stack

- **Backend:** Spring Boot (Java)
- **Frontend:** HTML + CSS (No JavaScript)
- **Database:** MySQL
- **Security:** Spring Security + BCrypt (for password encryption)
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA
- **Version Control:** Git & GitHub

---

## ✅ Features Implemented

- Admin & Student login (via custom login forms)
- Student registration with:
  - Full form validation
  - Fields: Name, Email, Student ID, Phone Number, Password
- Passwords encrypted using BCrypt
- Landing page with role dropdowns (Admin / Student)
- Admin functionalities:
  - Upload PDF-based question papers (Course, Subject, Year)
  - View list of uploaded papers
  - Download any paper by ID
- Secure file storage using `@Lob` (stores PDF as byte[])
- GitHub connected — all versions committed

---

## ⚙️ How to Run (Local Setup)

bash
git clone https://github.com/Mohit040206/CampusQuestionHub.git
cd CampusQuestionHub
Open the project in IntelliJ IDEA (or your favorite IDE)

Set up your MySQL database:

sql
Copy
Edit
CREATE DATABASE campus_question_hub;
Update src/main/resources/application.properties with your DB credentials

Run the application:
./mvnw spring-boot:run
Open the browser and go to:
http://localhost:8080

🛠 Work in Progress
🔄 Student functionality to:

View list of papers

Download specific papers

🔐 Role-based redirection (post login)

🧠 Search functionality (filter by Course/Subject/Year)

📤 File validation & size limit

☁️ Future Scope: Cloud integration for storage (AWS S3, Firebase, etc.)

🧑‍🏫 Multi-college registration and ID verification system

📸 Screenshots
Coming soon — after full UI integration of paper list & search/download features.

📄 License
This project is licensed under the MIT License.

🙋‍♂️ Developer
Mohit Kumar Das
Aspiring Software Developer | Java & Spring Boot Enthusiast
GitHub Profile

Feel free to ⭐ star this repo or submit ideas via Issues or PRs!



