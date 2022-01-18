package Education.Model;
import Education.Model.Lesson;
import Education.Util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
@Data
@AllArgsConstructor
public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;
    private List<Lesson> lessons;
    private Date registeredDate;
}
