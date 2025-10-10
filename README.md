# Group Assignment: School Management System
## How to start the School Management System
### IntelliJ
1. Clone the repository.
2. Goto **File** -> **Open** -> Select **school-management-system**
3. If your IDE doesn't automatically recognize the `\lib` directory, goto **File** -> **Project structure...** ->
   **Libraries** -> Hit the `+` and add the `\lib` directory (that contains all necessary Jackson `.jar`-files)
4. Run from `Main.java`

## Background
You are a development team that has been assigned to create a **School Management System** in **Java**.
The system will help a school keep track of **students, teachers, courses and grades**.
You will work **agilely** in a group and use **GitHub Projects** for planning, monitoring and collaboration.

The goal is to plan, build and present a functioning system over the course of a week.

---

## Purpose
* Practice **agile working methods** (planning, sprints, roles, GitHub Projects)
* Use **OOP (Object-Oriented Programming)** in a larger context
* Develop **collaboration skills** and **responsibility in group work**
* Learn to **divide a larger project** into manageable parts

---

## The task
You will plan and develop a **School Management System** together that can at least:
### Basic requirements
1. [ ] **1)** Manage students, teachers and courses
2. [ ] **2)** Link students to courses
3. [x] **3)** Add and display grades
4. [ ] **4)** Display lists (e.g. students in a course with their grades)
5. [x] **5)** Save and load data (e.g. from text file or `JSON`)
### OOP requirements
The project should show that you can use:
* **Inheritance** (e.g. `Person` → `Student` and `Teacher`)
* **Encapsulation** (private variables with getters/setters)
* **Polymorphism** (e.g. different types of users or grades)
* **Interface or abstract class** where appropriate
### Extra for higher level
If you complete the basic requirements, you can add, for example:
* Login (teacher/student/administrator)
* Statistics (e.g. average grade)
* Schedule generator
* Import/export of data

---

## Classes (suggestions)
You can choose the exact structure yourself, but an example is:
* `Person` (superclass)
* `Student`
* `Teacher`
* `Course`
* `Grade`
* `SchoolSystem` (the main class that manages the whole thing)

---

## Roles in the group
Each group should have:
* **Scrum Master** – leads group meetings, makes sure you follow the plan
* **Product Owner** – is responsible for meeting the requirements of the task
* **Developer** – codes, tests and documents
Everyone participates in planning and coding, but with different focuses.

---

## Working method
You should use agile working methods:
### Create repository and Project Board
* [x] Create a **GitHub repository** for the project.
* [x] Create a **Project Board** with columns:
  * **Product Backlog** – all features/tasks you plan to do
  * **To Do** – tasks you will do during the sprint
  * **In Progress** – tasks that someone is currently working on
  * **Done** – completed tasks

---

## Presentation
On Friday (10th Oct.) you will:
1. **Showcase your program** (how it works)
2. **Tell us how you worked agile**
3. **Show your GitHub Project Board**
4. **Tell us what you learned and how the collaboration worked**

---

## Tips
* Divide the project into **small issues** – “one thing per issue”
* Use **commit messages** that describe what you have done
* Test the code often
* Work in **branches**, not directly in main
* Have **short daily standups**