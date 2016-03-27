package Lin.blog.web.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Lin.blog.web.bean.Carousel;

public class CarouselDao {
					private String sql;
					private int i = 0;
					
					/*
					 * 添加轮播图片
					 */
					public  int AddCarousel(Carousel carousel)
					{
						try {
							sql = "insert into carousel(id,img) values(?,?)";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, carousel.getId());
							stmt.setString(2, carousel.getImg());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 删除轮播图片
					 */
					public int DeleteCarousel(Carousel carousel)
					{
						try {
							sql = "delete from carousel where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, carousel.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 修改轮播图片
					 */
					public int UpdateCarousel(Carousel carousel)
					{
						try {
							sql = "update carousel set img=? where id=?";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							stmt.setString(1, carousel.getImg());
							stmt.setString(2, carousel.getId());
							i = stmt.executeUpdate();
							dao.CloseAll(con, stmt, null);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						return i;
					}
					
					/*
					 * 查找所有轮播图片
					 */
					public ArrayList<Carousel> SelectCarousel()
					{
						ArrayList<Carousel> list = new ArrayList<Carousel>();
						try {
							sql = "select * from carousel";
							BaseDao dao = new BaseDao();
							Connection con = dao.getConnection();
							PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							while(rs.next())
							{
								Carousel carousel = new Carousel();
								carousel.setId(rs.getString("id"));
								carousel.setImg(rs.getString("img"));
								list.add(i,carousel);
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
