# 🏫 Campus Question Hub

**Campus Question Hub** is a secure full-stack Java web application that allows **Admins** to upload academic papers and **Students** to view or download them. It features **role-based access**, session management, and a clean, responsive UI with zero JavaScript.

---

## 🚀 Tech Stack

| Layer     | Technology Used             |
|-----------|------------------------------|
| Backend   | Java 21, Spring Boot 3.3.1   |
| Frontend  | HTML, CSS (No JS used)       |
| Database  | MySQL                        |
| Security  | Spring Security 6.3          |
| Build     | Maven                        |

---

## 📌 Core Features

### 👨‍🎓 Student Registration & Login
- Fields: Name, Email, Password, Student ID, Phone Number
- Login with Email/Password
- Passwords stored using `BCrypt`
- Session-based redirection to Student Homepage

### 👨‍🏫 Admin Login
- Admin login only (no self-registration)
- Upload papers with Title, Subject, Course, Year, PDF file
- Full backend + frontend support for uploads

### 🔐 Authentication & Authorization
- Role-based navigation (Admin vs Student)
- Custom Spring Security configuration
- CSRF disabled for REST-friendly form submissions
- Session timeout after inactivity (20 minutes)
- Browser back button disabled post-logout

### 📄 Unified View & Download Papers (Merged UI)
- One shared UI for both viewing and downloading papers
- Clean **card-based layout** using Thymeleaf
- Display includes Title, Subject, Year, Course
- Download button per paper with backend validation
- Accessible to both Students and Admins

### 📤 Upload Papers (Admin Only)
- Upload PDFs tagged with metadata (Title, Year, etc.)
- File stored in local server directory
- Info saved in MySQL DB

### 📘 About Page
- Informational page about the platform
- Styled with consistent HTML/CSS theme

### 🚪 Logout & Session Handling
- Proper logout and session invalidation
- No unauthorized access after logout
- Footer remains sticky and responsive

---

## ✅ Feature Enhancements (2–8 July 2025)

During this phase, we made major improvements focused on **security**, **usability**, and **architecture**:

- 🔁 **Fixed login session caching and back button bug**
- 📤 **Added Upload Page** for Admin with complete backend
- 🧩 **Merged "View" and "Download" into a single UI**
  - Reduced complexity, improved usability
  - Same layout for both roles
- 📘 **Added About Page** with unified styling
- 🚫 **Fixed white-label errors** and authentication redirects
- 🪪 **Enhanced logout/session handling**
- 🎨 **Footer layout and consistency improved across all pages**

---

## 🗂 Project Structure

campusquestionhub/
├── controller/
│ ├── AdminController.java
| ├── CommonController.java
│ ├── PaperController.java
│ ├── StudentController.java
│ ├── ViewDownloadPaperController.java
├── model/
│ ├── Admin.java
│ ├── Student.java
│ ├── Paper.java
├── repository/
│ ├── AdminRepository.java
│ ├── StudentRepository.java
│ ├── PaperRepository.java
├── service/
│ ├── AdminService.java
├── config/
│ ├── SecurityConfig.java
│ ├── NoCacheFilter.java
├── templates/
│ ├── upload.html
│ ├── downloadpapers.html
├── static/
| ├── about.html
| ├── adminhome.html
| ├── index.html
| ├── login.html
| ├── registration.html
│ ├── studenthome.html
│ ├── studentlogin.html


---

## 🧪 Run the Project Locally


# Clone the repository
git clone https://github.com/Mohit040206/CampusQuestionHub.git
cd CampusQuestionHub

# Set up MySQL DB and update credentials in `.env`

# Run the Spring Boot application
mvn spring-boot:run


 📈 Growth & Future Scope
We're proud of the progress so far and plan to add more enterprise-level features:

🔮 Planned Enhancements
🧠 AI Chatbox Integration

Using Spring AI or OpenAI API

Students can ask about paper availability, subjects, years, etc.

🏛️ Multi-College Support

Each college has a unique secure code

Teachers/Admins associated with specific colleges

Students can only register if verified via their Student ID + College

🗂️ Advanced Search Filters

Filter by Year, Subject, or Course

Possibly category-based paper organization

📊 Admin Dashboard

Upload stats, user activity logs, etc.

📸 Sample UI
   🏠 Home Page
   ![image](https://github.com/user-attachments/assets/ac1e06b4-c92a-4df9-95bf-9738e0c775bc)
   
   ABOUT PAGE 
   ![image](https://github.com/user-attachments/assets/f90a85ce-b55d-4f99-a3bb-9d3fe1ef5738)
   
   STUDENT REGISTRATION PAGE
   ![image](https://github.com/user-attachments/assets/f075956e-997a-4b80-b280-579b84771a56)
   
   STUDENT LOGIN PAGE
   ![image](https://github.com/user-attachments/assets/b44ea58b-311f-4783-b3c9-3623ee135c45)
   
   STUDENT HOME PAGE
   ![image](https://github.com/user-attachments/assets/7daec765-5e86-4840-bf2c-3f083832fa8e)
   
   ADMIN/STUDENT DOWNLOAD PAGE (UPLOAD NOT WORKING FOR STUDENT)
   ![image](https://github.com/user-attachments/assets/249c3eb2-e4ba-4df1-ad06-42c7e3b3baaa)

   ADMINHOME PAGE 
   ![image](https://github.com/user-attachments/assets/a83f2c4a-2391-4f10-8393-5dbaba5b5b08)

   UPLOAD PAPER PAGE
   ![image](https://github.com/user-attachments/assets/cb9cfc38-8cdb-4f3f-9990-b931f874710a)

   🙌 Contributing
Pull requests are welcome. For major changes, open an issue first to discuss what you’d like to change.

🛡️ License
This project is open-source and free to use under the MIT License.






   









