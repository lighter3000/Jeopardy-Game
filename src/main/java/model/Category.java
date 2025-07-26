package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Category {

    private String category;
    private List<Question> question;

    public Category(String category, Question[] question){ // Später vielleicht automatisch in die Datenbank einfügen
        this.category = category;
        this.question = new ArrayList<>(Arrays.asList(question));
    }

    public List<Question> getAllQuestion(){
        return question;
    }

    public List<Question> getXQuestions(int x){ // Später mit Datenbankverbindung ersetzen (?)
        Random rand = new Random();
        List<Question> result = new ArrayList<>();
        int n=0;
        for(int i=0; i<x; i++){
            n = rand.nextInt(x);
            result.add(question.get(x));
        }
        return result;
    }
    
}
