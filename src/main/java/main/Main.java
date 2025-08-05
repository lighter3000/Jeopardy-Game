package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;

import java.util.List;

import gui.AdminWindow;
import gui.GameWindow;
import model.Player;

public class Main{

    private static int playerAmount=4;
    private static int categoriesAmount=5;

    
    public static void startGame(int playerCount, int amountCategories){
        
        /*
         * GamePart
         */

        /*
         * Maybe change GameWindow and AdminWindow, so GameWindow copies from AdminWindow.
         * So that it can better change the amount of variables depending on the players. (Create Window to change it better)
         */ 

        GameWindow gw = new GameWindow("GameWindow - Jeopardy");
        gw.addCategories(amountCategories);

        AdminWindow aw = new AdminWindow("AdminWindow - Jeopardy");
        aw.copyCategories();

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
                startGame(playerAmount, categoriesAmount);     // After setting the player count, the admin window gets to chose their names.   
            }
        });

        confirmPanel.add(confirmButton);

        optionsFrame.add(optionsPanel, BorderLayout.CENTER);
        optionsFrame.add(confirmPanel, BorderLayout.SOUTH);

        optionsFrame.setVisible(true);

    }
    
    public static void main(String[] args) {
        // Add Window to ask for playerCount and amountCategories - Done it
        // After that for the playerNames

        gameOptions();
        
    }



}
