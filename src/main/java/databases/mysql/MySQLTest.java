package databases.mysql;

import databases.DBType;
import databases.DBUtil;

import java.sql.*;

public class MySQLTest {


    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
           // conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            conn = DBUtil.getConnection(DBType.MYSQL);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("DESCRIBE pet");

            rs.last();
            System.out.println("number of rows " + rs.getRow());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
