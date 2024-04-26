import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");

            // Example Input
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter First Name: ");
            String fname = scan.nextLine();

            System.out.println("Enter Last Name: ");
            String lname = scan.nextLine();

            String sql = "INSERT INTO patients (first_name, last_name) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);

            pstmt.executeUpdate();

            System.out.println("Insert Completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
