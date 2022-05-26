package databases.mysql;

import databases.DBType;
import databases.DBUtil;
import databases.tables.Pet;
import databases.tables.States;
import databases.tables.Tours;

import java.sql.*;

public class MySQLTest {
    private static final String SQL = "select * from states where stateId = ? limit 5";
    private static final String SQL_PROC = "{call GetToursByPrice (?)}";

    public static void main(String[] args) {

        double price = 0.0;
        ResultSet rs;
        try (
                Connection conn = DBUtil.getConnection(DBType.COURSES);
              //  PreparedStatement stmt = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                CallableStatement stmt = conn.prepareCall(SQL_PROC,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {

            //stmt.setString(1, "HI");
            stmt.setDouble(1,100);
            rs = stmt.executeQuery();
            Tours.displayData(rs);

        } catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

}
