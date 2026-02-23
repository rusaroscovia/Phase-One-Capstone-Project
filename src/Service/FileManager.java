package Service;

import Model.Student;

import java.io.*;
import java.util.List;

public class FileManager {

    public void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.csv"))) {
            for (Student s : students) {
                writer.write(s.getStudentId() + "," +
                        s.getName() + "," +
                        s.getDepartment() + "," +
                        s.getGpa());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}