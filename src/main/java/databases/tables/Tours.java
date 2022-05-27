package databases.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tours {

    public static void displayData(ResultSet rs, int nRows) throws SQLException {
        System.out.println(nRows);

        while (rs.next()) {

            StringBuffer buffer = new StringBuffer();
            BigDecimal tourId = rs.getObject("tourId",BigDecimal.class);
            BigDecimal packageId = rs.getObject("packageId",BigDecimal.class);
            String tourName = rs.getObject("tourName",String.class);
            buffer.append(tourId);
            buffer.append(packageId);
            buffer.append(" " + tourName);
            System.out.println(buffer);



        }
    }
}
