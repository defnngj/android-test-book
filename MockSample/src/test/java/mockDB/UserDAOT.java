package mockDB;

import java.sql.*;

public class UserDAOT {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/guest_test?useSSL=false&serverTimezone=UTC";

    /**
     * 数据库的用户名与密码，需要根据自己的设置
     */
    static final String USER = "root";
    static final String PASS = "";



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 根据数据库参数取得一个数据库连接
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // conn = (Connection) new UserDAO(conn);
    }
}
