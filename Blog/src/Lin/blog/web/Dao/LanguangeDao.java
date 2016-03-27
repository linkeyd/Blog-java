package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.Languange;

public class LanguangeDao {
					private String sql;
					private int i=0;
					/*
					 * 增加语言日志
					 */
					public int AddLanuange(Languange languange)
					{
						try {
							sql="insert into languange(id,title,contenct,time,img,pro) values(?,?,?,?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, languange.getId());
							stmt.setString(2, languange.getTitle());
							stmt.setString(3, languange.getContenct());
							stmt.setString(4, languange.getTime());
							stmt.setString(5, languange.getImg());
							stmt.setString(6, languange.getPro());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除语言日志
					 */
					public int DeleteLanguange(Languange languange)
					{
						try {
							sql="delete from languange where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, languange.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改语言日志
					 */
					public int UpdateLanguange(Languange languange)
					{
						try {
							sql = "update languange set title=?,contenct=?,time=?,img=?,pro=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, languange.getTitle());
							stmt.setString(2, languange.getContenct());
							stmt.setString(3, languange.getTime());
							stmt.setString(4, languange.getImg());
							stmt.setString(5, languange.getPro());
							stmt.setString(6, languange.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找语言日志
					 */
					public ArrayList<Languange> SelectLanguange()
					{
						ArrayList<Languange> list = new ArrayList<Languange>();
						try {
							sql= "select * from languange";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							while(rs.next())
							{
								Languange languange = new Languange();
								languange.setId(rs.getString("id"));
								languange.setImg(rs.getString("img"));
								languange.setPro(rs.getString("pro"));
								languange.setContenct(rs.getString("contenct"));
								languange.setTime(rs.getString("time"));
								languange.setTitle(rs.getString("title"));
								list.add(i,languange);
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
