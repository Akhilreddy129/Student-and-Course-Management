package service;

import entity.Enrollment;
import repository.EnrollmentRepository;
import exception.EntityNotFoundException;

import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository repo = new EnrollmentRepository();

    public void addEnrollment(Enrollment enrollment) { repo.add(enrollment); }

    public void removeEnrollment(int id) {
        if (repo.findById(id) == null) throw new EntityNotFoundException("Enrollment not found");
        repo.remove(id);
    }

    public List<Enrollment> listEnrollments() { return repo.findAll(); }
}
