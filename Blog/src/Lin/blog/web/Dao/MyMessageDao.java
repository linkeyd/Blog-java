package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.MyMessage;

public class MyMessageDao {
					private String sql;
					private int i = 0;
					/*
					 * 添加留言信息
					 */
					public int AddMyMessage(MyMessage message)
					{
						try {
							sql = "insert into  mymessage(id,name,phone,message,email) values(?,?,?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, message.getId());
							stmt.setString(2, message.getName());
							stmt.setString(3, message.getPhone());
							stmt.setString(4, message.getMessage());
							stmt.setString(5, message.getEmail());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除留言信息
					 */
					public int DeleteMyMessage(MyMessage message)
					{
						try {
							sql = "delete from mymessage where id=?";
							BaseDao dao = new BaseDao();
							Connection con =dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1,message.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改留言信息
					 */
					public int UpdateMyMessage(MyMessage message)
					{
						try {
							sql = "update mymessage set name=?,phone=?,message=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1,message.getName());
							stmt.setString(2, message.getPhone());
							stmt.setString(3, message.getMessage());
							stmt.setString(4, message.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找留言信息
					 */
					public ArrayList<MyMessage> SelectMyMessage()
					{
						ArrayList<MyMessage> list = new ArrayList<MyMessage>();
						try {
							sql = "select * from mymessage";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs =stmt.executeQuery();
							while(rs.next())
							{
								MyMessage message = new MyMessage();
								message.setId(rs.getString("id"));
								message.setMessage(rs.getString("message"));
								message.setName(rs.getString("name"));
								message.setPhone(rs.getString("phone"));
								message.setEmail(rs.getString("email"));
								list.add(i,message);
								i++;
							}
							dao.CloseAll(con, stmt, rs);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return list;
					}
}
