package Lin.blog.web.action.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Lin.blog.web.Dao.UserDao;
import Lin.blog.web.bean.User;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

public class AlterUser extends HttpServlet{
					/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

					@Override
					protected void doPost(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {
						// TODO Auto-generated method stub
						String id = req.getParameter("id");
						String username = req.getParameter("username");
						String password =req.getParameter("password");
						User user =new User();
						user.setId(id);
						user.setUsername(username);
						user.setPassword(password);
						UserDao dao = new UserDao();
						Judge judge = new Judge();
						boolean re = judge.judge(dao.UpdateUser(user));
						String result = null;
						ArrayList<User> list=new UserDao().SelectUser();
						Gson gson = new Gson();
						if(re==true)
						{
							result = gson.toJson(list);
						}

						PrintWriter out = resp.getWriter();
						out.print(Unicore.chinaToUnicode(result));
						out.flush();
						out.close();
					}
}
