This Project is a console-based Student & Course Management System built using Core Java.
It allows admins to manage:
Students
Courses
Enrollments

The project is designed to practice Java fundamentals including:
Variables, data types, control flow
Classes, objects, constructors
Static vs instance members
OOP principles (encapsulation, inheritance, polymorphism)
Collections (ArrayList)
Basic exception handling
Clean, modular code design

Learning Objectives:
By completing LearnTrack, mentees will be comfortable with:
Java setup & compilation (JDK, JRE, JVM basics)
Core Java syntax & packages
OOP fundamentals (constructors, encapsulation, inheritance, polymorphism)
Logic & control flow (if/else, switch, loops)
Collections (ArrayList vs arrays)
Exception handling with try-catch and custom exceptions
Writing clean, readable, modular code

Project Structure:
src/main/java/
 ├── entity/        # Student, Course, Enrollment, Person, Trainer
 ├── enums/         # CourseStatus, EnrollmentStatus
 ├── exception/     # Custom exceptions
 ├── repository/    # In-memory repositories
 ├── service/       # Business logic services
 ├── util/          # IdGenerator, InputValidator
 ├── constants/     # AppConstants, MenuOptions
 └── Main.java      # Console UI
docs/
 ├── Setup_Instructions.md
 ├── JVM_Basics.md
 └── Design_Notes.md


Project Schema Diagram:
src/main/java
│
├── entity
│   ├── Person
│   │    ├── id : int
│   │    ├── firstName : String
│   │    ├── lastName : String
│   │    └── email : String
│   │
│   ├── Student extends Person
│   │    ├── batch : String
│   │    └── active : boolean
│   │
│   ├── Trainer extends Person
│   │    └── expertise : String
│   │
│   ├── Course
│   │    ├── id : int
│   │    ├── courseName : String
│   │    ├── description : String
│   │    ├── durationInWeeks : int
│   │    └── status : CourseStatus
│   │
│   └── Enrollment
│        ├── id : int
│        ├── studentId : int
│        ├── courseId : int
│        ├── enrollmentDate : LocalDate
│        └── status : EnrollmentStatus
│
├── enums
│   ├── CourseStatus { ACTIVE, INACTIVE }
│   └── EnrollmentStatus { ACTIVE, COMPLETED, CANCELLED }
│
├── exception
│   ├── EntityNotFoundException
│   └── InvalidInputException
│
├── repository
│   ├── StudentRepository
│   ├── CourseRepository
│   └── EnrollmentRepository
│
├── service
│   ├── StudentService
│   ├── CourseService
│   └── EnrollmentService
│
├── util
│   ├── IdGenerator
│   └── InputValidator
│
├── constants
│   ├── AppConstants
│   └── MenuOptions
│
└── Main

