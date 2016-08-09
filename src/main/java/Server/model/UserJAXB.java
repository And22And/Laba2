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
            marshaller.marshal(userList, new File("src//main//resources//UserList.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

//    public static void marshall(UserList userList, PrintWriter writer) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(UserList.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(userList, writer);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }

    public static UserList unmarshall() {
        UserList userList = new UserList();
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            userList = (UserList) unmarshaller.unmarshal(new File("src//main//resources//UserList.xml"));
        } catch (JAXBException e) {
           e.printStackTrace();
        }
        return userList;
    }

//    public static UserList unmarshall(BufferedReader reader) {
//        UserList userList = new UserList();
//        try {
//            JAXBContext context = JAXBContext.newInstance(UserList.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            userList = (UserList) unmarshaller.unmarshal(reader);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }

}
