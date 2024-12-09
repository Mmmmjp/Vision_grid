package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.VisionBeans;
import model.VisionFetchLogic;


@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AccountBeans currentUser = (AccountBeans)session.getAttribute("loggedInUser");
		
		VisionFetchLogic visionFetchLogic = new VisionFetchLogic();
		VisionBeans vision = visionFetchLogic.getVisionByUserId(currentUser.getUserId());
		
		if (vision == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageNoSheet.jsp");
			dispatcher.forward(request, response);
		
		} else {
			session.setAttribute("vision", vision);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageWithSheet.jsp");
		    dispatcher.forward(request, response);
		}
		
	}
}
