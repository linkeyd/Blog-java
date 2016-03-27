package Lin.blog.web.action.Rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Lin.blog.web.Dao.RestDao;
import Lin.blog.web.bean.Rest;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

import com.google.gson.Gson;

public class AddRest extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				String img = req.getParameter("img");
				String title = req.getParameter("title");
				String time =req.getParameter("time");
				String contenct = req.getParameter("contenct");
				Rest rest = new Rest();
				rest.setContenct(contenct);
				rest.setImg(img);
				rest.setTime(time);
				rest.setTitle(title);
				RestDao dao = new RestDao();
				Judge judge = new Judge();
				boolean re = judge.judge(dao.AddRest(rest));
				String result = null;
				if(re)
				{
					ArrayList<Rest>  list = new RestDao().SelectRest();
					Gson gson = new Gson();
					result =gson.toJson(list);
				}
				PrintWriter out = resp.getWriter();
				out.print(Unicore.chinaToUnicode(result));
				out.flush();
				out.close();
			}
}
