package com.max.web.servlet;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * this is a servlet the is initilized by the file
 * <tt>WebContent/WEB-INF/web.xml</tt><br>
 * the file <tt>web.xml</tt> is loaded by the web container
 * (<strong>Tomcat</strong>) all classes that extends {@link HttpServlet} should
 * be specified in the <tt>web.xml</tt> <br>
 * <br>
 * jsp files are translated to a java class that
 * <code>extends HttpServlet</code>, and they don't require mapping the
 * <tt>web.xml</tt> as the container (<strong>Tomcat</strong>) automatically map
 * to a url with the name of the jsp page itself ( like
 * <strong>login.jsp</strong> and <strong>err.jsp</strong>
 * 
 * @author Sameer
 *
 */
public class HelloJSP extends HttpServlet {
    private static final long serialVersionUID = -7973880369742675062L;

    private Map<String, String> users = new ConcurrentHashMap<>();

    public HelloJSP() {
	users.put("sameer", "123");
    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// reading form data from request
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// validate username and password
	if (username == null || password == null
		|| !users.containsKey(username)
		|| !users.get(username).equals(password)) {
	    // forward to the error page
	    request.getRequestDispatcher("err.jsp").forward(request, response);
	    return;
	}

	// save the user in the session, this is needed to get the logged in
	// user at a later stage
	request.getSession().setAttribute("user", username);

	// redirect to home page
	response.sendRedirect("hello.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	doGet(req, resp);
    }
}