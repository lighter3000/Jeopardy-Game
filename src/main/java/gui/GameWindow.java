package gui;

import javax.swing.*;
import java.util.*;

import generator.CategoryGenerator;
import model.*;

public class GameWindow extends JFrame{
    
    public GameWindow(String text){
        super(text);
        setSize(1440, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addCategories(int amountCategories){
        List<Category> categories = CategoryGenerator.generateCategories(amountCategories);
        
    }



    
}
