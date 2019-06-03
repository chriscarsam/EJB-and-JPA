package com.sambcode.app.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.ejb.EjbUser;
import com.sambcode.app.ejbinterface.IEjbUser;

/**
 * Servlet implementation class ServletUserInsert
 */
@WebServlet("/ServletUserInsert")
public class ServletUserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbUser iEjbUser;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUserInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("user/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			iEjbUser = new EjbUser();

			iEjbUser.getUser().setFirstName(request.getParameter("txtFirstName"));
			iEjbUser.getUser().setLastName(request.getParameter("txtLastName"));
			iEjbUser.getUser().setBirthdate(request.getParameter("dateBirthdate"));
			iEjbUser.getUser().setEmail(request.getParameter("txtEmail"));
			iEjbUser.getUser().setPassword(request.getParameter("passPassword"));
			iEjbUser.setPasswordRepeat(request.getParameter("passPasswordRepeat"));

			Map<String, String> returnMap = iEjbUser.insert();

			request.setAttribute("correct", returnMap.get("correct"));
			request.setAttribute("generalMessage", returnMap.get("generalMessage"));

			request.getRequestDispatcher("user/insert.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
