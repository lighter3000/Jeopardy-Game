package gui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import model.*;

public class AdminWindow extends JFrame{
    
    public AdminWindow(String text){
        super(text);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setSize(1440, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void copyCategories(){
        List<Category> categories = GameWindow.getCategories();
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
    
}
