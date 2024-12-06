package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.RegisterLogic;

@WebServlet("/RegCompleteServlet")
public class RegCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // セッションスコープからアカウント情報を取得
        HttpSession session = request.getSession();
        AccountBeans pendingAccount = (AccountBeans) session.getAttribute("pendingAccount");

        if (pendingAccount == null) {
            // セッションスコープにアカウント情報が存在しない場合
            request.setAttribute("errorMsg", "セッションが切れました。もう一度やり直してください。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // 登録処理
        RegisterLogic registerLogic = new RegisterLogic();
        String errorMsg = null;

        try {
            registerLogic.execute(pendingAccount);

            session.removeAttribute("pendingAccount");

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
            dispatcher.forward(request, response);

        } catch (IllegalArgumentException e) {
            // ユーザー名の重複エラー
            request.setAttribute("errorMsg", e.getMessage());
            session.removeAttribute("pendingAccount");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            // その他のSQLエラー
            request.setAttribute("errorMsg", "データベースエラーが発生しました。管理者にお問い合わせください。");
            session.removeAttribute("pendingAccount");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
            dispatcher.forward(request, response);
        }
    }
}
