package Education.Util;

import Education.Model.Lesson;
import Education.Model.Student;
import Education.Model.User;

import java.io.*;
import java.util.List;
import java.util.Map;
public class FileUtil {

    private static  final String PATH = "C:\\Users\\User\\IdeaProjects\\JavaCore\\Usumnakan.angel\\Homework\\education\\data";

    public static  void serializeUser(Map<String, User> userMap) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH + "\\user.txt"))) {
            out.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeLesson(List<Lesson> lessons) {
        try (ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream(PATH + "\\lesson.txt")))) {
            out.writeObject(lessons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeStudent(List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream(PATH + "\\student.txt")))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, User> deserializeUser() {
        File file = new File(PATH + "\\user.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (Map<String, User>) in.readObject();
            } catch(EOFException e){

            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Lesson>  deserializeLesson() {
        File file=new File(PATH + "\\lesson.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
                return (List<Lesson>) in.readObject();
            } catch(EOFException e){

            }catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Student> deserializeStudent() {
        File file=new File(PATH + "\\student.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
                return (List<Student>) in.readObject();
            } catch(EOFException e){

            }catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
