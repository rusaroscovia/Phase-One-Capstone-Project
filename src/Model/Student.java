package Model;

import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {

    private String studentId;
    private double gpa;
    private String department;

    // Many-to-many relationship
    private Map<Course, Double> enrolledCourses = new HashMap<>();

    public Student(String name, String email, String studentId, String department) {
        super(name, email);
        this.studentId = studentId;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public String getDepartment() {
        return department;
    }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        enrolledCourses.put(course, 0.0);
    }

    public void updateGrade(Course course, double grade) {
        enrolledCourses.put(course, grade);
        calculateGPA();
    }

    private void calculateGPA() {
        double total = enrolledCourses.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        this.gpa = total;
    }

    public abstract double calculateTuition();

    @Override
    public String getRole() {
        return "Student";
    }
}