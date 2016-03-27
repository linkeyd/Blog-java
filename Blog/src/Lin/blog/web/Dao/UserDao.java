package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


import Lin.blog.web.bean.User;

import com.mysql.jdbc.PreparedStatement;

public class UserDao {
					private String sql;
					private int i = 0;
					/*
					 * 账户添加
					 */
					public int AddUser(User user)
					{
						try {
							sql="insert into user(id,username,password) values(?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, user.getId());
							stmt.setString(2, user.getUsername());
							stmt.setString(3, user.getPassword());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除账户
					 */
					public int DeleteUser(User user)
					{
						try {
							sql = "delete from user where id=?";
							BaseDao dao =new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, user.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改账户
					 */
					public int UpdateUser(User user)
					{
						try {
							sql = "update user set username=?,password=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, user.getUsername());
							stmt.setString(2, user.getPassword());
							stmt.setString(3, user.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找所有账户
					 */
					public ArrayList<User> SelectUser()
					{
						ArrayList<User> list = new ArrayList<User>();
						try {
							sql = "select * from user";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							while(rs.next())
							{
								User user = new User();
								user.setId(rs.getString("id"));
								user.setUsername(rs.getString("username"));
								user.setPassword(rs.getString("password"));
								list.add(i,user);
								i++;
							}
							dao.CloseAll(con, stmt, rs);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return list;
					}
					
					/*
					 * 用户登入
					 */
					public boolean Login(User user)
					{
						try {
							sql = "select * from user where (username=? and password=?)";
							BaseDao dao =new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, user.getUsername());
							stmt.setString(2, user.getPassword());
							ResultSet rs = stmt.executeQuery();
							if(rs.next())
							{
								dao.CloseAll(con, stmt, rs);
								return true;
							}
							else
							{
								dao.CloseAll(con, stmt, rs);
								return false;
							}
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
							return false;
						}
					}
					
					
}
