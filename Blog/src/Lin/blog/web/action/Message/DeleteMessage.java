package Lin.blog.web.action.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Lin.blog.web.Dao.MyMessageDao;
import Lin.blog.web.bean.MyMessage;
import Lin.blog.web.tool.Judge;
import Lin.blog.web.tool.Unicore;


public class DeleteMessage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		MyMessage message= new MyMessage();
		message.setId(id);
		MyMessageDao dao = new MyMessageDao();
		Judge judge = new Judge();
		boolean re = judge.judge(dao.DeleteMyMessage(message));
		String result =null;
		if(re)
		{
			ArrayList<MyMessage> list = new MyMessageDao().SelectMyMessage();
			Gson gson = new Gson();
			result = gson.toJson(list);
		}
		PrintWriter out = resp.getWriter();
		out.print(Unicore.chinaToUnicode(result));
		out.flush();
		out.close();
	}
		
}
