package databases.tables;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import databases.DBType;
import databases.DBUtil;
import databases.beans.Admin;

import java.sql.*;

public class AdminManager {
    public static void displayAllRows() {
        String sql = "SELECT adminId, password, userName FROM admin";
        try (
                Connection conn = DBUtil.getConnection(DBType.COURSES);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

           System.out.println("admin table: ");
            while (rs.next()) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(rs.getInt("adminId") + ": ");
                buffer.append(rs.getString("userName") + ", ");
                buffer.append(rs.getString("password"));
                System.out.println(buffer);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Admin getRow(int adminId) throws SQLException {
        String sql = "SELECT * from admin where adminId = ?";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.COURSES);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, adminId);
            rs = stmt.executeQuery();

            if (rs.next()){
                Admin admin = new Admin();
                admin.setAdminId(adminId);
                admin.setUserName(rs.getObject("UserName", String.class));
                admin.setPassword(rs.getObject("password", String.class));
                return admin;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (rs != null){
                rs.close();
            }
        }
    }

    public static boolean insert (Admin bean) throws SQLException {
        String sql = "INSERT into admin (userName, password) " +
                "VALUES(?, ?)";
        ResultSet keys  = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.COURSES);
                PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                )
        {

            stmt.setString(1, bean.getUserName());
            stmt.setString(2, bean.getPassword());
            int affected = stmt.executeUpdate();

            if (affected == 1) {
            keys = stmt.getGeneratedKeys();
            keys.next();
            int newKey = keys.getInt(1);
            bean.setAdminId(newKey);

            } else {
                System.err.println("No rows were affected");
                return false;
            }

        }catch (SQLException e){
                e.printStackTrace();
                return false;
        } finally {
                if (keys != null) keys.close();
        }
        return true;

    }
}

