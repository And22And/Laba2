package Server.model;


import Server.worker.Pass;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.Socket;
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
    private Server server;

    public ServerUser() {
    }


    public ServerUser(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.setPlaing(false);
        try {
            this.in = new Scanner(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server getServer() {
        return server;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return this.in.nextLine();
    }

    @Override
    public void run() {
        StringBuffer result;
        String str;
        while (!this.socket.isClosed() && this.in.hasNextLine()) {
            result = new StringBuffer("");
            do {
                str = give();
                result.append(str).append("\n");
            }while(!str.equals("</body>"));
            System.out.println(result);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser;
            try {
                System.out.println(result);
                saxParser = factory.newSAXParser();
                SaxHandler handler = new SaxHandler();
                InputSource is = new InputSource(new StringReader(result.toString()));
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
        if(!this.socket.isClosed()){
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.in.close();
        this.out.close();
        server.removeUser(this);
        if(!isNull(this.getOponent())) {
            (new Pass()).doAction(null, this);
        }
        Thread.currentThread().interrupt();
    }
}