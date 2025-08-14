package gui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;

import model.Category;
import model.Question;

public class CategoryPanel extends JPanel{

    public CategoryPanel(Category category, boolean adminMode){
        super();
        setLayout(new GridLayout(6,1));
        setPreferredSize(new Dimension(200, 700));
        setMaximumSize(getMaximumSize());

        JLabel categoryLabel = new JLabel(category.getCategory());
        categoryLabel.setHorizontalAlignment(JLabel.CENTER);
        add(categoryLabel);
        for(Question q : category.getAllQuestion()){
            addQuestionLabel(q, adminMode);
        }

    }

    private void addQuestionLabel(Question question, boolean adminMode){
        QuestionLabel qL = new QuestionLabel(question, adminMode);
        add(qL);
    }
    
}
