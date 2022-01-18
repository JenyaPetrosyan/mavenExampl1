package Education;
import Education.Commends.LessonStudentCommandsforadminoruser;
import Education.Commends.LoginRegisterCommands;
import Education.Exception.IllegalArgumentException;
import Education.Exception.UserNotFoundException;
import Education.Model.Lesson;
import Education.Model.Student;
import Education.Model.Type;
import Education.Model.User;
import Education.Storage.LessonStorage;
import Education.Storage.StudentStorige;
import Education.Storage.UserStorige;
import Education.Util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static Education.Commends.LoginRegisterCommands.*;


public class LessonStudentTest implements LessonStudentCommandsforadminoruser  {
    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorige studentStorage = new StudentStorige();
    static UserStorige userStorage = new UserStorige();


    public static void main(String[] args) throws IllegalArgumentException {
        initData();
        boolean isRun1 = true;
        while (isRun1) {
            LoginRegisterCommands.printCommands();
            String command1 = scanner.nextLine();
            switch (command1) {
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case LoginRegisterCommands.EXIT:
                    System.exit(0);
                    break;
                case PRINTUSER:
                    printuser();
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }

    private static void initData() {
        userStorage.initData();
        lessonStorage.initData();
        studentStorage.initData();
    }


    private static void admin() {
        boolean isRun = true;

        while (isRun) {
            LessonStudentCommandsforadminoruser.printCommandsAdmin();
            String command = scanner.nextLine();
            switch (command) {
                case LessonStudentCommandsforadminoruser.EXIT:
                    System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static void user() {
        boolean isRun = true;
        LessonStudentCommandsforadminoruser.printCommandsUser();
        while (isRun) {
            String command = scanner.nextLine();
            switch (command) {
                case LessonStudentCommandsforadminoruser.EXIT:
                    System.exit(0);
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }


    private static void printuser() {
        userStorage.print();
    }

    private static void register()  {
        System.out.println("please input email");
        String email = scanner.nextLine();

        User user=  userStorage.getByEmail(email);
        if(user == null){
            System.out.println("please input user's name");
            String name = scanner.nextLine();
            System.out.println("please input user's surname");
            String surname = scanner.nextLine();
            System.out.println("please input user's password");
            String password = scanner.nextLine();
            System.out.println("please input user's type(admin, user)");
            String type = scanner.nextLine().toUpperCase();
            if (type.equals("ADMIN") || type.equals("USER")) {
                Type newType = Type.valueOf(type);
                User newUser = new User(name, surname, email, password, newType);
                userStorage.add(email, newUser);
                System.out.println("Thank you, user was registered");
            } else {
                System.out.println("invalid type");
            }
        }else System.out.println("user with this email already exists");
    }



    private static void login() {
        System.out.println("Please input email");
        String email = scanner.nextLine();
        User user = userStorage.getByEmail(email);
        if(user != null){
            System.out.println("Please input password");
            String password = scanner.nextLine();
            if (user.getPassword().equals(password)) {
                if (user.getType().equals(Type.ADMIN)) {
                    admin();
                } else if (user.getType().equals(Type.USER)) {
                    user();
                }
            }
        }else System.out.println("user doesn't exist");
    }


    static void deleteStudentByEmail() {
        System.out.println("--------");
        studentStorage.print();
        System.out.println("--------");
        System.out.println("please input student's email");
        String email = scanner.nextLine();
        studentStorage.deleteStudentByEmail(email);
    }

    static void deleteLessonByName() {
        System.out.println("--------");
        lessonStorage.print();
        System.out.println("--------");
        System.out.println("please input lessons name");
        String name = scanner.nextLine();
        lessonStorage.deleteLessonByName(name);
    }

    static void printLessons() {
        lessonStorage.print();
    }

    static void printStudentsByLesson() {
        System.out.println("please input lesson's name");
        String lessonName = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(lessonName);
        studentStorage.printStudentsByLesson(lesson);
    }


    static void printStudents() {
        studentStorage.print();
    }

    static void addStudent() {
        System.out.println("please input  student's name");
        String name = scanner.nextLine();
        System.out.println("please input student's surname");
        String surname = scanner.nextLine();
        System.out.println("please input student's age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("please input student's email");
        String email = scanner.nextLine();
        System.out.println("please input student's phone");
        String phone = scanner.nextLine();
        System.out.println("please input registered date //dd/MM/yyyy//");
        String date = scanner.nextLine();
        Date registeredDate = new Date();
        try {
            registeredDate = DateUtil.stringToDate(date);
        } catch (ParseException e) {
            System.out.println("please input registered date //dd/MM/yyyy//");
        }
        System.out.println("please input lesson's name");
        String lessonName = scanner.nextLine();
        String[] lessonNames = lessonName.split(",");
        List<Lesson> lessons = new LinkedList<>();
        for (String lessonN : lessonNames) {
            Lesson lesson;
            if((lesson=lessonStorage.getByName(lessonN))!=null){
                lessons.add(lesson);
            }
        }
        Student student = new Student(name, surname, age, email, phone, lessons, registeredDate);
        studentStorage.add(student);
        System.out.println("Thank you, Student was added");

    }

    static void addLesson() {
        System.out.println("please input lessons's name,duration,lecturer's name,price");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        if (lessonData.length == 4) {
            int duration = Integer.parseInt(lessonData[1]);
            int price = Integer.parseInt(lessonData[3]);
            Lesson lesson = new Lesson(lessonData[0], duration, lessonData[2], price);
            if (lessonStorage.getByName(lesson.getName()) != null) {
                System.err.println("Invalid name. The lesson with this name already exists");
            } else {
                lessonStorage.add(lesson);
                System.out.println("Thank you, lesson was added");
            }
        }else
            System.out.println("Invalid lesson");
    }
}
