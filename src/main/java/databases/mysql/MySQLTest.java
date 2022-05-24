package databases.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLTest {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "123";
    private static final String CONN_STRING ="jdbc:mysql://localhost/mybase";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("connected to " + CONN_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
            //System.err.println();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

}
