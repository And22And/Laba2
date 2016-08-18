package Server.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "UserList")
@XmlType(propOrder = {"users"})
@XmlAccessorType(XmlAccessType.FIELD)
public class UserList {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void add(String name, String password) {
        User user = new User();
        user.setUserName(name);
        user.setPasword(password);
        this.users.add(user);
        UserJAXB.marshall(this);
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + users +
                '}';
    }
}
