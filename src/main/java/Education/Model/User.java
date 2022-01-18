package Education.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Type type;

}
