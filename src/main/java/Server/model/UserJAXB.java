package Server.model;

import java.io.*;
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
}
