package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import interfaces.PointsUpdateListener;
//import db.QuestionRepository;
import model.Question;
import model.Player;

public class QuestionLabel extends JButton{

    private Question question;
    private boolean adminMode;
    private Player[] players;
    private PointsUpdateListener listener;

    private JLabel[] pointsLabel;

    

    public void setPointsUpdateListener(PointsUpdateListener listener){
        this.listener = listener;
    }

    public QuestionLabel(Question question, boolean adminMode){ // int id, String category_name, String question, String answer, int difficulty
        this.adminMode = adminMode;
        this.question = question;
        setSize(150, 125);
        addActionListener(new ActionListener() { // Definitly need to rewrite this mess
            @Override
            public void actionPerformed(ActionEvent e){

                int width = 400;
                int height = (adminMode) ? 300 : 100;

                JFrame questionFrame = new JFrame("QuestionWindow - " + question.getCategoryName());
                questionFrame.setPreferredSize(new Dimension(width, height));
                questionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // questionFrame.setLayout(new GridLayout(0, 1));
                questionFrame.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.fill = GridBagConstraints.BOTH;


                // Question (small)
                gbc.gridy = 0;
                gbc.weighty = (adminMode) ? 0.2 : 1; // If adminMode, then ratio is 0.2, else 1
                JPanel questionPanel = new JPanel();
                questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                questionPanel.add(new JLabel(question.getQuestion()));
                questionFrame.add(questionPanel, gbc);

                // More Features for the AdminWindow
                if(adminMode){
                    // AnswerPanel (small)
                    gbc.gridy = 1;
                    gbc.weighty = 0.2;
                    JPanel answerPanel = new JPanel();
                    answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    answerPanel.add(new JLabel(question.getAnswer()));
                    questionFrame.add(answerPanel, gbc);

                    // PlayerPanel (Large)
                    JPanel playersPanel = new JPanel();
                    playersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    playersPanel.setLayout(new GridLayout(players.length, 2, 10, 10));
                    for(Player player : players){
                        JButton btnAddPoints = new JButton("Add points to: " + player.getPlayerName());
                        btnAddPoints.addActionListener(ev -> {
                            player.setPlayerPoints(player.getPlayerPoints() + question.getPoints());
                            if(pointsLabel != null){
                                pointsLabel[player.getPlayerId()].setText(player.getPlayerPoints() + " pts");
                                GameWindow.updatePlayerPoints(player);
                            }
                        });

                        JButton btnRemovePoints = new JButton("Remove points from: " + player.getPlayerName());
                        btnRemovePoints.addActionListener(ev -> {
                            player.setPlayerPoints(player.getPlayerPoints() - question.getPoints());
                            if(pointsLabel != null){
                                pointsLabel[player.getPlayerId()].setText(player.getPlayerPoints() + " pts");
                                GameWindow.updatePlayerPoints(player);
                            }
                        });

                            
                        playersPanel.add(btnAddPoints);
                        playersPanel.add(btnRemovePoints);
                    }

                    gbc.gridy = 2;
                    gbc.weighty = 0.6;
                    questionFrame.add(playersPanel, gbc);
                }
                questionFrame.pack();
                questionFrame.setVisible(true);
                
                setText("GONE");
                setBackground(new Color(255, 102, 102));
            }
        }); // When the question and answer panel is being opened, they should not appear on the same monitor, so maybe open it inside the Frame?
        
        setText(String.valueOf(question.getPoints())); // Later change it to difficulty
    }

    public Question getQuestion(){
        return question;
    }

    public String getQuestionText(){
        return getText();
    }

    public void setPlayers(Player[] players){
        this.players = players;
    }

    public void setPointsLabels(JLabel[] labels){
        this.pointsLabel = labels;
    }


    
}
