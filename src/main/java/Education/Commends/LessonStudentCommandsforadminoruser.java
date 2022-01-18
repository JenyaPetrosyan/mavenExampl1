package Education.Commends;

public interface LessonStudentCommandsforadminoruser {

    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENTS = "3";
    String PRINT_STUDENTS_BY_LESSON = "4";
    String PRINT_LESSONS = "5";
    String DELETE_LESSON_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";
    String LOGOUT = "8";

    static void printCommandsAdmin() {
        System.out.println("please input " + EXIT + " for EXIT");
        System.out.println("please input " + ADD_LESSON + " FOR ADD_LESSON");
        System.out.println("please input " + ADD_STUDENT + " FOR ADD_STUDENT");
        System.out.println("please input " + PRINT_STUDENTS + " for PRINT_STUDENTS ");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for PRINT_STUDENTS_BY_LESSON");
        System.out.println("please input " + PRINT_LESSONS + " for PRINT_LESSONS");
        System.out.println("please input " + DELETE_LESSON_BY_NAME + " for DELETE_LESSON_BY_NAME ");
        System.out.println("please input " + DELETE_STUDENT_BY_EMAIL + " for DELETE_STUDENT_BY_EMAIL");
        System.out.println("please input " + LOGOUT + " for LOGOUT");
    }

    static void printCommandsUser() {
        System.out.println("please input " + EXIT + " for EXIT");
        System.out.println("please input " + ADD_LESSON + " FOR ADD_LESSON");
        System.out.println("please input " + ADD_STUDENT + " FOR ADD_STUDENT");
        System.out.println("please input " + PRINT_STUDENTS + " for PRINT_STUDENTS ");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for PRINT_STUDENTS_BY_LESSON");
        System.out.println("please input " + PRINT_LESSONS + " for PRINT_LESSONS");
        System.out.println("please input " + LOGOUT + " for LOGOUT");

    }

}
