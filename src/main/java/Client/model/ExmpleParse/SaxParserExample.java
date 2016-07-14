package Client.model.ExmpleParse;

import Client.model.SaxHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * Created by User on 13.07.2016.
 */
public class SaxParserExample {

    public static void main (String argv []) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        String str = "<body>\n" +
                "    <metaInfo>doStep</metaInfo>\n" +
                "    <positionOf>17</positionOf>\n" +
                "    <positionInto>63</positionInto>\n" +
                "</body>";
        try {

            FileWriter writer = new FileWriter("src//main//resources//xml//ForParse2.xml", false);
            writer.write(str);
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
        } finally {

        }
    }
}
