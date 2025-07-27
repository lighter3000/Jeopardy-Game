package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Category {

    private int id;
    private String category;
    private List<Question> questions;

    public Category(int id, String category, Question[] questions){ // Später vielleicht automatisch in die Datenbank einfügen
        this.id = id;
        this.category = category;
        this.questions = new ArrayList<>(Arrays.asList(questions));
    }

    public Category(int id, String category){
        this.id = id;
        this.category = category;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q){
        questions.add(q);
    }

    public String getCategory(){
        return category;
    }

    public List<Question> getAllQuestion(){
        return questions;
    }

    public List<Question> getXQuestions(int x){ // Später mit Datenbankverbindung ersetzen (?)
        Random rand = new Random();
        List<Question> result = new ArrayList<>();
        int n=0;
        for(int i=0; i<x; i++){
            n = rand.nextInt(x);
            result.add(questions.get(n));
        }
        return result;
    }


    
}
