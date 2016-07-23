package Server.model;

import javax.xml.bind.annotation.*;
import java.text.ParseException;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"userId", "userName", "pasword", "wins", "loses", "playedGames"})
public class User {

    private int userId;
    private String userName;
    private String pasword;
    private int wins;
    private int loses;
    private int playedGames;

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public void createUser(int id, String name, String pasword) throws ParseException {
        setUserId(id);
        setUserName(name);
        setPasword(pasword);
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
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pasword='" + pasword + '\'' +
                '}';
    }
}