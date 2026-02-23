package Ui;

import Service.*;
import Model.*;
import exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Academic Hierarchy ===");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                Student s = new UndergraduateStudent(
                        "Rusaro", "rusaro@email.com", "U001", "IT"
                );
                manager.registerStudent(s);
                System.out.println("Student Registered!");
            }

            else if (choice == 2) {
                Course c = new Course("CSE823", ".NET", 4, 30);
                manager.createCourse(c);
                System.out.println("Course Created!");
            }

            else {
                break;
            }
        }
    }
}