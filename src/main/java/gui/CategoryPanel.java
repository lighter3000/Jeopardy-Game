package gui;

import javax.swing.*;

import model.Category;
import model.Question;

public class CategoryPanel extends JPanel{

    public CategoryPanel(Category category){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(300, 855);
        JLabel categoryLabel = new JLabel(category.getCategory());
        add(categoryLabel);
        for(Question q : category.getAllQuestion()){
            addQuestionLabel(q);
        }

    }

    private void addQuestionLabel(Question question){
        QuestionLabel qL = new QuestionLabel(question.getId(), 
                question.getCategory_id(), 
                question.getQuestion(), 
                question.getAnswer(), 
                question.getPoints());
        add(qL);
    }
    
}
