package com.sambcode.app.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sambcode.app.ejb.EjbUser;
import com.sambcode.app.ejbinterface.IEjbUser;

/**
 * Servlet implementation class ServletUserLogin
 */
@WebServlet("/ServletUserLogin")
public class ServletUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbUser iEjbUser;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("user/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iEjbUser = new EjbUser();

		iEjbUser.getByEmail(request.getParameter("txtEmail"));

		Map<String, String> returnMap = iEjbUser.login(request.getParameter("passPassword"));

		request.setAttribute("correct", returnMap.get("correct"));
		request.setAttribute("generalMessage", returnMap.get("generalMessage"));

		if (returnMap.get("correct").equals("Yes")) {
			HttpSession httpSession = request.getSession();

			httpSession.setAttribute("idUser", request.getParameter("txtEmail"));
			httpSession.setAttribute("email", request.getParameter("txtEmail"));

			response.sendRedirect("/appwebschedule-0.0.1-SNAPSHOT/ServletUserEdit");
		} else {
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
		}

	}

}
