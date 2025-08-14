package gui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;

import generator.CategoryGenerator;
import model.*;

public class GameWindow extends JFrame{

    private final boolean isAdminMode = false;
    private final JPanel categoriesContainer;
    private final JPanel playersBar;
    private static List<Category> categories;

    public GameWindow(String text){
        super(text);

        setLayout(new BorderLayout());
        
        // CENTER: categories stacked vertically

        categoriesContainer = new JPanel();
        categoriesContainer.setLayout(new BoxLayout(categoriesContainer, BoxLayout.X_AXIS));
        add(categoriesContainer, BorderLayout.CENTER);


        // SOUTH: players bar
        playersBar = new JPanel(new GridLayout(1,0,8,0));
        add(playersBar, BorderLayout.SOUTH);


        setSize(1440, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void addCategories(int amountCategories){
        categories = CategoryGenerator.generateCategories(amountCategories);
        for(Category category : categories){
            addCategory(category);
        }
        categoriesContainer.revalidate();
        categoriesContainer.repaint();
    }

    private void addCategory(Category category){
        CategoryPanel catP = new CategoryPanel(category, isAdminMode);
        categoriesContainer.add(catP);
    }

    public static List<Category> getCategories(){
        return categories;
    }

    public void addPlayers(Player[] players) {
        
        playersBar.setLayout(new GridLayout(1, 0, 8, 0)); // 1 row, as many columns as needed
        playersBar.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        playersBar.removeAll();
        if (players != null) {
            for (Player p : players) {
                playersBar.add(addPlayerLabel(p));
            }
        }
        playersBar.revalidate();
        playersBar.repaint();
    }

    private JPanel addPlayerLabel(Player player) {
        // A tiny "card": 2 rows (name, points), thin border, centered text
        JPanel card = new JPanel(new GridLayout(2, 1, 0, 4));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        String nameText = (player != null && player.getPlayerName() != null) ? player.getPlayerName() : "Player";
        int pointsVal = (player != null) ? player.getPlayerPoints() : 0;

        JLabel name = new JLabel(nameText, SwingConstants.CENTER);
        name.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel points = new JLabel(pointsVal + " pts", SwingConstants.CENTER);

        card.add(name);
        card.add(points);
        return card;
    }



    
}
