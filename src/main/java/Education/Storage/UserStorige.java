package Education.Storage;
import Education.Model.User;
import Education.Util.FileUtil;


import java.util.HashMap;
import java.util.Map;
public class UserStorige {


    Map<String, User> userMap = new HashMap<>();

    public void add(String email, User user) {
        userMap.put(email, user);
        FileUtil.serializeUser(userMap);
    }

    public void print() {
        for (Map.Entry<String, User> stringUserEntry : userMap.entrySet()) {
            System.out.println(stringUserEntry);
        }
    }

    public User getByEmail(String email) {
        return userMap.get(email);
    }

    public void initData(){
        Map<String, User> stringUserMap = FileUtil.deserializeUser();
        if(stringUserMap != null){
            userMap = stringUserMap;
        }
    }

}
