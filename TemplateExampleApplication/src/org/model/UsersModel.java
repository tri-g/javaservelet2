package org.model;
import org.entity.User;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.DataSource;

public class UsersModel 
{
	public List<User> listUsers(DataSource dataSource)
	{
		List<User> listUsers=new ArrayList<>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String query="select * from users";
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				listUsers.add(new User(rs.getInt("users_id"),rs.getString("username"),rs.getString("email")))	;
				}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return listUsers;
	}

}
