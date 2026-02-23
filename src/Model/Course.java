package Model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String title;
    private int credits;
    private int maxCapacity;

    private List<Student> roster = new ArrayList<>();

    public Course(String courseCode, String title, int credits, int maxCapacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
    }

    public List<Student> getRoster() {
        return roster;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void addStudent(Student student) {
        roster.add(student);
    }
}