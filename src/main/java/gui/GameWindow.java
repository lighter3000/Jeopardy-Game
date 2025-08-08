package gui;

import javax.swing.*;
import java.util.*;

import generator.CategoryGenerator;
import model.*;

public class GameWindow extends JFrame{
    
    private static List<Category> categories;

    public GameWindow(String text){
        super(text);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setSize(1440, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void addCategories(int amountCategories){
        categories = CategoryGenerator.generateCategories(amountCategories);
        for(Category category : categories){
            addCategory(category);
        }
        revalidate();
        repaint();
    }

    private void addCategory(Category category){
        CategoryPanel catP = new CategoryPanel(category);
        getContentPane().add(catP);
    }

    public static List<Category> getCategories(){
        return categories;
    }



    
}
