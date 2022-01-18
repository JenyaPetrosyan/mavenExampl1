package Education.Storage;

import Education.Model.Lesson;
import Education.Util.FileUtil;

import java.util.LinkedList;
import java.util.List;

public class LessonStorage {
    List<Lesson> lessons=new LinkedList<>();

    public void add(Lesson lesson) {
        lessons.add(lesson);
        FileUtil.serializeLesson(lessons);
    }


    public void print() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }

    public  Lesson getByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(name)) {
                return lesson;
            }
        }
        return null;
    }


    public void deleteLessonByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(name)) {
                remove(lesson);
                System.out.println("The lesson's has been deleted");
            }

        } FileUtil.serializeLesson(lessons);
    }
    public void remove(Lesson lesson) {
        lessons.remove(lesson);
        FileUtil.serializeLesson(lessons);
    }

    public void initData(){
        List<Lesson> lessons = FileUtil.deserializeLesson();
        if(lessons!=null){
            this.lessons=lessons;
        }
    }
}
