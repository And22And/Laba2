package Server.model;

import javax.xml.bind.annotation.*;
import java.text.ParseException;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"userName", "pasword", "wins", "loses", "playedGames"})
public class User {

    private String userName;
    private String pasword;
    private int wins;
    private int loses;
    private int playedGames;

    public int getPlayedGames() {
        return playedGames;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public User() {    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void winer() {
        this.wins++;
        this.playedGames++;
    }

    public void loser() {
        this.loses++;
        this.playedGames++;
    }

    public void draw() {
        this.playedGames++;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userName=\'" + userName + '\'' +
                ", pasword=\'" + pasword + '\'' +
                '}';
    }
}