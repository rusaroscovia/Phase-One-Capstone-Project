package Service;

import Model.*;
import exception.*;

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
            throw new StudentEnrolledException("Student a enrolled.");
        }

        course.addStudent(student);
        student.addCourse(course);
    }

    public List<Student> getDeanList() {
        return students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .toList();
    }

    public Optional<Student> getTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }
}