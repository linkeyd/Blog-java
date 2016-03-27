package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.Rest;

public class RestDao {
					private String sql;
					private int i = 0;
					/*
					 * 添加 其他日志
					 */
					public int AddRest(Rest rest)
					{
						try {
							sql="insert into rest(id,title,time,img,contenct) values(?,?,?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, rest.getId());
							stmt.setString(2, rest.getTitle());
							stmt.setString(3, rest.getTime());
							stmt.setString(4, rest.getImg());
							stmt.setString(5, rest.getContenct());
							i = stmt.executeUpdate();
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除其他日志
					 */
					public int DeleteRest(Rest rest)
					{
						try {
							sql="delete from rest where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, rest.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改其他日志
					 */
					public int UpdateRest(Rest rest)
					{
						try {
							sql ="update rest set title=?,time=?,img=?,contenct=? where id=?";
							BaseDao dao =new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, rest.getTitle());
							stmt.setString(2, rest.getTime());
							stmt.setString(3, rest.getImg());
							stmt.setString(4, rest.getContenct());
							stmt.setString(5, rest.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找其他日志
					 */
					public ArrayList<Rest> SelectRest()
					{
						ArrayList<Rest> list = new ArrayList<Rest>();
						try {
							sql="select * from rest";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							while(rs.next())
							{
								Rest rest =new Rest();
								rest.setId(rs.getString("id"));
								rest.setTitle(rs.getString("title"));
								rest.setTime(rs.getString("time"));
								rest.setImg(rs.getString("img"));
								rest.setContenct(rs.getString("contenct"));
								list.add(i,rest);
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
