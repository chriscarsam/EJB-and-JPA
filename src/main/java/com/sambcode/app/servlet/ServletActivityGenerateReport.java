package com.sambcode.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambcode.app.ejb.EjbActivity;
import com.sambcode.app.ejbinterface.IEjbActivity;
import com.sambcode.app.entity.Tactivity;
import com.sambcode.app.jb.JbActivity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Servlet implementation class ServletActivityGenerateReport
 */
@WebServlet("/ServletActivityGenerateReport")
public class ServletActivityGenerateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEjbActivity iEjbActivity;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActivityGenerateReport() {
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

		byte[] bytes;

		try {
			bytes = JasperRunManager.runReportToPdf(
					this.getServletContext()
							.getRealPath("/WEB-INF/classes/com/sambcode/app/report/ReportActivity.jasper"),
					null, new JRBeanCollectionDataSource(listJbActivity));
			response.setContentType("application/pdf");
			response.setContentLengthLong(bytes.length);
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();

		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
