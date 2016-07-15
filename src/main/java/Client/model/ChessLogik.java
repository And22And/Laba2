package Client.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 * Created by User on 06.07.2016.
 */
public class ChessLogik {
    private static Box[][] matrix;

    private static Image pawn = new Image("/image/pawn.png");
    private static Image pawnWhite = new Image("/image/pawnWhite.png");
    private static Image horse = new Image("/image/horse.png");
    private static Image horseWhite = new Image("/image/horseWhite.png");
    private static Image rook = new Image("/image/rook.png");
    private static Image rookWhite = new Image("/image/rookWhite.png");
    private static Image bis = new Image("/image/bis.png");
    private static Image bisWhite = new Image("/image/bisWhite.png");
    private static Image king = new Image("/image/king.png");
    private static Image kingWhite = new Image("/image/kingWhite.png");
    private static Image queen = new Image("/image/queen.png");
    private static Image queenWhite = new Image("/image/queenWhite.png");

    public static void run(Box box, Box[][] matrix, int i, int y, boolean isYou){
        System.out.println("В логике");
            ChessLogik.matrix = matrix;
        String name = box.name;
        switch (name) {
            case "pawn":
                pawn(box, i, y, isYou);
                break;
            case "pawnWhite":
                pawn(box, i, y, isYou);
                break;
            case "horse":
                horse(box, i, y);
                break;
            case "horseWhite":
                horse(box, i, y);
                break;
            case "bis":
                bis(box, i, y);
                break;
            case "bisWhite":
                bis(box, i, y);
                break;
            case "rook":
                rook(box, i, y);
                break;
            case "rookWhite":
                rook(box, i, y);
                break;
            case "queen":
                bis(box, i, y);
                rook(box, i, y);
                break;
            case "queenWhite":
                bis(box, i, y);
                rook(box, i, y);
                break;
            case "king":
                king(box, i, y);
                break;
            case "kingWhite":
                king(box, i, y);
                break;
        }

    }

    private static void pawn(Box box, int i, int y, boolean isYou){
        System.out.println("В логике пешки");
        if(isYou){
            if((i - 1 >= 0) && (y >= 0) && (y < 8) && (i-1 < 8) && matrix[i-1][y].name == null)
                matrix[i-1][y].pane.setStyle("-fx-background-color: #a5f2de;");
            if((i - 1 >= 0) && (y+1 >= 0) && (y+1 < 8) && (i-1 < 8) && matrix[i-1][y+1].name != null
                    && matrix[i-1][y+1].white != box.white)
                matrix[i-1][y+1].pane.setStyle("-fx-background-color: #ff8584;");
            if((i - 1 >= 0) && (y-1 >= 0) && (y-1 < 8) && (i-1 < 8) && matrix[i-1][y-1].name != null
                    && matrix[i-1][y-1].white != box.white)
                matrix[i-1][y-1].pane.setStyle("-fx-background-color: #ff8584;");
        } else {
            if((i + 1 >= 0) && (y >= 0) && (y < 8) && (i+1 < 8) && matrix[i-1][y].name == null){
                matrix[i+1][y].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i + 1 >= 0) && (y+1 >= 0) && (y+1 < 8) && (i+1 < 8) && matrix[i-1][y+1].name != null
                    && matrix[i+1][y+1].white != box.white)
                matrix[i+1][y+1].pane.setStyle("-fx-background-color: #ff8584;");
            if((i + 1 >= 0) && (y-1 >= 0) && (y-1 < 8) && (i+1 < 8) && matrix[i-1][y-1].name != null
                    && matrix[i+1][y-1].white != box.white)
                matrix[i+1][y-1].pane.setStyle("-fx-background-color: #ff8584;");
        }

    }

    private static void horse(Box box, int i, int y){
            if((i - 2 >= 0) && (y - 1 >= 0) && (y - 1 < 8) && (i-2 < 8)){
                if(matrix[i - 2][y - 1].white != box.white && matrix[i - 2][y - 1].name != null){
                    matrix[i - 2][y - 1].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i - 2][y - 1].name == null)
                    matrix[i - 2][y - 1].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i - 2 >= 0) && (y + 1 >= 0) && (y + 1 < 8) && (i-2 < 8)){
                if(matrix[i - 2][y + 1].white != box.white && matrix[i - 2][y + 1].name != null){
                    matrix[i - 2][y + 1].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i - 2][y + 1].name == null)
                    matrix[i - 2][y + 1].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i + 2 >= 0) && (y - 1 >= 0) && (y - 1 < 8) && (i + 2 < 8)){
                if(matrix[i + 2][y - 1].white != box.white && matrix[i + 2][y - 1].name != null){
                    matrix[i + 2][y - 1].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i + 2][y - 1].name == null)
                    matrix[i + 2][y - 1].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i + 2 >= 0) && (y + 1 >= 0) && (y + 1 < 8) && (i+2 < 8)){
                if(matrix[i + 2][y + 1].white != box.white && matrix[i + 2][y + 1].name != null){
                    matrix[i + 2][y + 1].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i + 2][y + 1].name == null)
                    matrix[i + 2][y + 1].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i + 1 >= 0) && (y + 2 >= 0) && (y + 2 < 8) && (i+1 < 8)){
                if(matrix[i + 1][y + 2].white != box.white && matrix[i + 1][y + 2].name != null){
                    matrix[i + 1][y + 2].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i + 1][y + 2].name == null)
                    matrix[i + 1][y + 2].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i - 1 >= 0) && (y + 2 >= 0) && (y + 2 < 8) && (i-1 < 8)){
                if(matrix[i - 1][y + 2].white != box.white && matrix[i - 1][y + 2].name != null){
                    matrix[i - 1][y + 2].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i - 1][y + 2].name == null)
                    matrix[i - 1][y + 2].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i + 1 >= 0) && (y - 2 >= 0) && (y - 2 < 8) && (i+1 < 8)){
                if(matrix[i + 1][y - 2].white != box.white && matrix[i + 1][y - 2].name != null){
                    matrix[i + 1][y - 2].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i + 1][y - 2].name == null)
                    matrix[i + 1][y - 2].pane.setStyle("-fx-background-color: #a5f2de;");
            }
            if((i - 1 >= 0) && (y - 2 >= 0) && (y - 2 < 8) && (i-1 < 8)){
                if(matrix[i - 1][y - 2].white != box.white && matrix[i - 1][y - 2].name != null){
                    matrix[i - 1][y - 2].pane.setStyle("-fx-background-color: #ff8584;");
                }
                if(matrix[i - 1][y - 2].name == null)
                    matrix[i - 1][y - 2].pane.setStyle("-fx-background-color: #a5f2de;");
            }
    }

    private static void bis(Box box, int i, int y){
        int nowI = i;
        int nowY = y;
        boolean next = true;
        while (next){
            nowI++;
            nowY++;
            System.out.println(nowI + " " + nowY + " --- офицер");
            if(nowI < 8 && nowY < 8 ){

                if( matrix[nowI][nowY].name == null ){
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if(matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowI--;
            nowY++;
            System.out.println(nowI + " " + nowY + " --- офицер");
            if(nowI >= 0 && nowY < 8){
                if( matrix[nowI][nowY].name == null ){
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if(matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowI++;
            nowY--;
            System.out.println(nowI + " " + nowY + " --- офицер");
            if(nowI < 8 && nowY >= 0) {
                if (matrix[nowI][nowY].name == null) {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if (matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowI--;
            nowY--;
            System.out.println(nowI + " " + nowY + " --- офицер");
            if(nowI >= 0 && nowY >= 0) {
                if (matrix[nowI][nowY].name == null) {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if (matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
    }

    private static void rook(Box box, int i, int y){
        int nowI = i;
        int nowY = y;
        boolean next = true;
        while (next){
            nowY++;
            System.out.println(nowI + " " + nowY + " --- тура");
            if(nowY < 8 ){

                if( matrix[nowI][nowY].name == null ){
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if(matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowI--;
            System.out.println(nowI + " " + nowY + " --- тура");
            if(nowI >= 0){
                if( matrix[nowI][nowY].name == null ){
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if(matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowI++;
            System.out.println(nowI + " " + nowY + " --- тура");
            if(nowI < 8) {
                if (matrix[nowI][nowY].name == null) {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if (matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
        next = true;
        nowI = i;
        nowY = y;
        while (next){
            nowY--;
            System.out.println(nowI + " " + nowY + " --- тура");
            if(nowY >= 0) {
                if (matrix[nowI][nowY].name == null) {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
                } else if (matrix[nowI][nowY].white == box.white) {
                    next = false;
                } else {
                    matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
                    next = false;
                }
            } else {
                next = false;
            }
        }
    }

    private static void king(Box box, int i, int y) {
        int nowI;
        int nowY;
        nowI = i + 1;
        nowY = y + 1;
        if(nowI < 8 && nowY < 8 ) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowI = i - 1;
        nowY = y - 1;
        if(nowI >= 0 && nowY >= 0 ) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowI = i + 1;
        nowY = y - 1;
        if(nowI < 8 && nowY >= 0 ) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowI = i - 1;
        nowY = y + 1;
        if( nowY < 8 &&  nowI >= 0 ) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowI = i;
        nowY = y + 1;
        if( nowY < 8) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowY = y - 1;
        if( nowY >= 0) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }

        nowI = i + 1;
        nowY = y;
        if( nowI < 8) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }
        nowI = i - 1;
        if( nowI >= 0) {
            if (matrix[nowI][nowY].name == null) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #a5f2de;");
            } else if (matrix[nowI][nowY].white != box.white) {
                matrix[nowI][nowY].pane.setStyle("-fx-background-color: #ff8584;");
            }
        }

    }

    private static boolean checkOnShah(Box[][] matrix, int kingI, int kingY){
        Box[][] tmpMatrix = matrix;
        boolean white = !matrix[kingI][kingY].white;
        for(int i = 0 ; i < 8; i++)
            for(int y = 0 ; y < 8; y++){
                if(tmpMatrix[i][y].name != null && tmpMatrix[i][y].white == white){
                    System.out.println(kingI + " " + kingY);
                    System.out.println("координаты короля");
                    System.out.println(white);
                    System.out.println("+1" + i + " " + y);
                    run(tmpMatrix[i][y], tmpMatrix, i, y, false);
                    if(tmpMatrix[kingI][kingY].pane.getStyle().split(" ")[1].equals("#ff8584;"))
                        return true;
                }
            }
        return false;
    }

    private static Box[][] swichMatrix(Box[][] matrixPr){
        Box[][] tmpMatrix = new Box[8][8];
        for(int i = 0 ; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                tmpMatrix[i][y] = new Box(new Pane(new ImageView()));
                tmpMatrix[i][y].pane.setStyle(matrixPr[i][y].pane.getStyle());
                tmpMatrix[i][y].white = matrixPr[i][y].white;
                tmpMatrix[i][y].name = matrixPr[i][y].name;
                tmpMatrix[i][y].image.setImage(matrixPr[i][y].image.getImage());
            }
        }
        return tmpMatrix;
    }

    public static void checkOnStep(Box box, Box[][] matrixPr, int i, int y){
        Box[][] tmpMatrix ;
        for(int k = 0; k < 8; k++)
            for(int s = 0; s < 8; s++){
                tmpMatrix = swichMatrix(matrixPr);
                if (tmpMatrix[k][s].pane.getStyle().split(" ")[1].equals("#a5f2de;") ||
                        tmpMatrix[k][s].pane.getStyle().split(" ")[1].equals("#ff8584;")){
                    System.out.println("Проверка на шах королю при ходе");
                    System.out.println("-------------------------------");
                    System.out.println(k + "   ------------------  " + s);
                    System.out.println(matrixPr);
                    System.out.println(matrix);
                    System.out.println(tmpMatrix);
                    System.out.println(matrix[0][0].pane);
                    System.out.println(tmpMatrix[0][0].pane);
                    tmpMatrix[k][s].name = tmpMatrix[i][y].name;
                    tmpMatrix[k][s].white = tmpMatrix[i][y].white;
                    tmpMatrix[k][s].image.setImage(tmpMatrix[i][y].image.getImage());
                    tmpMatrix[i][y].name = null;
                    tmpMatrix[i][y].white = false;
                    tmpMatrix[i][y].image.setImage(null);
                    int tmp = findKing(box, tmpMatrix);
                    int kingI = tmp/10;
                    int kingY = tmp%10;
                    if(checkOnShah(tmpMatrix, kingI, kingY )){

                        if ((k+s) % 2 == 0) {
                            matrixPr[k][s].pane.setStyle("-fx-background-color: #ffffe7;");
                        } else {
                            matrixPr[k][s].pane.setStyle("-fx-background-color: #e6a875;");
                        }
                    }

                }


            }

    }


    private static byte findKing(Box box, Box[][] matrixPar){
        String kingName;
        byte result = 0;
        System.out.println("findKing - цвет короля  " + box.white);
        if(box.white){
            kingName = "kingWhite";
        } else {
            kingName = "king";
        }
        for(int i = 0; i < 8; i++)
            for(int y = 0; y < 8; y++){
                if(matrixPar[i][y].name == kingName)
                    result = (byte)(i*10 + y);
            }
        return result;
    }

//    public static void checkOnStep(Box box, Box[][] matrix, int i, int y){
//        ChessLogik.matrix = matrix;
//    }

}