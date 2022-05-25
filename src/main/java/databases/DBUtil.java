package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "123";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/mybase";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
            case ORACLEDB:
                return null;
            case INFLUXDB:
                return null;
            default:
                return null;
        }

    }
    public static void processException(SQLException e){
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }


}
