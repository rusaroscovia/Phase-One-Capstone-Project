📚 Academic Hierarchy Management System
Overview

This project implements a console-based University Management System using core Java principles.

It demonstrates:

Object-Oriented Programming (Inheritance, Polymorphism, Encapsulation)

Java Collections (List, Map, Set)

Custom Exception Handling

File Persistence using java.io

Git branching workflow

🧱 Lab Structure
🧪 Lab 1: Object-Oriented Design & Domain Modeling

Abstract Person class

Student and Instructor classes

UndergraduateStudent and GraduateStudent

Course class

Many-to-many relationship using:

List<Student> (Course roster)

Map<Course, Double> (Student grades)

Tuition calculated using method overriding

⚙ Lab 2: Business Logic & Exception Handling

UniversityManager controller class

Custom exceptions:

CourseFullException

StudentAlreadyEnrolledException

GPA calculated dynamically

Dean’s List generation using Java Streams

💾 Lab 3: Persistence & Final Integration

FileManager for saving/loading:

Students

Courses

Console menu-driven interface

Persistent sessions without database

🎯 Features

Register students

Create courses

Enroll students

Assign grades

Calculate GPA

Generate Dean’s List (GPA > 3.5)

Tuition calculation:

Undergraduate → Flat rate

Graduate → Per-credit + research fee

Save & load data from files

🛠 Technologies Used

Java

Java Collections Framework

Java Streams

File I/O (java.io)

Git & GitHub
