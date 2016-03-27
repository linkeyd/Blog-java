package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.Blog;

public class BlogDao {
			private String sql="";
			private int i = 0;
			
			/*
			 * 添加日志
			 */
			public int AddBlog(Blog blog) 
			{
					
					try {
						sql="insert into blog(id,title,time,contenct,img) values (?,?,?,?,?)";
						BaseDao dao=new BaseDao();
						Connection con = dao.getConnection();
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
						stmt.setString(1, blog.getId());
						stmt.setString(2, blog.getTitle());
						stmt.setString(3, blog.getTime());
						stmt.setString(4, blog.getContenct());
						stmt.setString(5, blog.getImg());
						i = stmt.executeUpdate();
						dao.CloseAll(con, stmt, null);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}
					return i;
			}
			
			/*
			 * 删除日志
			 */
			public int DeleteBlog(Blog blog)
			{
				try {
					sql="delete from blog where id=?";
					BaseDao dao = new BaseDao();
					Connection con = dao.getConnection();
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					stmt.setString(1, blog.getId());
					i = stmt.executeUpdate();
					dao.CloseAll(con, stmt, null);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				return i;
			}
			
			/*
			 * 修改日志
			 */
			public int UpdateBlog(Blog blog)
			{
				try {
					sql="update Blog set title=?,contenct=?,img=? where id=?";
					BaseDao dao = new BaseDao();
					Connection con = dao.getConnection();
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					stmt.setString(1, blog.getTitle());
					stmt.setString(2, blog.getContenct());
					stmt.setString(3, blog.getImg());
					stmt.setString(4, blog.getId());
					i = stmt.executeUpdate();
					dao.CloseAll(con, stmt, null);
				} catch (Exception e) {
					System.out.println(e);
					// TODO: handle exception
				}
				return i;
			}
			
			/*
			 * 查找所有日志
			 */
			public ArrayList<Blog> SelectBlog()
			{
				ArrayList<Blog> list =new ArrayList<Blog>();
				try {
					sql="select * from blog";//林晓明
					BaseDao dao = new BaseDao();
					Connection con = dao.getConnection();
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())
					{
						Blog blog = new Blog();
						blog.setId(rs.getString("id"));
						blog.setContenct(rs.getString("contenct"));
						blog.setImg(rs.getString("img"));
						blog.setTime(rs.getString("time"));
						blog.setTitle(rs.getString("title"));
						list.add(i,blog);
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
