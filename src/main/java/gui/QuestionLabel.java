package gui;

import java.awt.Color;
import java.awt.Dimension;
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
                JFrame questionFrame = new JFrame("QuestionWindow - " + question.getCategoryName());
                questionFrame.setPreferredSize(new Dimension(400, 300));
                questionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                questionFrame.setLayout(new GridLayout(0, 1));
                
                // Question
                JPanel questionPanel = new JPanel();
                questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                questionPanel.add(new JLabel(question.getQuestion()));
                questionFrame.add(questionPanel);

                // More Features for the AdminWindow
                if(adminMode){
                    // AnswerPanel
                    JPanel answerPanel = new JPanel();
                    answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    answerPanel.add(new JLabel(question.getAnswer()));
                    questionFrame.add(answerPanel);

                    // PlayerPanel
                    JPanel playersPanel = new JPanel();
                    playersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    for(Player player : players){
                        JButton btn = new JButton("Add points to: " + player.getPlayerName());
                        btn.addActionListener(ev -> {
                            player.setPlayerPoints(player.getPlayerPoints() + question.getPoints());
                            if(pointsLabel != null){
                                pointsLabel[player.getPlayerId()].setText(player.getPlayerPoints() + " pts");
                                GameWindow.updatePlayerPoints(player);
                            }
                        }); 
                            
                        playersPanel.add(btn);
                    }

                    questionFrame.add(playersPanel);
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
