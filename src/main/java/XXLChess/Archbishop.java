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

public class Archbishop extends Piece implements BishopMovement, KnightMovement{
    
    public Archbishop(String colour, int x, int y){
        super(colour, x, y, 7.5);
    }

    public void tick(){
        
    }

    public boolean isValidMove(int xPos, int yPos, ArrayList<ArrayList<Piece>> boardArray){
        if (isValidBishopMove(xPos, yPos, boardArray, x, y) == true){
            return true;
        } else if (isValidKnightMove(xPos, yPos, boardArray, x, y) == true){
            return true;
        } else {
            return false;
        }
    }
}