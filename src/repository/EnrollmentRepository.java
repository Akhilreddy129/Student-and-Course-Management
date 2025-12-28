package repository;

import entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void add(Enrollment enrollment) { enrollments.add(enrollment); }
    public void remove(int id) { enrollments.removeIf(e -> e.getId() == id); }
    public Enrollment findById(int id) {
        return enrollments.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public List<Enrollment> findAll() { return enrollments; }
}
