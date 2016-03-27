package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.History;

public class HistoryDao {
					private String sql;
					private int i = 0;
					
					/*
					 * 添加历史日志
					 */
					public int AddHistory(History history)
					{
						try {
							sql = "insert into history(id,title,time,contenct,img) values (?,?,?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, history.getId());
							stmt.setString(2, history.getTitle());
							stmt.setString(3, history.getTime());
							stmt.setString(4, history.getContenct());
							stmt.setString(5, history.getImg());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除历史日志
					 */
					public int DeleteHistory(History history)
					{
						try {
							sql = "delete from history where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, history.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改历史日志
					 */
					public int UpdateHistory(History history)
					{
						try {
							sql = "update history set title=?,time=?,contenct=?,img=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, history.getTitle());
							stmt.setString(2, history.getTime());
							stmt.setString(3, history.getContenct());
							stmt.setString(4, history.getImg());
							stmt.setString(5, history.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找历史日志
					 */
					public ArrayList<History> SelectHistory()
					{
						ArrayList<History> list = new ArrayList<History>();
						try {
							sql = "select * from history";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							while(rs.next())
							{
								History history = new History();
								history.setId(rs.getString("id"));
								history.setImg(rs.getString("img"));
								history.setTime(rs.getString("time"));
								history.setTitle(rs.getString("title"));
								history.setContenct(rs.getString("contenct"));
								list.add(i,history);
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
