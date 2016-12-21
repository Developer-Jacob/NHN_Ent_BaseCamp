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
@WebServlet("/Message")
public class Servlet extends HttpServlet {
			private static final long serialVersionUID = 1L;

			/**
			 * @see HttpServlet#HttpServlet()
			 */
			public Servlet() {
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
						String type = request.getParameter("type");
						request.setCharacterEncoding("UTF-8");
						Connection conn = ConnectionProvider.getConnection();
						MessageDAO dao = MessageDAO.getInstance();
						String uri = request.getRequestURI();
						ArrayList<MessageDTO> msgList = dao.select_AllList(conn);
						request.setAttribute("list", msgList);
						RequestDispatcher requstDispatcher = request.getRequestDispatcher("/MessageListForm.jsp");
						requstDispatcher.forward(request, response);
						ConnectionProvider.close(conn);
			}

}
