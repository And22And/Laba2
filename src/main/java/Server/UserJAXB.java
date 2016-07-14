package Server;

import java.io.*;
import java.text.ParseException;
import javax.xml.bind.*;

/**
 * Created by Клиент on 13.07.2016.
 */
public class UserJAXB {

    public static void marshall(UserList userList) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(userList, new File("UserList.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static UserList unmarshall() {
        UserList userList = new UserList();
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            userList = (UserList) unmarshaller.unmarshal(new File("UserList.xml"));
        } catch (JAXBException e) {
           e.printStackTrace();
        }
        return userList;
    }


    public static void main(String[] args) {
        User user = new User();
        try {
            user.createUser(10, "Vasa", "007");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user1 = new User();
        try {
            user1.createUser(9, "Peta", "006");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserList userList = new UserList();
        userList.getUserList().add(user);
        userList.getUserList().add(user1);
        marshall(userList);
        userList = unmarshall();
        System.out.println( userList);
    }

}
