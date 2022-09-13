# Student Management System (CRUD)

## Introduction
The purpose of this personal project is to build a Student Management System. Administrators can search, add, or edit information pertaining to students of a hypothetical higher educational institution. This project attempts to showcase several skills including but not limited to object-oriented programming, Java, Spring Boot, testing, crud operations, input validation, and controller-service-repository pattern.

## Tasks
Tasks are added and refined at ongoing basis - more to come.

### Project Management
- [x] Initialize project with start.spring.io
- [x] Determine initial dependencies needed for project
- [x] Create GitHub repo
- [x] Define purpose of this project in README.md
- [ ] Deploy project

### Design Decisions
- [x] Design and decompose objects in specs.md
- [ ] Decide whether to use in-memory or disk storage
- [x] Should I separate model and entity
- [x] Should Student constructor have an argument for Course
- [ ] Should I modify entity then push to DB, or modify DB then make changes on entity?

### Project Skeleton
- [x] Create initial controller-service-repository directories
- [ ] Implement validation

### Student CRUD Operations
- [x] GET all students
- [x] Create a student
- [x] GET a student by ID
- [x] GET all student matching name
- [x] Delete a student
- [x] Update a student

### Exception Handling
- [x] Implement StudentNotFoundException
- [ ] Implement IllegalFacultyException

### Database
- [x] Connect to H2 Database
- [ ] For best practice, annotate entity columns (eg. column, table, unique constraint, etc.)
- [ ] If using in-memory, implement a loadSampleData() method
- [x] Figure out how to hide sensitive data like db connection

### Business Logic
- [ ] Brainstorm list of university policies for use as business logic
- [ ] Implement method to calculate total tuition owed by a student
- [ ] Add Course(s) to Student, students can't take the same course twice in one semester. Max 7 courses

### Testing
- [x] Test Repository layer (Note: Do not need to test JpaRepository methods. You didn't write them.)
- [ ] Test Service layer
- [ ] Test Controller layer




...more information to come