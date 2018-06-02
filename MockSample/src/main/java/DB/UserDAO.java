package DB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {

    private DataSource ds;

    public UserDAO(DataSource ds) {
        this.ds = ds;
    }

    public void create(User user) {
        String sql = "INSERT INTO auth_user (id, username, password) values (?, ?, ?)";
        try {
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn
                    .prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User select(int id) {
        String sql = "SELECT id,username,password FROM auth_user WHERE id = ?";
        User user = null;
        try {
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }

            user = new User();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void update(User user) {
        String sql = "UPDATE auth_user SET username=?, password=? WHERE id=?";
        try {
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn
                    .prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = ds.getConnection();
            PreparedStatement stmt = conn
                    .prepareStatement("DELETE FROM auth_user WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

