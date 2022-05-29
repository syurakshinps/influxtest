package databases.beans;

import databases.DBType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    private static ConnectionManager instance = null;

    private  final String USERNAME = "test";
    private  final String PASSWORD = "123";
    private  final String M_CONN_STRING = "jdbc:mysql://localhost/mybase";
    private  final String M_CONN_STRING_COURSES = "jdbc:mysql://localhost/explorecalifornia";

    private DBType dbType = DBType.COURSES;

    private Connection conn = null;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void setDBType(DBType dbType) {
        this.dbType = dbType;
    }

    private boolean openConnection()
    {
        try {
            switch (dbType) {

                case MYSQL:
                    conn = DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
                    return true;

                case COURSES:
                    conn = DriverManager.getConnection(M_CONN_STRING_COURSES, USERNAME, PASSWORD);
                    return true;

                default:
                    return false;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public Connection getConnection()
    {
        if (conn == null) {
            if (openConnection()) {
                System.out.println("Connection opened");
                return conn;
            } else {
                return null;
            }
        }
        return conn;
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
        }
    }

}