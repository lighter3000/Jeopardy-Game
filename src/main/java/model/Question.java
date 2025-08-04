package model;

public class Question {

    private int id;
    private String category_name;
    private String question;
    private String answer;
    private int difficulty;

    public Question(int id, String category_name, String question, String answer, int difficulty){
        this.id = id;
        this.category_name = category_name;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public int getId(){
        return id;
    }

    public String getCategoryName(){
        return category_name;
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
