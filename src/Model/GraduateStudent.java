package Model;

public class GraduateStudent extends Student {

    private static final double PER_CREDIT = 300;
    private static final double RESEARCH_FEE = 1000;

    public GraduateStudent(String name, String email, String id, String department) {
        super(name, email, id, department);
    }

    @Override
    public double calculateTuition() {
        return (getEnrolledCourses().size() * PER_CREDIT) + RESEARCH_FEE;
    }
}