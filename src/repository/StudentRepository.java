package repository;

import entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) { students.add(student); }
    public void remove(int id) { students.removeIf(s -> s.getId() == id); }
    public Student findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
    public List<Student> findAll() { return students; }
}
