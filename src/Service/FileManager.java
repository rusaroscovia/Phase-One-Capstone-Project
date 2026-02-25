package Service;

import Model.Course;
import Model.Student;
import Model.UndergraduateStudent;

import java.io.*;
import java.util.*;

public class FileManager {

    private static final String STUDENT_FILE = "students.txt";
    private static final String COURSE_FILE = "courses.txt";



    public void saveStudents(List<Student> students) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(STUDENT_FILE))) {

            for (Student s : students) {
                writer.println(
                        s.getStudentId() + ";" +
                                s.getName() + ";" +
                                s.getDepartment()
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    public void saveCourses(List<Course> courses) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(COURSE_FILE))) {

            for (Course c : courses) {
                writer.println(
                        c.getCourseCode() + ";" +
                                c.getTitle() + ";" +
                                c.getCredits() + ";" +
                                c.getMaxCapacity()
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    public void saveEnrollments(List<Student> students) {

    }



    public List<Student> loadStudents() {

        List<Student> students = new ArrayList<>();

        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                if (data.length >= 3) {

                    Student s = new UndergraduateStudent(
                            data[1],
                            "loaded@email.com",
                            data[0],
                            data[2]
                    ) {
                        @Override
                        public String getRole() {
                            return "";
                        }
                    };

                    students.add(s);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading students.");
        }

        return students;
    }

    public List<Course> loadCourses() {

        List<Course> courses = new ArrayList<>();

        File file = new File(COURSE_FILE);

        if (!file.exists()) {
            return courses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                if (data.length >= 4) {

                    Course c = new Course(
                            data[0],
                            data[1],
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3])
                    );

                    courses.add(c);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading courses.");
        }

        return courses;
    }
}