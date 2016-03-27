package Lin.blog.web.action.History;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lin.blog.web.Dao.HistoryDao;
import Lin.blog.web.bean.History;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

import com.google.gson.Gson;

public class AlterHistory  extends HttpServlet{

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
	String img = req.getParameter("img");
	String title = req.getParameter("title");
	String time = req.getParameter("time");
	String contenct = req.getParameter("contenct");	
	History history = new History();
	history.setId(id);
	history.setContenct(contenct);
	history.setTitle(title);
	history.setImg(img);
	history.setTime(time);
	HistoryDao dao = new HistoryDao();
	Judge judge = new Judge();
	boolean re = judge.judge(dao.UpdateHistory(history));
	String result =null;
	if(re)
	{
		ArrayList<History>  list = new HistoryDao().SelectHistory();
		Gson gson = new Gson();
		result = gson.toJson(list);
	}
	PrintWriter out =resp.getWriter();
	out.print(Unicore.chinaToUnicode(result));
	out.flush();
	out.close();
}
}
