package databases.mysql;

import databases.beans.Admin;
import databases.tables.AdminManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
     //   AdminManager.displayAllRows();

        int adminId = 1;
                Admin admin = AdminManager.getRow(adminId);
        if (admin == null) {
            System.out.println("No rows were found");
        } else {
            System.out.println("admin id: " + admin.getAdminId());
            System.out.println("userName: " + admin.getUserName());
            System.out.println("password: " + admin.getPassword());

        }
    }
}
