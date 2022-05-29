package databases.mysql;

import databases.DBType;
import databases.beans.Admin;
import databases.beans.ConnectionManager;
import databases.tables.AdminManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ConnectionManager.getInstance().setDBType(DBType.COURSES);

        AdminManager.displayAllRows();

        int adminId = 1;
                Admin admin = AdminManager.getRow(adminId);
        if (admin == null) {
            System.out.println("No rows were found");
        } else {
            System.out.println("admin id: " + admin.getAdminId());
            System.out.println("userName: " + admin.getUserName());
            System.out.println("password: " + admin.getPassword());

        }

        Admin bean = new Admin();
        bean.setUserName("John");
        bean.setPassword("1234");
        boolean result = AdminManager.insert(bean);
        if (result){
            System.out.println("New line with pk " + bean.getAdminId() + " was inserted");
        } else
        {
            System.err.println("No rows were affected");
        }
        admin.setPassword("1234password1234");
        if (AdminManager.update(admin)){
            System.out.println("ok");
        }else{
            System.err.println("whoops");
        }


        if (AdminManager.delete(4)){
            System.out.println("deleted 3");
        }else
        {
            System.err.println("something went wrong");
        }

        ConnectionManager.getInstance().close();
    }
}
