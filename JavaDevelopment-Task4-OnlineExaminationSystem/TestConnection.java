import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/online_exam";
        String username = "root";
        String password = "Root@123";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("=================================");
            System.out.println(" MySQL Connected Successfully!");
            System.out.println("=================================");

            con.close();

        } catch (Exception e) {

            System.out.println("Connection Failed!");
            System.out.println(e);

        }

    }

}