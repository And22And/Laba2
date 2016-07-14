package Server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.text.ParseException;

@XmlType(propOrder = {"userId", "userName", "pasword" }, name = "user")
public class User {

    private int userId;
    private String userName;
    private String pasword;

    public User() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    @XmlElement
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @XmlElement
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    @XmlElement
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public User createUser(int id, String name, String pasword) throws ParseException {
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setPasword(pasword);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }
}