package Client.model;

import Client.view.Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 12.07.2016.
 */
public class Send{

    private static PrintWriter out = Main.getOut();

    public static void sendStep(int of, int into) {
        String result;
        result = "<body> " +
                "<metaInfo> doStep </metaIfo> " +
                "<position of:\""+ of + "\" into=\""+ into + "\"/> " +
                "</body>";
            out.println(result);
            out.flush();
    }


}
