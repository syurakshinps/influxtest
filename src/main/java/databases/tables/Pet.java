package databases.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Pet {
    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()){

            StringBuffer buffer = new StringBuffer();

            String name = rs.getObject("name",String.class);
            BigDecimal price = rs.getObject("price",BigDecimal.class);
            String owner = rs.getObject("owner",String.class);

/*            String name = rs.getString("name");
            double price = rs.getDouble("price");
            String owner = rs.getString("owner");*/


            buffer.append("pet " + rs.getRow() + ":");
            buffer.append(name);

            NumberFormat nf = NumberFormat.getCurrencyInstance();
            String formattedPrice = nf.format(price);

            buffer.append(" (" + formattedPrice + "). ");
            buffer.append("The owner of the pet is " + owner);

            System.out.println(buffer);
        }
    }
}
