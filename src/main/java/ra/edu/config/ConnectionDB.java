package ra.edu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo?createDatabaseIfNotExist=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456$";
    // mở kết nối
    public static Connection openConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // đóng kết nối
    public static void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
