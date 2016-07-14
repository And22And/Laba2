package Server.model;

import java.io.*;
import java.text.ParseException;
import javax.xml.bind.*;

/**
 * Created by Клиент on 13.07.2016.
 */
public class UserJAXB {

    public static void marshall(UserList userList) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(userList, new File("UserList.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshall(UserList userList, PrintWriter writer) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(userList, writer);
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

    public static UserList unmarshall(BufferedReader reader) {
        UserList userList = new UserList();
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            userList = (UserList) unmarshaller.unmarshal(reader);
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
        userList.getUsers().add(user);
        userList.getUsers().add(user1);
        marshall(userList);
        userList = unmarshall();
        System.out.println( userList);
    }

}
