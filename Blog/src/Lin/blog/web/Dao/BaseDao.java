package Lin.blog.web.Dao;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BaseDao {
	private static final String username = "root"; // 数据库账号
	private static final String password = "root"; // 数据库
	private static final String driver = "com.mysql.jdbc.Driver"; // 数据库驱动
	private static final String url = "jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
			//+ "user=" + username + "&password=" + password
			//+ "&useUnicode=true&characterEncoding=UTF8"; // 数据库连接地址
		Connection connection=null;
			
	static{
		try {
			//加载数据库驱动程序
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("驱动加载错误");
			System.out.println(e.getMessage());
		}
	}
	/*
	 * 连接数据库
	 */
	public Connection getConnection(){

		try {
			//数据库连接
			//connection = (Connection) DriverManager.getConnection(url);
			connection =DriverManager.getConnection(url, username, password);
			System.out.println("数据库打开成功");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return connection;
	}
	/*
	 * 关闭连接
	 */
	public void CloseAll(Connection connection,PreparedStatement preparedStatement,ResultSet result)
	{
		if(result!=null)
		{
			try {
				result.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		if(preparedStatement!=null)
		{
			try {
				preparedStatement.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		if(connection!=null)
		{
			try {
				System.out.println("数据库关闭成功");
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
}
