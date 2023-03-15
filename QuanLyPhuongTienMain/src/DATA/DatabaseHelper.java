package DATA;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class DatabaseHelper {

    public static Connection openConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QLPhuongTien;";
        String username = "sa";
        String userpass = "12345678";
        Connection con = DriverManager.getConnection(connectionUrl, username, userpass);
        return con;
    }
}
