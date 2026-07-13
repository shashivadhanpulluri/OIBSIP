import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/online_exam";
        String dbUser = "root";
        String dbPassword = "Root@123";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try {

            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println();
                System.out.println("=================================");
                System.out.println(" Login Successful!");
                System.out.println(" Welcome " + rs.getString("name"));
                System.out.println("=================================");

            } else {

                System.out.println();
                System.out.println("Invalid Username or Password!");

            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }

        sc.close();
    }
}