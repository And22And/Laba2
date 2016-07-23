package Server.model;

import Server.worker.Lobby;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static java.util.Objects.isNull;

/**
 * Created by Клиент on 13.07.2016.
 */
public class ServerUser extends Thread{
    private User user;
    private ServerUser oponent;
    private boolean isPlaing;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerUser() {


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServerUser(Socket socket) {
        this.socket = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerUser getOponent() {
        return oponent;
    }

    public void setOponent(ServerUser oponent) {
        this.oponent = oponent;
    }

    public boolean isPlaing() {
        return isPlaing;
    }

    public void setPlaing(boolean plaing) {
        isPlaing = plaing;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void send(String str) {
        out.println(str);
        out.flush();
    }

    public String give() {
        String str = "";
        try {
            str = in.readLine();
        } catch (SocketException e) {
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public void run() {
        (new Lobby()).doAction(null, this);
        while (!this.socket.isClosed()) {
            String str;
            String result = "";
            do {
                str = give();
                result += str + "\n";
            }while(!str.equals("</body>"));

            if(!isNull(result)) {
                System.out.println(result);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = null;
                try {
                    FileWriter writer = new FileWriter("src//main//resources//xml//ForParse2.xml", false);
                    writer.write(result);
                    writer.flush();
                    InputStream xmlInput = new FileInputStream( "src//main//resources//xml//ForParse2.xml" );
                    saxParser = factory.newSAXParser();
                    SaxHandler handler = new SaxHandler();
                    saxParser.parse(xmlInput, handler);
                    writer.close();
                    System.out.println(handler.getResult().toString()); //////////////
                    new File("src//main//resources//xml//ForParse2.xml" ).delete();
                    Parser.callDoer(handler.getResult(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
        Server.removeUser(this);
    }
}
