package com.sambcode.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.ejb.EjbActivity;
import com.sambcode.app.ejbinterface.IEjbActivity;

/**
 * Servlet implementation class ServletActivityChangeStatus
 */
@WebServlet("/ServletActivityChangeStatus")
public class ServletActivityChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbActivity iEjbActivity;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActivityChangeStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iEjbActivity = new EjbActivity();

		iEjbActivity.changeStatusActivity(Integer.parseInt(request.getParameter("idActivity")),
				Boolean.parseBoolean(request.getParameter("state")));

		String stateUrlQueru = request.getParameter("state").equals("true") ? "false" : "true";

		response.sendRedirect("/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGetByUserAndState?state=" + stateUrlQueru);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
