package Lin.blog.web.action.Carousel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Lin.blog.web.Dao.CarouselDao;
import Lin.blog.web.bean.Carousel;
import Lin.blog.web.tool.Unicore;

public class SelectCarousel extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		ArrayList<Carousel> list= new CarouselDao().SelectCarousel();
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
