package Model;

public abstract class GraduateStudent extends Student {

    private static final double PER_CREDIT_RATE = 300.0;
    private static final double RESEARCH_FEE = 500.0;

    public GraduateStudent(String name, String email, String id, String dept) {
        super(name, email, id, dept);
    }

    @Override
    public double calculateTuition() {

        int totalCredits = getEnrolledCourses()
                .keySet()
                .stream()
                .mapToInt(course -> course.getCredits())
                .sum();

        return (totalCredits * PER_CREDIT_RATE) + RESEARCH_FEE;
    }
}