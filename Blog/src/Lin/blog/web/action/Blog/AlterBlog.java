package Lin.blog.web.action.Blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lin.blog.web.Dao.BlogDao;
import Lin.blog.web.bean.Blog;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

import com.google.gson.Gson;

public class AlterBlog extends HttpServlet{

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
	Blog blog = new Blog();
	blog.setId(id);
	blog.setContenct(contenct);
	blog.setImg(img);
	blog.setTitle(title);
	blog.setTime(time);
	BlogDao dao  = new BlogDao();
	Judge judge = new Judge();
	boolean re = judge.judge(dao.UpdateBlog(blog));
	String result =null;
	if(re)
	{
		ArrayList<Blog>  list = new BlogDao().SelectBlog();
		Gson gson = new Gson();
		result = gson.toJson(list);
	}
	PrintWriter out =resp.getWriter();
	out.print(Unicore.chinaToUnicode(result));
	out.flush();
	out.close();
}
}
