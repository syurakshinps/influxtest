package databases.mysql;

import databases.DBType;
import databases.DBUtil;

import java.sql.*;

public class MySQLTest {


    public static void main(String[] args) {

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("DESCRIBE pet");

        ) {

            rs.last();
            System.out.println("number of rows " + rs.getRow());

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

}
