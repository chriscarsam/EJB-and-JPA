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

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("correct") != null) {
			request.setAttribute("correct", httpSession.getAttribute("correct"));
			request.setAttribute("generalMessage", httpSession.getAttribute("generalMessage"));

			httpSession.removeAttribute("correct");
			httpSession.removeAttribute("generalMessafe");
		}

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

		iEjbUser.setOldEmail(iEjbUser.getUser().getEmail());

		iEjbUser.getUser().setFirstName(request.getParameter("txtFirstName"));
		iEjbUser.getUser().setLastName(request.getParameter("txtLastName"));
		iEjbUser.getUser().setBirthdate(request.getParameter("dateBirthdate"));
		iEjbUser.getUser().setEmail(request.getParameter("txtEmail"));

		iEjbUser.setOldPassword("");

		if (request.getParameter("radioChangePassword").equals("Yes")) {
			iEjbUser.setOldPassword(request.getParameter("passOldPassword"));
			iEjbUser.setNewPassword(request.getParameter("passNewPassword"));
			iEjbUser.setPasswordRepeat(request.getParameter("passRepeatNewPassword"));
		}

		Map<String, String> returnMap = iEjbUser.update();

		HttpSession httpSession = request.getSession();

		httpSession.setAttribute("correct", returnMap.get("correct"));
		httpSession.setAttribute("generalMessage", returnMap.get("generalMessage"));

		response.sendRedirect("/appwebschedule-0.0.1-SNAPSHOT/ServletUserEdit");
	}

}
