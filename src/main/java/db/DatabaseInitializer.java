package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void createTables(){
        try(Connection con = DBConnector.connect();
            Statement stmt = con.createStatement()){
            
            // Creating Tables
            String createCategories = """
                    CREATE TABLE IF NOT EXISTS categories (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL
                    );
                    """;

            String createQuestions = """
                    CREATE TABLE IF NOT EXISTS questions (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    category_id INT NOT NULL,
                    question TEXT NOT NULL,
                    answer TEXT NOT NULL,
                    difficulty INT CHECK (difficulty IN (1, 2, 3, 4, 5)),
                    FOREIGN KEY (category_id) REFERENCES categories(id)
                    );
                    """;
            
            stmt.execute(createCategories);
            stmt.execute(createQuestions);

            System.out.println("Tabellen erfolreich erstellt");

        } catch(SQLException e){
            System.err.println("Error at creating tables");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
    
}
