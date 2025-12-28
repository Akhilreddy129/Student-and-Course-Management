package service;

import entity.Student;
import repository.StudentRepository;
import exception.EntityNotFoundException;

import java.util.List;

public class StudentService {
    private StudentRepository repo = new StudentRepository();

    public void addStudent(Student student) { repo.add(student); }

    public void removeStudent(int id) {
        if (repo.findById(id) == null) throw new EntityNotFoundException("Student not found");
        repo.remove(id);
    }

    public void updateStudentEmail(int id, String email) {
        Student s = repo.findById(id);
        if (s == null) throw new EntityNotFoundException("Student not found");
        s.setEmail(email);
    }

    public List<Student> listStudents() { return repo.findAll(); }
}
