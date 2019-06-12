package com.sambcode.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterSession
 */
@WebFilter("/FilterSession")
public class FilterSession implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterSession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);

		String urlRequest = httpServletRequest.getRequestURL().toString();

		HttpSession httpSession = httpServletRequest.getSession();

		if (!urlRequest.equals("http://127.0.0.1:8080/appwebschedule-0.0.1-SNAPSHOT/ServletUserLogin")
				&& httpSession.getAttribute("email") == null) {
			((HttpServletResponse) response).sendRedirect("/appwebschedule-0.0.1-SNAPSHOT/ServletUserLogin");
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
