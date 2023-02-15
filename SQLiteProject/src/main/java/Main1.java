import java.sql.*;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:notatnik1111.db");
        Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS notes (text TEXT)");
            System.out.println("Dodaj notatke:");
            while (true) {
                String notatka = scanner.nextLine();
                if (notatka.equals("EXIT")) {
                    break;
                }
                statement.executeUpdate("INSERT INTO notes (text) VALUES ('" + notatka + "')");
            }
            ResultSet resultSet = statement.executeQuery("SELECT text FROM notes");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("text"));
            }
        }
    }

