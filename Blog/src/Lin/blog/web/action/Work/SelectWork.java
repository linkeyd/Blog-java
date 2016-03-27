package Lin.blog.web.action.Work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Lin.blog.web.Dao.WorkDao;
import Lin.blog.web.bean.Work;
import Lin.blog.web.tool.Unicore;

public class SelectWork extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		    resp.setContentType("text/html; charset=utf-8");
			ArrayList<Work> list = new WorkDao().SelectWork();
			Gson gson = new Gson();
			String result = gson.toJson(list);
			PrintWriter out = resp.getWriter();
			out.print(Unicore.chinaToUnicode(result));
			out.flush();
			out.close();
	}
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				doPost(req, resp);
			}
}
