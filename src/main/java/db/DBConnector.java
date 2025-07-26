package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String URL_DEFAULT = "jdbc:mysql://localhost:3306/jeopardy?useSSL=false&serverTimezone=UTC";
    private static final String USER_DEFAULT = "root";
    private static final String PASSWORD_DEFAULT = "";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL_DEFAULT, USER_DEFAULT, PASSWORD_DEFAULT);
    }



    public static void main(String[] args) {
        try(Connection conn = connect()){
            System.out.println("Verbindung erfolgreich");
        } catch (SQLException e){
            System.err.println("Verbindung fehlgeschlagen");
            e.printStackTrace();
        }
    }
}
