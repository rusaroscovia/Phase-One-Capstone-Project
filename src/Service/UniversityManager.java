package Service;

import Model.Course;
import Model.Student;
import exception.CourseException;
import exception.StudentEnrolledException;

import java.util.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course)
            throws CourseException, StudentEnrolledException {

        if (course.getRoster().size() >= course.getMaxCapacity()) {
            throw new CourseException("Course is full.");
        }

        if (student.getEnrolledCourses().containsKey(course)) {
            throw new StudentEnrolledException("Student already enrolled.");
        }

        course.addStudent(student);
        student.addCourse(course);
    }

    public Student findStudentById(String id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Course findCourseByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCourseCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public void printDeansList() {
        students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .forEach(s ->
                        System.out.println(s.getStudentId()
                                + " - " + s.getName()
                                + " | GPA: " + s.getGpa()));
    }

    public List<Student> getStudents() { return students; }

    public List<Course> getCourses() { return courses; }
}