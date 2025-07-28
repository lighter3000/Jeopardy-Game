package model;

public class Question {

    private int id;
    private int category_id;
    private String question;
    private String answer;
    private int difficulty;

    public Question(int id, int category_id, String question, String answer, int difficulty){
        this.id = id;
        this.category_id = category_id;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public int getId(){
        return id;
    }

    public int getCategory_id(){
        return category_id;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public int getPoints(){
        return difficulty * 10;
    }

    
}
