package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ConnectionProvider;
import db.MessageDAO;
import model.MessageDTO;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/Message")
public class MessageServlet extends HttpServlet {
			private static final long serialVersionUID = 1L;

			/**
			 * @see HttpServlet#HttpServlet()
			 */
			public MessageServlet() {
						super();
						// TODO Auto-generated constructor stub
			}

			/**
			 * @see HttpServlet#doGet(HttpServletRequest request,
			 *      HttpServletResponse response)
			 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						processRequest(request, response);
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request,
			 *      HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						processRequest(request, response);
			}

			private void processRequest(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						request.setCharacterEncoding("UTF-8");
						Connection conn = ConnectionProvider.getConnection();
						MessageDAO dao = MessageDAO.getInstance();
						String uri = request.getRequestURI();
						System.out.println(uri);
						//등록 페이지를 위한 JSP 포워딩
						if(uri.indexOf("input.do")!=-1){
									System.out.println("input.do");
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageInput.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						//리스트 페이지를 위한 JSP 포워딩
						else if(uri.indexOf("list.do")!=-1){
									System.out.println("list.do");
									ArrayList<MessageDTO> msgList = dao.select_AllList(conn);
									request.setAttribute("list", msgList);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageList.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						//등록 동작을 수행후 list페이지로 포워딩
						else if(uri.indexOf("insert.do")!=-1){
									String user = request.getParameter("user");
									String password = request.getParameter("password");
									String title = request.getParameter("title");
									String contents = request.getParameter("contents");
									MessageDTO msg = new MessageDTO(user, password, title, contents);
									dao.insert(conn, msg);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("list.do");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						//내용 페이지를 위한 JSP 포워딩
						else if(uri.indexOf("content.do")!=-1){
									String msgId = request.getParameter("id");
									try {
												MessageDTO msg = dao.select_ById(conn,Integer.parseInt(msgId));
												request.setAttribute("msg", msg);
												RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageContent.jsp");
												requstDispatcher.forward(request, response);
									} catch (NumberFormatException e) {
												e.printStackTrace();
									} 
									ConnectionProvider.close(conn);
						}
						else{
									
									
						}
						
			}

}
