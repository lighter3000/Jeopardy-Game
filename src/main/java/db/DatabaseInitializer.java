package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private static void createTables(Connection con){
        try(Statement stmt = con.createStatement()){
            
            // Creating Tables
            String createCategories = """
                    CREATE TABLE IF NOT EXISTS categories (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL UNIQUE
                    );
                    """;

            String createQuestions = """
                    CREATE TABLE IF NOT EXISTS questions (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    category_id INT NOT NULL,
                    question TEXT NOT NULL UNIQUE,
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

    private static void addCategories(Connection con){
        try (InputStream is = DatabaseInitializer.class.getClassLoader().getResourceAsStream("categories.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                boolean headerSkipped = false;
                while ((line = reader.readLine()) != null) {
                    if (!headerSkipped) { headerSkipped = true; continue; }

                    String[] parts = line.split(",");
                    String name = parts[1].trim();

                    // INSERT INTO categories (name) VALUES (?)
                    try (PreparedStatement stmt = con.prepareStatement("INSERT INTO categories (name) VALUES (?)")) {
                        stmt.setString(1, name);
                        stmt.executeUpdate();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addQuestions(Connection con){
        try (InputStream is = DatabaseInitializer.class.getClassLoader().getResourceAsStream("questions.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                boolean headerSkipped = false;
                while ((line = reader.readLine()) != null) {
                    if (!headerSkipped) { headerSkipped = true; continue; }

                    String[] parts = line.split(",");
                    int categoryId = Integer.parseInt(parts[0]);
                    String question = parts[1];
                    String answer = parts[2];
                    int difficulty = Integer.parseInt(parts[3]);

                    // INSERT INTO categories (name) VALUES (?)
                    try (PreparedStatement stmt = con.prepareStatement("INSERT INTO questions (category_id, question, answer, difficulty) VALUES (?,?,?,?)")) {
                        stmt.setInt(1, categoryId);
                        stmt.setString(2, question);
                        stmt.setString(3, answer);
                        stmt.setInt(4, difficulty);
                        stmt.executeUpdate();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection con = DBConnector.connect();
        createTables(con);
        addCategories(con);
        addQuestions(con);
    }
    
}
