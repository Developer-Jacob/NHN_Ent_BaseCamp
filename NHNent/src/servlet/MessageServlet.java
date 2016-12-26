package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
// @WebServlet("/Message")
public class MessageServlet extends HttpServlet {
			private static final long serialVersionUID = 1L;

			/**
			 * @see HttpServlet#HttpServlet()
			 */
			public MessageServlet() {
						super();
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
			private boolean emailCheck(String userMail){
						boolean flag = false;
						return false;
//						return Pattern.matches("/^(\w+)@(\w+)[.](\w+)$/ig", userMail);
			}
			private void processRequest(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
						request.setCharacterEncoding("UTF-8");
						Connection conn = ConnectionProvider.getConnection();
						MessageDAO dao = MessageDAO.getInstance();
						String uri = request.getRequestURI();
						System.out.println(uri);
						// 등록 페이지를 위한 JSP 포워딩
						if (uri.indexOf("input.do") != -1) {
									RequestDispatcher requstDispatcher = request
															.getRequestDispatcher("/MessageInput.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						// 리스트 페이지를 위한 JSP 포워딩
						else if (uri.indexOf("list.do") != -1) {
									
									ArrayList<MessageDTO> msgList = dao.select_AllList(conn);
									request.setAttribute("list", msgList);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageList.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						// 등록 동작을 수행후 list페이지로 포워딩
						else if (uri.indexOf("insert.do") != -1) {
									String user = request.getParameter("user");
									if(emailCheck(user)){
												//여기다가 익셉션처리 해줘야됨
									}
									String password = request.getParameter("password");
									String title = request.getParameter("title");
									String contents = request.getParameter("content");
									MessageDTO msg = new MessageDTO(user, password, title, contents);
									dao.insert(conn, msg);
									response.sendRedirect("list.do");
									ConnectionProvider.close(conn);
						}
						// 내용 페이지를 위한 JSP 포워딩
						else if (uri.indexOf("content.do") != -1) {
									String msgId = request.getParameter("idx");
									try {
												MessageDTO msg = dao.select_ById(conn, Integer.parseInt(msgId));
												request.setAttribute("msg", msg);
												RequestDispatcher requstDispatcher = request
																		.getRequestDispatcher("/MessageContent.jsp");
												requstDispatcher.forward(request, response);
									} catch (NumberFormatException e) {
												e.printStackTrace();
									}
									ConnectionProvider.close(conn);
						} else if (uri.indexOf("modifyForm.do") != -1) {
									String msgId = request.getParameter("idx");
									MessageDTO msg = dao.select_ById(conn, Integer.parseInt(msgId));
									request.setAttribute("msg", msg);
									RequestDispatcher requstDispatcher = request
															.getRequestDispatcher("/MessageUpdate.jsp");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						} else if (uri.indexOf("update.do") != -1) {
									try {
												int idx = Integer.parseInt(request.getParameter("idx"));
												String title = request.getParameter("title");
												String content = request.getParameter("content");
												dao.update(conn, idx, title, content);
												MessageDTO msg = dao.select_ById(conn, idx);
												request.setAttribute("msg", msg);
												RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageContent.jsp");
												requstDispatcher.forward(request, response);
												ConnectionProvider.close(conn);
									} catch (NumberFormatException e) {
												e.printStackTrace();
									}
									ConnectionProvider.close(conn);
						} else if(uri.indexOf("delete.do")!=-1){
									int idx = Integer.parseInt(request.getParameter("idx"));
									dao.delete(conn, idx);
									RequestDispatcher requstDispatcher = request.getRequestDispatcher("list.do");
									requstDispatcher.forward(request, response);
									ConnectionProvider.close(conn);
						}
						else {

						}

			}

}
