package gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ThemeLabel extends JLabel{
    
    public ThemeLabel(String theme){
        setSize(250, 125);
    }

    /*
     * @param count - Add the amount of Themes  
     * 
     */
    public ThemeLabel addThemes(int count){
        
        if(count < 3 || count > 5){
            throw new IllegalArgumentException("");
        }
        
        ThemeLabel[] newThemes = new ThemeLabel[count];
        List<String> themes = new ArrayList<>(); // Change it to take 'count' random themes from DBConnection

        for(int i=0; i<count; i++){
            ThemeLabel t = new ThemeLabel(themes.get(i));
            t.addQuestion();


            newThemes[i] = t;
        }
        ThemeLabel newTheme = new ThemeLabel("test"); // Connect to the db and take 'count' themes


        return newTheme;
    }

    private QuestionLabel addQuestion(){
        QuestionLabel q = new QuestionLabel();
        

        return q;
    }

}
