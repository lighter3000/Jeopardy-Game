package generator;

import model.Category;
import model.Question;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnector;

/*
 * TODO:
 * 
 * Catch Exceptions
 * What if there are no questions or categories
 * Limit amountCategories
 */


public class CategoryGenerator {

    public List<Category> generateCategories(int amountCategories){
        List<Category> result = new ArrayList<>();

        try (Connection con = DBConnector.connect()) {
            String query = """
                    SELECT DISTINCT id, name FROM categories ORDER BY RANDOM() LIMIT ?
                    """;
            PreparedStatement s = con.prepareStatement(query);
            s.setInt(1, amountCategories);

            ResultSet rs = s.executeQuery();
            
            while(rs.next()){
                int category_id = rs.getInt("id");
                String categoryName = rs.getString("name");
                Category category = new Category(category_id, categoryName);

                String queryQuestion = """
                    (
                        SELECT id, category_id, question, answer, difficulty
                        FROM questions
                        WHERE category_id = ? AND difficulty = 1
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_id, question, answer, difficulty
                        FROM questions
                        WHERE category_id = ? AND difficulty = 2
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_id, question, answer, difficulty
                        FROM questions
                        WHERE category_id = ? AND difficulty = 3
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_id, question, answer, difficulty
                        FROM questions
                        WHERE category_id = ? AND difficulty = 4
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_id, question, answer, difficulty
                        FROM questions
                        WHERE category_id = ? AND difficulty = 5
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    ORDER BY difficulty;
                    """;
                PreparedStatement sQuestion = con.prepareStatement(queryQuestion);
                for(int i=1; i<=5; i++){
                    sQuestion.setInt(i, category_id);
                }
                
                ResultSet rsQuestion = sQuestion.executeQuery();

                while(rsQuestion.next()){
                    Question q = new Question(
                        rsQuestion.getInt("id"), 
                        rsQuestion.getInt("category_id"), 
                        rsQuestion.getString("question"), 
                        rsQuestion.getString("answer"), 
                        rsQuestion.getInt("difficulty"));
                    category.addQuestion(q);
                }
                result.add(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
