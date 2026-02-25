package Model;

import java.util.HashMap;
import java.util.Map;

public abstract class Student extends Person {

    private String studentId;
    private String department;
    private Map<Course, Double> enrolledCourses;

    public Student(String name, String email, String studentId, String department) {
        super(name, email);
        this.studentId = studentId;
        this.department = department;
        this.enrolledCourses = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        enrolledCourses.put(course, null);
    }

    public void assignGrade(Course course, double grade) {

        if (!enrolledCourses.containsKey(course)) {
            System.out.println("Student not enrolled in this course.");
            return;
        }

        enrolledCourses.put(course, grade);
    }

    public double getGpa() {

        double totalPoints = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, Double> entry : enrolledCourses.entrySet()) {

            Double grade = entry.getValue();

            if (grade != null) {

                int credits = entry.getKey().getCredits();

                totalPoints += grade * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalPoints / totalCredits;
    }

    public abstract double calculateTuition();
}