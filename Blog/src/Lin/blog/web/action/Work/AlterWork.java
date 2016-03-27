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
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

public class AlterWork extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		String id = req.getParameter("id");
		String url = req.getParameter("url");
		String img = req.getParameter("img");
		String title = req.getParameter("title");
		String contenct = req.getParameter("contenct");
		Work work = new Work();
		work.setId(id);;
		work.setContenct(contenct);
		work.setImg(img);
		work.setTitle(title);
		work.setUrl(url);
		WorkDao dao = new WorkDao();
		Judge judge = new Judge();
		boolean re = judge.judge(dao.UpdateWork(work));
		String result=null;
		if(re)
		{
			ArrayList<Work> list = new WorkDao().SelectWork();
			Gson gson = new Gson();
			result  = gson.toJson(list);
		}
		PrintWriter out = resp.getWriter();
		out.print(Unicore.chinaToUnicode(result));
		out.flush();
		out.close();
	}
		
}
