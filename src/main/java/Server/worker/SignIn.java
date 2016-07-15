package Server.worker;

import Server.model.Server;
import Server.model.User;

import java.util.ArrayList;

/**
 * Created by Клиент on 12.07.2016.
 */
public class SignIn implements Doer {


    @Override
    public void doAction(String[] parameters) {
        ArrayList<User> users = Server.getAllUsers().getUsers();
        boolean isExist = false;
        for(int i = 0; i < users.size(); i++) {
            if(parameters[0].equals(users.get(i).getUserName())) {
                if(parameters[1].equals(users.get(i).getPasword())) {
                    isExist = true;
                    //отправляем "все хорошо" и id(может убрать id?)
                } else {
                    //отправляем "неправильный пароль"
                }
            }
        }
        if(!isExist) {
            //отправляем пользователя не существует
        }
    }
}
