package constants;

public final class AppConstants {
    private AppConstants() {}

    public static final String APP_NAME = "Student and Course Management System";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    // Prompts
    public static final String PROMPT_OPTION = "Enter option: ";
    public static final String PROMPT_FIRST_NAME = "First name: ";
    public static final String PROMPT_LAST_NAME = "Last name: ";
    public static final String PROMPT_EMAIL = "Email: ";
    public static final String PROMPT_BATCH = "Batch: ";
    public static final String PROMPT_COURSE_NAME = "Course name: ";
    public static final String PROMPT_DESCRIPTION = "Description: ";
    public static final String PROMPT_DURATION_WEEKS = "Duration (weeks): ";
    public static final String PROMPT_STUDENT_ID = "Student ID: ";
    public static final String PROMPT_COURSE_ID = "Course ID: ";
    public static final String PROMPT_ENROLLMENT_ID = "Enrollment ID: ";
    public static final String PROMPT_ENROLLMENT_STATUS = "New status (ACTIVE/COMPLETED/CANCELLED): ";

    // Messages
    public static final String MSG_INVALID_OPTION = "Invalid option. Please try again.";
    public static final String MSG_INVALID_NUMBER = "Invalid input. Please enter a number.";
    public static final String MSG_EXITING = "Exiting application...";
}
