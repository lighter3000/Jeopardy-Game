package gui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;

import model.Category;
import model.Question;

public class CategoryPanel extends JPanel{

    public CategoryPanel(Category category){
        super();
        setLayout(new GridLayout(6,1));
        setPreferredSize(new Dimension(200, 900));
        setMaximumSize(getMaximumSize());

        JLabel categoryLabel = new JLabel(category.getCategory());
        categoryLabel.setHorizontalAlignment(JLabel.CENTER);
        add(categoryLabel);
        for(Question q : category.getAllQuestion()){
            addQuestionLabel(q);
        }

    }

    private void addQuestionLabel(Question question){
        QuestionLabel qL = new QuestionLabel(question.getId(), 
                question.getCategoryName(), 
                question.getQuestion(), 
                question.getAnswer(), 
                question.getPoints());
        add(qL);
    }
    
}
