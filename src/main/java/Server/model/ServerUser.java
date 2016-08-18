package Server.model;


import Server.worker.Pass;
import org.apache.log4j.Logger;
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

    final private static Logger log = Logger.getLogger(ServerUser.class);

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
            log.error(e);
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
            log.error(e);
        }
    }

    public String give() {
        String str = "";
        str = this.in.nextLine();
        return str;
    }

    @Override
    public void run() {
        String str;
        while (!this.socket.isClosed() && this.in.hasNextLine()) {
            StringBuffer result = new StringBuffer();
            do {
                str = give();
                result.append(str).append("\n");
            }while(!str.equals("</body>"));

            System.out.println(result);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = null;
            try {
                System.out.println(result);
                saxParser = factory.newSAXParser();
                SaxHandler handler = new SaxHandler();
                InputSource is = new InputSource(new StringReader(result.toString()));
                saxParser.parse(is, handler);
                System.out.println(handler.getResult());
                Parser.callDoer(handler.getResult(), this);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                log.error(e);
            }
        }
        if(!this.socket.isClosed()){
            try {
                this.socket.close();
            } catch (IOException e) {
                log.error(e);
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
