package mockDB;

import java.sql.*;

public class DBConnect {

    /**
     *   JDBC 驱动名及数据库 URL
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/guest_test?useSSL=false&serverTimezone=UTC";

    /**
     * 数据库的用户名与密码，需要根据自己的设置
     */
    static final String USER = "root";
    static final String PASS = "";

    public Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Connection getConnection() throws SQLException,ClassNotFoundException{

        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 根据数据库参数取得一个数据库连接
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    /**
     * 根据传入的SQL语句返回一个结果集
     */
    public ResultSet select(String sql) throws Exception {
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException sqle) {
            throw new SQLException("select data exception: "
                    + sqle.getMessage());
        } catch (Exception e) {
            throw new Exception("System e exception: " + e.getMessage());
        }

    }
}
