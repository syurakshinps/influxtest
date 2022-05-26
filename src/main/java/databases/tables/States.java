package databases.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class States {
    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()){

            StringBuffer buffer = new StringBuffer();

            String stateId = rs.getObject("stateId",String.class);
            String stateName = rs.getObject("stateName",String.class);




            buffer.append("Table is states, row is " + rs.getRow() + ": ");
            buffer.append("stateId: " + stateId + "; ");
            buffer.append("stateName: " + stateName);

            System.out.println(buffer);
        }
    }
}
