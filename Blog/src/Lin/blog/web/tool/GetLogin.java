package Lin.blog.web.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetLogin extends HttpServlet{
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			/*
			 * 获取用户登入数据
			 */
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				HttpSession session = req.getSession();
				PrintWriter out = resp.getWriter();
				out.print(session.getAttribute("user"));
				out.flush();
				out.close();
			}
}
