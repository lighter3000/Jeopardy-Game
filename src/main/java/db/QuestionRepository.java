package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Question;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionRepository {

    public static Question getQuestionById(int QuestionId){
        Question question = null;
        try(Connection con = DBConnector.connect()){

            String query = """
                    SELECT id, category_id, question, answer, difficulty FROM questions WHERE id=?
                    """;
            PreparedStatement s = con.prepareStatement(query);
            s.setInt(1, QuestionId);

            ResultSet rs = s.executeQuery();

            if(rs.next()){
                question = new Question(
                    rs.getInt("id"), 
                    rs.getInt("category_id"), 
                    rs.getString("question"), 
                    rs.getString("answer"), 
                    rs.getInt("difficulty"));
            } else {
                System.err.println("Id not found: " + QuestionId);
            }
            
            s.close();
            
        } catch (SQLException e){
            System.err.println("Error at taking Question by id");
            e.printStackTrace();
        }

        return question;

    }
    
}
