package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.Work;

public class WorkDao {
					private String sql;
					private int i =0;
					/*
					 * 添加作品
					 */
					public int AddWork(Work work)
					{
						try {
							sql="insert into work(id,title,url,img,contenct) values(?,?,?,?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, work.getId());
							stmt.setString(2, work.getTitle());
							stmt.setString(3, work.getUrl());
							stmt.setString(4, work.getImg());
							stmt.setString(5, work.getContenct());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
						System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除作品
					 */
					public int DeleteWork(Work work)
					{
						try {
							sql = "delete from work where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, work.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改作品
					 */
					public int UpdateWork(Work work)
					{
						try {
							sql="update work set title=?,url=?,img=?,contenct=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con =dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, work.getTitle());
							stmt.setString(2, work.getUrl());
							stmt.setString(3, work.getImg());
							stmt.setString(4, work.getContenct());
							stmt.setString(5, work.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
						System.out.println(e);
						}
						return i;
					}
					
					/*
					 *  查找作品
					 */
					public ArrayList<Work> SelectWork()
					{
					ArrayList<Work> list = new ArrayList<Work>();
					try {
						sql="select * from work";
						BaseDao dao = new BaseDao();
						Connection con = dao.getConnection();
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
						ResultSet rs = stmt.executeQuery();
						while(rs.next())
						{
							Work work = new Work();
							work.setId(rs.getString("id"));
							work.setImg(rs.getString("img"));
							work.setTitle(rs.getString("title"));
							work.setUrl(rs.getString("url"));
							work.setContenct(rs.getString("contenct"));
							list.add(i,work);
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
