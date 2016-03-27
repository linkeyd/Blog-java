package Lin.blog.web.tool;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OutLogin extends HttpServlet {
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				boolean re = true;
				HttpSession session = req.getSession();
				session.removeAttribute("user");
				PrintWriter out =resp.getWriter();
				out.print(re);
				out.flush();
				out.close();
				super.doGet(req, resp);
			}
}
