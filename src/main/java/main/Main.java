package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.util.List;

import gui.AdminWindow;
import gui.GameWindow;
import model.Player;

public class Main{

    private static int playerAmount=4;
    private static int categoriesAmount=5;

    
    public static void startGame(int playerCount, Player[] players ,int amountCategories){
        
        /*
         * GamePart
         */

        /*
         * Maybe change GameWindow and AdminWindow, so GameWindow copies from AdminWindow.
         * So that it can better change the amount of variables depending on the players. (Create Window to change it better)
         */ 

        GameWindow gw = new GameWindow("GameWindow - Jeopardy");
        gw.addCategories(amountCategories);
        // gw.addPlayerNames(players); // Need to implement it 

        AdminWindow aw = new AdminWindow("AdminWindow - Jeopardy");
        aw.copyCategories();
        // aw.addPlayerNames(players);

        gw.setVisible(true);
        aw.setVisible(true);
        /*
         * PlayerPart
         */
    }

    private static void gameOptions(){
        JFrame optionsFrame = new JFrame("Game Options");
        optionsFrame.setSize(480, 300);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setLocationRelativeTo(null);

        JPanel optionsPanel = new JPanel();

        optionsPanel.setLayout(new GridLayout(2,2, 20, 10));

        JLabel playerLabel = new JLabel("Amount of Players: ");
        JSpinner playerSpinner = new JSpinner();
        playerSpinner.setModel(new SpinnerListModel(List.of(2,3,4)));
        playerSpinner.setValue(4);


        optionsPanel.add(playerLabel);
        optionsPanel.add(playerSpinner);
        


        JLabel categoriesLabel = new JLabel("Amount of Categories: ");
        JSpinner categoriesSpinner = new JSpinner();

        categoriesSpinner.setModel(new SpinnerListModel(List.of(3,4,5)));
        categoriesSpinner.setValue(5);

        optionsPanel.add(categoriesLabel);
        optionsPanel.add(categoriesSpinner);



        JPanel confirmPanel = new JPanel();
        
        JButton confirmButton = new JButton("Go!");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                playerAmount = (Integer) playerSpinner.getValue();
                categoriesAmount = (Integer) categoriesSpinner.getValue();      
                optionsFrame.dispose();
                playerOptions(playerAmount);
            }
        });

        confirmPanel.add(confirmButton);

        optionsFrame.add(optionsPanel, BorderLayout.CENTER);
        optionsFrame.add(confirmPanel, BorderLayout.SOUTH);

        optionsFrame.setVisible(true);

    }

    private static void playerOptions(int playerAmount){

        Player[] players = new Player[playerAmount];

        JFrame playerFrame = new JFrame("Please enter Players' Names");
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerFrame.setSize(600, 300);
        playerFrame.setLocationRelativeTo(null);


        JPanel namePanel = new JPanel(new GridLayout(2, playerAmount, 20, 20));
        namePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel[] playersLabel = new JLabel[playerAmount];
        JTextField[] playersField = new JTextField[playerAmount];

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 14);


        // Labels
        for(int i=0; i<playerAmount; i++){
            playersLabel[i] = new JLabel("<html>Please enter<br>Player " + (i+1) + "'s Name</html>", SwingConstants.CENTER);
            playersLabel[i].setFont(labelFont);
            namePanel.add(playersLabel[i]);
        }

        // Fields
        for(int i=0; i<playerAmount; i++){
            playersField[i] = new JTextField();
            playersField[i].setFont(fieldFont);
            playersField[i].setHorizontalAlignment(JTextField.CENTER);
            playersField[i].setPreferredSize(new Dimension(100, 30));
            namePanel.add(playersField[i]);
        }

        


        JPanel confirmPanel = new JPanel();
        confirmPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        confirmButton.setFocusPainted(false);
        confirmButton.setBackground(new Color(60, 180, 110));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setPreferredSize(new Dimension(120, 35));

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                for(int playerId=0; playerId<playerAmount; playerId++){
                    players[playerId] = new Player(
                        playerId, 
                        playersField[playerId].getText(), 
                        0
                        );
                }
                playerFrame.dispose();
                startGame(playerAmount, players, categoriesAmount);     // After setting the player count, the admin window gets to chose their names.
            }
        });
        
        confirmPanel.add(confirmButton);

        playerFrame.add(namePanel, BorderLayout.CENTER);
        playerFrame.add(confirmPanel, BorderLayout.SOUTH);
        playerFrame.setVisible(true);
    } 
    
    public static void main(String[] args) {
        // Add Window to ask for playerCount and amountCategories - Done it
        // After that for the playerNames

        gameOptions();
        
    }



}
