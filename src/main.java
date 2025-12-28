import entity.Student;
import entity.Course;
import entity.Enrollment;
import enums.EnrollmentStatus;
import enums.CourseStatus;
import service.StudentService;
import service.CourseService;
import service.EnrollmentService;
import exception.EntityNotFoundException;
import Util.IdGenerator;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter option: ");
            String input = scanner.nextLine();

            try {
                int option = Integer.parseInt(input);

                switch (option) {
                    // Student Management
                    case 1 -> addStudent(scanner);
                    case 2 -> viewAllStudents();
                    case 3 -> searchStudent(scanner);
                    case 4 -> deactivateStudent(scanner);

                    // Course Management
                    case 5 -> addCourse(scanner);
                    case 6 -> viewAllCourses();
                    case 7 -> toggleCourseStatus(scanner);

                    // Enrollment Management
                    case 8 -> enrollStudent(scanner);
                    case 9 -> viewEnrollmentsForStudent(scanner);
                    case 10 -> updateEnrollmentStatus(scanner);

                    case 0 -> {
                        System.out.println("Exiting application...");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add new student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Deactivate student");
        System.out.println("5. Add new course");
        System.out.println("6. View all courses");
        System.out.println("7. Activate/Deactivate course");
        System.out.println("8. Enroll student in course");
        System.out.println("9. View enrollments for a student");
        System.out.println("10. Update enrollment status");
        System.out.println("0. Exit");
    }

    // ---------------- Student Management ----------------
    private static void addStudent(Scanner scanner) {
        int id = IdGenerator.getNextStudentId();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        Student student = new Student(id, firstName, lastName, email, batch, true);
        studentService.addStudent(student);
        System.out.println("Student added successfully with ID " + id);
    }

    private static void viewAllStudents() {
        studentService.listStudents().forEach(s ->
                System.out.println(s.getId() + " - " + s.getDisplayName() + " | Active: " + s.isActive())
        );
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentService.listStudents().stream()
                .filter(st -> st.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        System.out.println("Found: " + s.getDisplayName() + " | Email: " + s.getEmail());
    }

    private static void deactivateStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentService.listStudents().stream()
                .filter(st -> st.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        s.setActive(false);
        System.out.println("Student deactivated.");
    }

    // ---------------- Course Management ----------------
    private static void addCourse(Scanner scanner) {
        int id = IdGenerator.getNextCourseId();
        System.out.print("Course name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Duration (weeks): ");
        int duration = Integer.parseInt(scanner.nextLine());

        Course course = new Course(id, name, desc, duration, CourseStatus.ACTIVE);
        courseService.addCourse(course);
        System.out.println("Course added successfully with ID " + id);
    }

    private static void viewAllCourses() {
        courseService.listCourses().forEach(c ->
                System.out.println(c.getId() + " - " + c.getCourseName() + " | Status: " + c.getStatus())
        );
    }

    private static void toggleCourseStatus(Scanner scanner) {
        System.out.print("Enter course ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Course c = courseService.listCourses().stream()
                .filter(co -> co.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        c.setStatus(c.getStatus() == CourseStatus.ACTIVE ? CourseStatus.INACTIVE : CourseStatus.ACTIVE);
        System.out.println("Course status updated.");
    }

    // ---------------- Enrollment Management ----------------
    private static void enrollStudent(Scanner scanner) {
        int id = IdGenerator.getNextEnrollmentId();
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        Enrollment enrollment = new Enrollment(id, studentId, courseId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        enrollmentService.addEnrollment(enrollment);
        System.out.println("Enrollment created with ID " + id);
    }

    private static void viewEnrollmentsForStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        enrollmentService.listEnrollments().stream()
                .filter(e -> e.getStudentId() == studentId)
                .forEach(e -> System.out.println("Enrollment " + e.getId() + " | Course ID: " + e.getCourseId() + " | Status: " + e.getStatus()));
    }

    private static void updateEnrollmentStatus(Scanner scanner) {
        System.out.print("Enter enrollment ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Enrollment e = enrollmentService.listEnrollments().stream()
                .filter(en -> en.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found"));

        System.out.print("Enter new status (ACTIVE/COMPLETED/CANCELLED): ");
        String status = scanner.nextLine().toUpperCase();
        e.setStatus(EnrollmentStatus.valueOf(status));
        System.out.println("Enrollment status updated.");
    }
}
