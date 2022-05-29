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

String sql = "SELECT 100 - mean(\"usage_idle\") FROM \"cpu\" WHERE (\"cpu\" =~ /cpu[0-9].*/) " +
        "AND time >= 1653598800000ms and time <= 1653685199000ms GROUP BY time(1m)";
        QueryResult queryResult = influxDB.query(new Query(sql,dbName));




        System.out.println(queryResult);
    }
}
