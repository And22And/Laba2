package Server.model;

/**
 * Created by User on 13.07.2016.
 */
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**

 */
public class SaxHandler extends DefaultHandler {

    private int i = 0;
    private String nameOfClass;
    private String[] result;

    private Stack<String> elementStack = new Stack<>();

    public String[] getResult() {
        return result;
    }

    public void startElement(String uri, String name,
                             String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);
    }

    public void endElement(String uri, String name,
                           String qName) throws SAXException {
        this.elementStack.pop();

    }

    public void characters(char ch[], int start, int length)
            throws SAXException {

        String value = new String(ch, start, length).trim();
        if(value.length() == 0) return; // ignore white space

        if("metaInfo".equals(currentElement()) && ("DoStep".equals(value) || "CheckInitialize".equals(value)) ){
            result = new String[3];
            nameOfClass = value;
            result[0] = value;
            i++;
        }

        if(result[0].equals(nameOfClass) && !value.equals(nameOfClass)){
            result[i] = value;
            i++;
        }


    }

    private String currentElement() {
        return this.elementStack.peek();
    }

    private String currentElementParent() {
        if(this.elementStack.size() < 2) return null;
        return this.elementStack.get(this.elementStack.size()-2);
    }

}
