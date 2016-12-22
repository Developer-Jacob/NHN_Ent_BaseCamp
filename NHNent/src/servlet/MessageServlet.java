package servlet;

import java.io.IOException;
import java.sql.Connection;
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
						System.out.println("Input Do Get");
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request,
			 *      HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						processRequest(request, response);
						System.out.println("Input Do Post");
			}

			private void processRequest(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						request.setCharacterEncoding("UTF-8");
						Connection conn = ConnectionProvider.getConnection();
						MessageDAO dao = MessageDAO.getInstance();
						String uri = request.getRequestURI();
						System.out.println(uri);
						if(uri.indexOf("input.do")!=-1){
									System.out.println("input.do");
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageInput.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}else if(uri.indexOf("list.do")!=-1){
									System.out.println("list.do");
									ArrayList<MessageDTO> msgList = dao.select_AllList(conn);
									request.setAttribute("list", msgList);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageList.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}else if(uri.indexOf("complete.do")!=-1){
									String user = request.getParameter("user");
									String password = request.getParameter("password");
									String title = request.getParameter("title");
									String contents = request.getParameter("contents");
									MessageDTO msg = new MessageDTO(user, password, title, contents);
									dao.insert(conn, msg);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageList.jsp");
									requstDispatcher.forward(request, response);
						}
						else{
									
									
						}
						
			}

}
