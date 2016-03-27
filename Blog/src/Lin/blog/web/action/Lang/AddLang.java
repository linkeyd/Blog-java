package Lin.blog.web.action.Lang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Lin.blog.web.Dao.LanguangeDao;
import Lin.blog.web.bean.Languange;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;

public class AddLang extends HttpServlet{

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
				Languange languange = new Languange();
				languange.setContenct(contenct);
				languange.setImg(img);
				languange.setTime(time);
				languange.setTitle(title);
				LanguangeDao dao = new LanguangeDao();
				Judge judge = new Judge();
				boolean re = judge.judge(dao.AddLanuange(languange));
				String result = null;
				if(re)
				{
					ArrayList<Languange> list= new LanguangeDao().SelectLanguange();
					Gson gson = new Gson();
					result =gson.toJson(list);
				}
				PrintWriter out = resp.getWriter();
				out.print(Unicore.chinaToUnicode(result));
				out.flush();
				out.close();
			}
}
