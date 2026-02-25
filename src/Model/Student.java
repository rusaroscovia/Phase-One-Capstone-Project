package Model;

import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {

    private String studentId;
    private String department;
    private double gpa;

    private Map<Course, Double> enrolledCourses = new HashMap<>();

    public Student(String name, String email, String studentId, String department) {
        super(name, email);
        this.studentId = studentId;
        this.department = department;
    }

    public String getStudentId() { return studentId; }

    public String getDepartment() { return department; }

    public double getGpa() { return gpa; }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        enrolledCourses.put(course, null);
    }

    public void updateGrade(Course course, double grade) {
        enrolledCourses.put(course, grade);
        calculateGpa();
    }

    private void calculateGpa() {
        gpa = enrolledCourses.values().stream()
                .filter(g -> g != null)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public abstract double calculateTuition();

    @Override
    public String getRole() {
        return "Student";
    }
}