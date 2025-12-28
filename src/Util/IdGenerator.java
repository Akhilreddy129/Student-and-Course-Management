package Util;

public class IdGenerator {
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;
    private static int enrollmentIdCounter = 1;

    private IdGenerator() {}

    public static int getNextStudentId() {
        return studentIdCounter++;
    }

    public static int getNextCourseId() {
        return courseIdCounter++;
    }

    public static int getNextEnrollmentId() {
        return enrollmentIdCounter++;
    }

    public static void reset() {
        studentIdCounter = 1;
        courseIdCounter = 1;
        enrollmentIdCounter = 1;
    }
}
