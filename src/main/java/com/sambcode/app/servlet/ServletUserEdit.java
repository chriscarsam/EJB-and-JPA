package com.sambcode.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.ejb.EjbUser;
import com.sambcode.app.ejbinterface.IEjbUser;

/**
 * Servlet implementation class ServletUserEdit
 */
@WebServlet("/ServletUserEdit")
public class ServletUserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbUser iEjbUser;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUserEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iEjbUser = new EjbUser();

		request.setAttribute("user", iEjbUser.getByIdUser());

		request.getRequestDispatcher("user/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iEjbUser = new EjbUser();

		iEjbUser.getByIdUser();

		iEjbUser.getUser().setFirstName(request.getParameter("txtFirstName"));
		iEjbUser.getUser().setLastName(request.getParameter("txtLastName"));
		iEjbUser.getUser().setBirthdate(request.getParameter("dateBirthdate"));
		iEjbUser.getUser().setEmail(request.getParameter("txtEmail"));

		iEjbUser.update();

		response.sendRedirect("/appwebschedule-0.0.1-SNAPSHOT/ServletUserEdit");
	}

}
