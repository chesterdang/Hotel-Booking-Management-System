package util;
import java.sql.*;


public class JDBCUtill {

//    private static ResourceBundle rb = ResourceBundle.getBundle("sql_drive_connection");

    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        StringBuilder url = new StringBuilder("jdbc:sqlserver://localhost:1433;");
        url.append("database= BookingHotel;");
        url.append("encrypt=false;");
        url.append("trustServerCertificate=false;");
        url.append("loginTimeout=30;");

        try {     
            Connection conn = DriverManager.getConnection(url.toString(), "sa", "112233");
            if (conn != null) {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
