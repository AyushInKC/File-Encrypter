package DAO;

import Model.User;
import db.MyConnection;

import javax.naming.CompositeName;
import java.sql.*;

public class UserDAO{
    public static boolean isExists(String Email) throws SQLException {
        Connection connection= MyConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("select email from users");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String e=rs.getString(1);
            if(e.equals(Email)){
                return true;
            }
        }
        return false;
    }

    public static int saveUser(User user) throws SQLException{
        Connection connection=MyConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement("insert into user's value(default, ? ,? )");
        ps.setString(1,user.getName());
        ps.setString(2, user.getEmail());

        return ps.executeUpdate();
    }
}
