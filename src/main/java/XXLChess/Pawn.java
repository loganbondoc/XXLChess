package XXLChess;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.data.JSONArray;
import processing.core.PFont;
import processing.event.MouseEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.io.*;
import java.util.*;

public class Pawn extends Piece {

    public Pawn(String colour, int x, int y){
        super(colour, x, y, 1);
    }

    public void tick(){
        
    }

    public boolean isValidMove(int xPos, int yPos, ArrayList<ArrayList<Piece>> boardArray){
        int xCell = x / 48;
        int yCell = y / 48;
        Piece targetSpot = boardArray.get(yPos).get(xPos);

        int direction = 0;
        if (this.getColour() == "white"){
            direction = -1;
        } else if (this.getColour() == "black"){
            direction = 1;
        }

        // if first move can move two ahead
        if (getFirstMove() == true && yPos == (yCell + (2 * direction)) && xCell == xPos){
            // cannot kill pieces two ahead
            if (boardArray.get(yPos).get(xPos) != null){
                return false;
            }
            
            // Check if any pieces between move and current location
            int tempX = Integer.signum(xPos - xCell);
            int tempY = Integer.signum(yPos - yCell);
            int checkedX = xCell + tempX;
            int checkedY = yCell + tempY;
            while (checkedX != xPos || checkedY != yPos) {
                if (boardArray.get(checkedY).get(checkedX) != null) {
                    return false;
                }
            checkedX += tempX;
            checkedY += tempY;
            }
            return true;

        // Check that move is directly one ahead
        } else if ((yCell + direction) == yPos && xCell == xPos && targetSpot == null) {
            return true;

        // if piece is diagonal right can kill
        } else if (yPos == (yCell + direction) && xPos == (xCell + 1) && targetSpot != null && targetSpot.getColour() != this.getColour()){
            return true;

        // if piece is diagonal left can kill
        } else if (yPos == (yCell + direction) && xPos == (xCell - 1) && targetSpot != null && targetSpot.getColour() != this.getColour()){
            return true;
            
        } else {
            return false;
        }
    }
}