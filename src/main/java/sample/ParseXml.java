package sample;

/**
 * Created by User on 12.07.2016.
 */
public class ParseXml {
    public static String parseStep(int of, int into){
        String result;
        result = "<body> " +
                "<metaInfo> doStep </metaIfo> " +
                "<position of:\""+ of + "\" into=\""+ into + "\"/> " +
                "</body>";
        return result;
    }
}
