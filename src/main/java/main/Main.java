package main;

import gui.GameWindow;

public class Main {
    
    public static void startGame(int playerCount, int amountCategories){
        
        /*
         * GamePart
         */
        GameWindow gw = new GameWindow("Jeopardy");
        gw.addCategories(amountCategories);


        gw.setVisible(true);
        /*
         * PlayerPart
         */
    }
    
    public static void main(String[] args) {
        startGame(4, 5);        
    }



}
