package Server.model;

import org.apache.log4j.Logger;

import java.io.*;
import javax.xml.bind.*;

/**
 * Created by Клиент on 13.07.2016.
 */
public class UserJAXB {

    final private static Logger log = Logger.getLogger(UserJAXB.class);

    public static void marshall(UserList userList) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(userList, new File("src//main//resources//UserList.xml"));
        } catch (JAXBException e) {
           log.error(e);
        }
    }

    public static UserList unmarshall() {
        UserList userList = new UserList();
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            if((new File("src//main//resources//UserList.xml")).exists()) userList = (UserList) unmarshaller.unmarshal(new File("src//main//resources//UserList.xml"));
        } catch (JAXBException e) {
            log.error(e);
        }
        return userList;
    }
}
