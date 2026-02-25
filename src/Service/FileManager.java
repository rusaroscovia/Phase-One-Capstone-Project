package Service;

import Model.Course;
import Model.Student;

import java.io.*;
import java.util.List;
import java.util.Map;

public class FileManager {

    public void saveStudents(List<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {
                writer.write(s.getStudentId() + ";" +
                        s.getName() + ";" +
                        s.getDepartment() + ";" +
                        s.getGpa());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    public void saveCourses(List<Course> courses) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("courses.txt"))) {

            for (Course c : courses) {
                writer.write(c.getCourseCode() + ";" +
                        c.getTitle() + ";" +
                        c.getCredits());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    public void saveEnrollments(List<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("enrollments.txt"))) {

            for (Student s : students) {
                for (Map.Entry<Course, Double> entry :
                        s.getEnrolledCourses().entrySet()) {

                    writer.write(s.getStudentId() + ";" +
                            entry.getKey().getCourseCode() + ";" +
                            entry.getValue());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error saving enrollments.");
        }
    }
}