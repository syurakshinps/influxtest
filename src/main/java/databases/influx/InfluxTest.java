package databases.influx;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

public class InfluxTest {

    public static void main(String[] args) {
        String databaseURL = "http://127.0.0.1:8086";
        String userName = "telegraf";
        String password = "password";
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);

        Pong response = influxDB.ping();
        if (response.getVersion().equalsIgnoreCase("unknown")) {
            System.out.println("error");
            //log.error("Error pinging server.");
            return;
        }
        String dbName = "telegrafdb";
        System.out.println(influxDB.databaseExists(dbName));


        QueryResult queryResult = influxDB.query(new Query("select * from cpu",dbName));
        System.out.println(queryResult);
    }
}
