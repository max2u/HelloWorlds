 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class HelloJSP extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7973880369742675062L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        request.getSession().setAttribute("user", username);

        request.getRequestDispatcher("err.jsp").forward(request, response);
//        
//        out.println (
//                  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
//                      "http://www.w3.org/TR/html4/loose.dtd\">\n" +
//                  "<html> \n" +
//                    "<head> \n" +
//                    "</head> \n" +
//                    "<body> <div align='center'> \n" +
//                      "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
//                        "Username: " + username + " <br> " + 
//                        "Password: " + password +
//                    "</font></body> \n" +
//                  "</html>" 
//                );      
        }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}