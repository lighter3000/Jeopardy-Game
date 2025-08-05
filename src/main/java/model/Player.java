package model;

public class Player {
    private int playerId;
    private String playerName;
    private int playerPoints;

    public Player(int playerId, String playerName, int playerPoints){
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPoints = playerPoints;
    }

    public int getPlayerId(){
        return playerId;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerPoints(int points){
        playerPoints = points;
    }

    public int getPlayerPoints(){
        return playerPoints;
    }

    public void addPlayerPoints(int points){
        playerPoints += points;
    }
    
}
