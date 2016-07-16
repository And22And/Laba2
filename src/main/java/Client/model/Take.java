package Client.model;

import Client.view.Main;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * Created by User on 14.07.2016.
 */
public class Take {
    private static BufferedReader in = Main.getIn();

    /**
     * This method is only example for future methods.
     * Its role is show prototype.
     *
     */
    public void takeMesseng(String src){
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {

            FileWriter writer = new FileWriter("src//main//resources//xml//ForParse2.xml", false);
            writer.write(src);
            writer.flush();
            InputStream xmlInput = new FileInputStream( "src//main//resources//xml//ForParse2.xml" );
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlInput, handler);
            writer.close();
            System.out.println(handler.getResult()[0] + " " + handler.getResult()[1] + " " + handler.getResult()[2]);
            new File("src//main//resources//xml//ForParse2.xml" ).delete();
        } catch (Throwable err) {
            err.printStackTrace();
        }
    }

}
