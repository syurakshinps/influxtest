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


}
