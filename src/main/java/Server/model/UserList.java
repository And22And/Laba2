package Server.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "UserList")
@XmlType(propOrder = {"users"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserList {

    public ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void add(String name, String password) {
        User user = new User();
        user.setUserName(name);
        user.setPasword(password);
        user.setUserId(getUsers().get(getUsers().size()-1).getUserId() + 1);
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
