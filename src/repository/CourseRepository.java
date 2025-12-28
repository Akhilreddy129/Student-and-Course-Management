package repository;

import entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void add(Course course) { courses.add(course); }
    public void remove(int id) { courses.removeIf(c -> c.getId() == id); }
    public Course findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    public List<Course> findAll() { return courses; }
}
