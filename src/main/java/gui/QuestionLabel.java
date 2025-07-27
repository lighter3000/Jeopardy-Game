package gui;

import javax.swing.*;

//import db.QuestionRepository;
import model.Question;

public class QuestionLabel extends JButton{

    private Question q;

    public QuestionLabel(int id, int category_id, String question, String answer, int difficulty){
        q = new Question(id, category_id, question, answer, difficulty);
        setSize(250, 125);
        setText(q.getQuestion());
    }

    public Question getQuestion(){
        return q;
    }

    public String getQuestionText(){
        return getText();
    }


    
}
