package Server.model;

import com.sun.org.apache.bcel.internal.classfile.*;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Клиент on 29.07.2016.
 */
public class DOMHandlerParser {

    public static ArrayList parse(String uri){
        ArrayList<String> result = new ArrayList<>();
        Document doc = null;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(uri));
            doc =  builder.parse(is);
            if (doc != null) {
                Node node = doc.getDocumentElement();
                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++) {
                        Node n = children.item(i);
                        result.add(n.getFirstChild().getNodeValue());
                    }
                }
//                printDomTree(doc);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList printDomTree(Node node){
        ArrayList<String> result = new ArrayList<>();
        int type = node.getNodeType();
        switch (type){
            case Node.DOCUMENT_NODE:
            {
                printDomTree(((Document)node).getDocumentElement());
                break;
            }
            case Node.ELEMENT_NODE:
            {
                NamedNodeMap attrs = node.getAttributes();
                for (int i = 0; i < attrs.getLength(); i++)
                    printDomTree(attrs.item(i));
                if (node.hasChildNodes())
                {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++)
                        printDomTree(children.item(i));
                }
                break;
            }

//            case Node.ATTRIBUTE_NODE:
//            {
//                System.out.print(" " + node.getNodeName() + "=\"" +
//                        ((Attr)node).getValue() + "\"");
//                break;
//            }

            case Node.TEXT_NODE:
            {
                result.add(node.getNodeValue());
                break;
            }
        }
        return result;
    }




    public static void main(String[] args) {
        String result = "<body>" +
                "<metaInfo>CheckInitialize</metaInfo>\n" +
                "<isExist>true</isExist>\n" +
                "<right>parameters.get(2).equals(users.get(i).getPasword()) </right>\n" +
                "<name>users.get(i).getUserName()</name>\n" +
                "<game>users.get(i).getPlayedGames(</game>\n" +
                "    <wins>users.get(i).getWins()</wins>\n" +
                "</body>";
        System.out.println(parse(result).toString());
    }

}
