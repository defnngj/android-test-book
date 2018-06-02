package mockDB;

import DB.DBConnect;

import java.sql.ResultSet;

/**
 * 连接真实的邮箱进行测试
 */
public class DBConnectTest {


    public static void main(String[] args) {
        String sql = "select * from auth_user";

        DBConnect db = new DBConnect();

        try {
            ResultSet rs = db.select(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String name = rs.getString("username");
                String email = rs.getString("email");

                // 输出数据
                System.out.print("用户: " + name);
                System.out.print(", 邮箱: " + email);
                System.out.print("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
