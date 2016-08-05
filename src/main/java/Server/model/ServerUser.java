package Server.model;

import Server.model.Parser;
import Server.model.SaxHandler;
import Server.model.Server;
import Server.model.User;
import Server.worker.Pass;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import static java.util.Objects.isNull;

/**
 * Created by Клиент on 13.07.2016.
 */
public class ServerUser extends Thread{
    private User user;
    private ServerUser oponent;
    private boolean isPlaing;
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private String color;

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
        this.setPlaing(false);
        try {
            this.in = new Scanner(new InputStreamReader(this.socket.getInputStream()));
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        System.out.println(str);
        out.println(str);
        out.flush();
    }

    public void closeConnection() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String give() {
        String str = "";
        str = this.in.nextLine();
        return str;
    }

    @Override
    public void run() {
        while (!this.socket.isClosed() && this.in.hasNextLine()) {
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
                    System.out.println(result);
                    saxParser = factory.newSAXParser();
                    SaxHandler handler = new SaxHandler();
                    InputSource is = new InputSource(new StringReader(result));
                    saxParser.parse(is, handler);
                    System.out.println(handler.getResult());
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
        if(!this.socket.isClosed()){
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.in.close();
        this.out.close();
        Server.removeUser(this);
        if(!isNull(this.getOponent())) {
            (new Pass()).doAction(null, this);
        }
        Thread.currentThread().interrupt();
    }
}
