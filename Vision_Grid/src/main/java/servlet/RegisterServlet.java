package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		String userName = request.getParameter("userName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String dobString = request.getParameter("dob");
		String gender = request.getParameter("gender");
		
		
		// // エラーメッセージを格納する変数
        String errorMsg = "";
        
        LocalDate dob=null;
        // 入力チェック
        if (userName == null || userName.isEmpty()) {
            errorMsg = "ユーザー名を入力してください。";
        } else if (realName == null || realName.isEmpty()) {
            errorMsg = "名前を入力してください。";
        } else if (password == null || password.isEmpty()) {
            errorMsg = "パスワードを入力してください。";
        } else if (dobString == null || dobString.isEmpty()) {
            errorMsg = "生年月日を入力してください。";
        } else {
            try {
                // 生年月日をLocalDateに変換
            	dob = LocalDate.parse(dobString);
                // 過去の日付であることを確認
                if (dob.isAfter(LocalDate.now())) {
                    errorMsg = "生年月日には過去の日付を入力してください。";
                }
            } catch (DateTimeParseException e) {
                errorMsg = "生年月日は正しい形式で入力してください (例: 1990-01-01)。";
            }
        }

        if (gender == null || gender.isEmpty()) {
            errorMsg = "性別を選択してください。";
        }
        
        // エラーメッセージが設定されている場合
        if (!errorMsg.isEmpty()) {
            request.setAttribute("errorMsg", errorMsg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
            return;
        } else {//SessionスコープにpendingAccount情報を保存し、確認画面にフォワード
        	AccountBeans pendingAccount = new AccountBeans(userName,password,realName,dob,gender);
        	HttpSession session = request.getSession();
        	session.setAttribute("pendingAccount",pendingAccount);
        	
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
            dispatcher.forward(request, response);
        }    
	}
}
