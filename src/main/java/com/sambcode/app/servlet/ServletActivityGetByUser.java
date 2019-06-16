package com.sambcode.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.ejb.EjbActivity;
import com.sambcode.app.ejbinterface.IEjbActivity;
import com.sambcode.app.entity.Tactivity;
import com.sambcode.app.jb.JbActivity;

/**
 * Servlet implementation class ServletActivityGetByUser
 */
@WebServlet("/ServletActivityGetByUser")
public class ServletActivityGetByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbActivity iEjbActivity;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActivityGetByUser() {
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

		iEjbActivity.getByIdUser(Integer.parseInt(request.getSession().getAttribute("idUser").toString()));

		List<JbActivity> listJbActivity = new ArrayList<JbActivity>();

		for (Tactivity item : iEjbActivity.getListActivity()) {
			JbActivity jbActivity = new JbActivity();

			jbActivity.setIdActivity(item.getIdActivity());
			jbActivity.setFirstName(item.getFirstName());
			jbActivity.setDescription(item.getDescription());
			jbActivity.setState(item.getState());
			jbActivity.setDateStartTime(item.getDateStartTime());
			jbActivity.setEndTimeDate(item.getEndTimeDate());
			jbActivity.setRegistrationDate(item.getRegistrationDate());
			jbActivity.setPlace(item.getPlace());

			listJbActivity.add(jbActivity);
		}

		request.setAttribute("listActivity", listJbActivity);

		request.getRequestDispatcher("activity/watch.jsp").forward(request, response);

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
