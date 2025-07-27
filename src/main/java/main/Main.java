package main;

import gui.GameWindow;

public class Main {
    
    public static void startGame(int playerCount, int amountThemes){
        
        /*
         * GamePart
         */
        GameWindow gw = new GameWindow("Jeopardy");
        gw.addThemes();



        /*
         * PlayerPart
         */
    }
    
    public static void main(String[] args) {
        startGame(4, 5);        
    }



}
