package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import db.QuestionRepository;
import model.Question;

public class QuestionLabel extends JButton{

    private Question q;

    public QuestionLabel(int id, int category_id, String question, String answer, int difficulty){
        q = new Question(id, category_id, question, answer, difficulty);
        setSize(150, 125);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane pane = new JOptionPane(
                    question,
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION
                );
                JDialog dialog = pane.createDialog("Question");
                dialog.setModal(false);
                dialog.setVisible(true);
                setText("GONE");
                setBackground(new Color(255, 102, 102));
            }
        }); // When the question and answer panel is being opened, they should not appear on the same monitor, so maybe open it inside the Frame?
        
        setText(String.valueOf(q.getPoints())); // Later change it to difficulty
    }

    public Question getQuestion(){
        return q;
    }

    public String getQuestionText(){
        return getText();
    }


    
}
