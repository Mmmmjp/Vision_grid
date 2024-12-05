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
import model.LoginLogic;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//入力値の検証
	    if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
	        String errorMsg = "ユーザネームまたはパスワードが未入力です。";
	        request.setAttribute("errorMsg", errorMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }
		
	    //ログイン処理の実行
		AccountBeans authAccount = new AccountBeans(userName,password);
		LoginLogic loginLogic = new LoginLogic();
		AccountBeans loggedInUser= loginLogic.execute(authAccount);
		
		//アカウントが見つかった場合loginUserをセッションスコープに保存

		String errorMsg = "";
		
		if (loggedInUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser",loggedInUser);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			 errorMsg = "ユーザーネームまたはパスワードが正しくありません。";
		    request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);	
		}
	}
}