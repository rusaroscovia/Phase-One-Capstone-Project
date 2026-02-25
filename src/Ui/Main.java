package Ui;

import Model.*;
import Service.*;
import exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);

        manager.getStudents().addAll(fileManager.loadStudents());
        manager.getCourses().addAll(fileManager.loadCourses());

        while (true) {

            System.out.println("\n1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Student Record");
            System.out.println("5. Dean's List");
            System.out.println("6. Save & Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("ID: ");
                String id = scanner.nextLine();

                System.out.print("Department: ");
                String dept = scanner.nextLine();

                Student s = new UndergraduateStudent(name, email, id, dept) {
                    @Override
                    public String getRole() {
                        return "";
                    }
                };
                manager.registerStudent(s);
            }

            else if (choice == 2) {

                System.out.print("Code: ");
                String code = scanner.nextLine();

                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Credits: ");
                int credits = scanner.nextInt();

                System.out.print("Max Capacity: ");
                int max = scanner.nextInt();
                scanner.nextLine();

                manager.createCourse(new Course(code, title, credits, max));
            }

            else if (choice == 3) {

                System.out.print("Student ID: ");
                String id = scanner.nextLine();

                System.out.print("Course Code: ");
                String code = scanner.nextLine();

                Student student = manager.findStudentById(id);
                Course course = manager.findCourseByCode(code);

                if (student == null || course == null) {
                    System.out.println("Invalid student or course.");
                } else {
                    try {
                        manager.enrollStudentInCourse(student, course);
                        System.out.println("Enrolled successfully.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            else if (choice == 4) {

                System.out.print("Enter Student ID: ");
                String id = scanner.nextLine();

                Student student = manager.findStudentById(id);

                if (student == null) {
                    System.out.println("Student not found.");
                } else {
                    manager.printStudentRecord(student);
                }
            }

            else if (choice == 5) {
                manager.printDeansList();
            }
            else if (choice == 6) {

                System.out.print("Student ID: ");
                String id = scanner.nextLine();

                System.out.print("Course Code: ");
                String code = scanner.nextLine();

                System.out.print("Grade (A-F): ");
                String gradeInput = scanner.nextLine().toUpperCase();

                double grade;

                switch (gradeInput) {
                    case "A": grade = 4.0; break;
                    case "B": grade = 3.0; break;
                    case "C": grade = 2.0; break;
                    case "D": grade = 1.0; break;
                    case "F": grade = 0.0; break;
                    default:
                        System.out.println("Invalid grade.");
                        continue;
                }

                Student student = manager.findStudentById(id);
                Course course = manager.findCourseByCode(code);

                if (student != null && course != null) {
                    student.assignGrade(course, grade);
                    System.out.println("Grade assigned.");
                } else {
                    System.out.println("Invalid student or course.");
                }
            }


            else if (choice == 7) {

                fileManager.saveStudents(manager.getStudents());
                fileManager.saveCourses(manager.getCourses());
                fileManager.saveEnrollments(manager.getStudents());

                System.out.println("Saved.");
                break;
            }
        }

        scanner.close();
    }
}