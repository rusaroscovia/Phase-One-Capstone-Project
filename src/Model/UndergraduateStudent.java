package Model;

public class UndergraduateStudent extends Student {

    private static final double FLAT_RATE = 1500;

    public UndergraduateStudent(String name, String email,
                                String id, String department) {
        super(name, email, id, department);
    }

    @Override
    public double calculateTuition() {
        return FLAT_RATE;
    }
}