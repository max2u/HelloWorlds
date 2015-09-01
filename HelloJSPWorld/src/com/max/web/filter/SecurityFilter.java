package com.max.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {
    public SecurityFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	String path = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length());
	if (path.equals("/login.jsp") || path.equals("/HelloJSP")) {
	    chain.doFilter(request, response); // Just continue chain.
	    return;
	} 
	Object user= ((HttpServletRequest) request).getSession().getAttribute("user");
	
	//not logged in, redirect to login page
	if ( user == null ){
	    ((HttpServletResponse)response).sendRedirect("login.jsp");
	}
	chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}


