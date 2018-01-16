package mockDB;

import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;


public class UserDAOTest {

    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;
    private User user;

    @Before
    public void setUp() throws Exception {
        ds = mock(DataSource.class);
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        stmt = mock(PreparedStatement.class);

        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(conn);

        user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin123");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(user.getUsername());
        when(rs.getString(3)).thenReturn(user.getPassword());

        when(stmt.executeQuery()).thenReturn(rs);

    }

    @Test(expected=Exception.class)
    public void nullCreateThrowsException() {
        new UserDAO(ds).create(null);
    }

    @Test
    public void createPerson() {
        new UserDAO(ds).create(user);
    }

    @Test
    public void createAndSelectUser() throws SQLException {

        UserDAO dao = new UserDAO(ds);
        // 创建数据
        dao.create(user);
        // 查询数据
        User result = dao.select(1);
        // 断言查询结果
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
    }

    @Test
    public void createAndUpdateUser() throws SQLException {
        UserDAO dao = new UserDAO(ds);
        // 创建数据
        dao.create(user);
        // 更新用户
        user = new User();
        user.setId(1);
        user.setUsername("guest");
        user.setPassword("guest123");
        dao.update(user);
    }

    @Test
    public void createAndDeleteUser() throws SQLException {
        UserDAO dao = new UserDAO(ds);
        // 创建数据
        dao.create(user);
        // 删除用户
        dao.delete(1);
    }


}
