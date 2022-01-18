package Education.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Lesson implements Serializable  {

    private String name;
    private int durationHour;
    private String lecturerName;
    private int price;

}
