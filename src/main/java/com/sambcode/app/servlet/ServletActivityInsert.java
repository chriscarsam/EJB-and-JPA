package com.sambcode.app.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sambcode.app.ejb.EjbActivity;
import com.sambcode.app.ejbinterface.IEjbActivity;

/**
 * Servlet implementation class ServletActivityInsert
 */
@WebServlet("/ServletActivityInsert")
public class ServletActivityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbActivity iEjbActivity;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActivityInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("activity/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession httpSession = request.getSession();

			iEjbActivity = new EjbActivity();

			iEjbActivity.getActivity().getTuser()
					.setIdUser(Integer.parseInt(httpSession.getAttribute("idUser").toString()));

			iEjbActivity.getActivity().setFirstName(request.getParameter("txtFirstName"));
			iEjbActivity.getActivity().setDescription(request.getParameter("txtDescription"));
			iEjbActivity.getActivity().setPlace(request.getParameter("txtPlace"));

			String dateHourStart = request.getParameter("dateStartDate") + " " + request.getParameter("selectHourStart")
					+ ":" + request.getParameter("selectMinuteStart");
			iEjbActivity.getActivity().setDateStartTime(dateHourStart);

			String dateHourEnd = request.getParameter("dateFinishDate") + " " + request.getParameter("selectHourEnd")
					+ ":" + request.getParameter("selectMinuteEnd");
			iEjbActivity.getActivity().setEndTimeDate(dateHourEnd);

			Map<String, String> returnMap = iEjbActivity.insert();

			request.setAttribute("correct", returnMap.get("correct"));
			request.setAttribute("generalMessage", returnMap.get("generalMessage"));

			request.getRequestDispatcher("activity/insert.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}

}
