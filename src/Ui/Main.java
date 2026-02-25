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

        while (true) {

            System.out.println("\n1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Students");
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

                Student s = new UndergraduateStudent(name, email, id, dept);
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

                manager.createCourse(
                        new Course(code, title, credits, max));
            }

            else if (choice == 3) {

                System.out.print("Student ID: ");
                String id = scanner.nextLine();

                System.out.print("Course Code: ");
                String code = scanner.nextLine();

                try {
                    manager.enrollStudentInCourse(
                            manager.findStudentById(id),
                            manager.findCourseByCode(code)
                    );
                    System.out.println("Enrolled successfully.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            else if (choice == 4) {

                manager.getStudents()
                        .forEach(s ->
                                System.out.println(
                                        s.getStudentId() + " - "
                                                + s.getName()));
            }

            else if (choice == 5) {
                manager.printDeansList();
            }

            else if (choice == 6) {

                fileManager.saveStudents(manager.getStudents());
                fileManager.saveCourses(manager.getCourses());
                fileManager.saveEnrollments(manager.getStudents());

                System.out.println("Saved.");
                break;
            }
        }
    }
}