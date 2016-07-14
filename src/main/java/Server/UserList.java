package Server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name = "UserList")
@XmlType(propOrder = {"userList"})
public class UserList {
    public ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return this.userList;
    }

    @XmlElement(name = "users")
    @XmlElementWrapper
    public void setUserList(ArrayList<User> users) {
        this.userList = users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}
