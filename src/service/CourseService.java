package service;
import entity.Course;
import repository.CourseRepository;
import exception.EntityNotFoundException;
import java.util.List;
public class CourseService {
    private CourseRepository repo = new CourseRepository();
    public void addCourse(Course course) {
        repo.add(course);
    }
    public void removeCourse(int id) {
        if(repo.findById(id)==null) throw new EntityNotFoundException("Course not found");
        repo.remove(id);
    }
    public List<Course> listCourses() { return repo.findAll(); }

}
