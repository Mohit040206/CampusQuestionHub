# Campus Question Hub

A full-stack web application designed to manage and access academic question papers securely. This platform provides role-based access for **Admins** and **Students**, enabling seamless upload, search, and download of past year papers across various courses.

---

## 🚀 Tech Stack

- **Backend**: Spring Boot (Java)
- **Frontend**: HTML + CSS (no JavaScript)
- **Database**: MySQL
- **Security**: Spring Security, BCrypt for password encryption
- **Tools**: Maven, IntelliJ/VS Code, Git, GitHub

---

## 🔐 Features (Completed)

- ✅ Admin & Student login with role-based authentication
- ✅ Student registration with validation (name, email, student ID, phone number)
- ✅ Passwords encrypted using BCrypt
- ✅ Landing page with dropdown menus for navigation
- ✅ UI theming consistent across pages
- ✅ GitHub integration with full version control

---

## ⚙️ How to Run (Local Setup)

1. **Clone this repo**:
   ```bash
   git clone https://github.com/Mohit040206/CampusQuestionHub.git
   cd CampusQuestionHub
   ```
2. **Open in your IDE** (IntelliJ, VS Code, etc.)
3. **Create MySQL database**:
   ```sql
   CREATE DATABASE campus_question_hub;
   ```
4. **Update `application.properties`** with your DB username/password
5. **Run the project**:
   ```bash
   ./mvnw spring-boot:run
   ```
6. **Access the app**:
   Navigate to `http://localhost:8080`

---

## 🛠 Work in Progress

- [ ] Admin upload feature (papers by Course/Subject/Year)
- [ ] Student dashboard to search and download files
- [ ] College-wise registration and secure document access
- [ ] Cloud storage integration (future scope)

---

## 📸 Screenshots
*(Coming soon — after frontend upload/search pages are built)*

---

## 📄 License
MIT License

---

## 🙋‍♂️ Developer
**Mohit Kumar Das**  
*Aspiring Software Developer | Java & Spring Boot Enthusiast*  
[GitHub Profile](https://github.com/Mohit040206)

---

Feel free to star ⭐ the repo or contribute suggestions/feedback!
