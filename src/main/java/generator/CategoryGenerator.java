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
 * 
 * 
 * Refactor multi-UNION query:
 * Try loading 5 random questions with different difficulties in a more elegant way,
 * ideally without repeating the query 5 times.
 * 
 */


public class CategoryGenerator {

    public static List<Category> generateCategories(int amountCategories){
        List<Category> result = new ArrayList<>();

        try (Connection con = DBConnector.connect()) {
            String query = """
                    SELECT DISTINCT id, name FROM categories ORDER BY rand() LIMIT ?
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
                        SELECT id, category_name, question, answer, difficulty
                        FROM questions
                        WHERE category_name = ? AND difficulty = 1
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_name, question, answer, difficulty
                        FROM questions
                        WHERE category_name = ? AND difficulty = 2
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_name, question, answer, difficulty
                        FROM questions
                        WHERE category_name = ? AND difficulty = 3
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_name, question, answer, difficulty
                        FROM questions
                        WHERE category_name = ? AND difficulty = 4
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    UNION ALL
                    (
                        SELECT id, category_name, question, answer, difficulty
                        FROM questions
                        WHERE category_name = ? AND difficulty = 5
                        ORDER BY RAND()
                        LIMIT 1
                    )
                    """;
                PreparedStatement sQuestion = con.prepareStatement(queryQuestion);
                for(int i=1; i<=5; i++){
                    sQuestion.setString(i, categoryName);
                }
                
                ResultSet rsQuestion = sQuestion.executeQuery();

                while(rsQuestion.next()){
                    Question q = new Question(
                        rsQuestion.getInt("id"), 
                        rsQuestion.getString("category_name"), 
                        rsQuestion.getString("question"), 
                        rsQuestion.getString("answer"), 
                        rsQuestion.getInt("difficulty"));
                    category.addQuestion(q);
                }

                rsQuestion.close();
                sQuestion.close();
                result.add(category);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
