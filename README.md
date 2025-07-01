🏫 Campus Question Hub
Campus Question Hub is a secure full-stack Java web application that allows Admins to upload academic papers and Students to view and download them. It provides clean role-based access with session and security management.

🚀 Tech Stack
Layer	Technology Used
Backend	Java 21, Spring Boot 3.3.1
Frontend	HTML, CSS (No JS used)
Database	MySQL
Security	Spring Security 6.3
Build	Maven

📌 Core Features
👨‍🎓 Student Registration & Login

Email, Password, Student ID, Phone

Session-based login redirection

👨‍🏫 Admin Login

Secure backend-only login (no registration)

Upload PDF papers by title, course, subject, year

🔐 Authentication & Authorization

Role-based navigation (Admin/Student)

Spring Security custom config

Session timeout & logout handling

📂 View Papers

Dynamic paper listing from database

Thymeleaf-based template

Card UI for clean paper display

⬇️ Download Papers

Available to both Students and Admins

Based on paper ID

🛡️ Security Enhancements

CSRF disabled (custom auth)

Browser back-button disabled after logout

No unauthorized page access without login

🗂 Project Structure

campusquestionhub/
├── controller/
│   ├── AuthController.java
│   ├── ViewPaperController.java
├── model/
│   ├── Admin.java
│   ├── Student.java
│   ├── Paper.java
├── repository/
│   ├── AdminRepository.java
│   ├── StudentRepository.java
│   ├── PaperRepository.java
├── service/
│   ├── AdminService.java
│   ├── StudentService.java
├── config/
│   ├── SecurityConfig.java
│   ├── NoCacheFilter.java
├── templates/
│   ├── viewpapers.html
│   └── (Thymeleaf based)
└── static/
    ├── index.html
    ├── studentlogin.html
    ├── adminhome.html
    ├── etc.
✅ July 1, 2025 - Updates Summary
✅ Created ViewPaperController to render data from DB.

✅ Added Thymeleaf template: viewpapers.html for paper cards.

✅ Configured session checks to restrict unauthorized access.

✅ Disabled page caching post-logout using a global filter.

✅ Fixed template rendering issues.

✅ SecurityConfig updated to allow viewpapers route properly.

✅ Tested logout navigation and fixed browser back button issue.

✅ All working perfectly now!


### Student Home Page
![homepage](https://github.com/user-attachments/assets/87cefd2a-836e-45d9-97f9-9d276f8fd229)




📦 Run the Project Locally
Clone the repository:


git clone https://github.com/Mohit040206/CampusQuestionHub.git
cd CampusQuestionHub
Set up your MySQL DB and update application.properties.

Run the app:
mvn spring-boot:run
