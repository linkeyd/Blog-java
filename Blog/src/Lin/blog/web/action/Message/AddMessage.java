package Lin.blog.web.action.Message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lin.blog.web.Dao.MyMessageDao;
import Lin.blog.web.bean.MyMessage;
import Lin.blog.web.tool.Judge;

public class AddMessage extends HttpServlet{
					/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

					@Override
					protected void doPost(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {
						// TODO Auto-generated method stub
						String name = req.getParameter("name");
						String phone = req.getParameter("phone");
						String email = req.getParameter("email");
						String message = req.getParameter("message");
						MyMessage myMessage =new MyMessage();
						myMessage.setName(name);
						myMessage.setEmail(email);
						myMessage.setPhone(phone);
						myMessage.setMessage(message);
						MyMessageDao dao = new MyMessageDao();
						Judge judge = new Judge();
						boolean re =judge.judge(dao.AddMyMessage(myMessage));
						PrintWriter out = resp.getWriter();
						out.print(re);
						out.flush();
						out.close();
					}
}
