import java.util.ArrayList;
import java.util.List;

public class UserManager extends User {
    private List<User> users;

    public UserManager() {
        super(null, null);
        users = new ArrayList<>();
        users.add(new User("Lesego", "1234"));
        users.add(new User("Lesedi", "5678"));
    }

    public boolean verify(String userId, String pin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }


}
