package Lin.blog.web.action.User;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Lin.blog.web.Dao.UserDao;
import Lin.blog.web.bean.User;

public class Login extends HttpServlet{
					/**
					 * 执行登陆
					 */
	private static final long serialVersionUID = 1L;

					@Override
					protected void doPost(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {
						// TODO Auto-generated method stub
						doGet(req, resp);
					}
					@Override
					protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
					// TODO Auto-generated method stub
						User user = new User();
						HttpSession session = req.getSession();
						String username=req.getParameter("username");
						String password = req.getParameter("password");
						
						user.setUsername(username);
						user.setPassword(password);
						boolean re = new UserDao().Login(user);
						PrintWriter out = resp.getWriter();
						Gson gson = new Gson();
						if(re)
						{
						String result = gson.toJson(user);
						session.setAttribute("user", result);
						}
						out.print(re);
						out.flush();
						out.close();
					}
}
		
