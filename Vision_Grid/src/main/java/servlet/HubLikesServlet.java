package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.HubLikesLogic;
import model.PostLikesBeans;

@WebServlet("/HubLikesServlet")
public class HubLikesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // パラメータの取得
        String postIdStr = request.getParameter("postId");

        // ログインユーザーの情報取得
        HttpSession session = request.getSession(false); // 既存セッションのみ取得
        if (session == null) {
            response.sendRedirect("LoginServlet");
            return;
        }

        AccountBeans currentUser = (AccountBeans) session.getAttribute("loggedInUser");
        if (currentUser == null) {
            response.sendRedirect("LoginServlet");
            return;
        }

        // パラメータ検証といいね処理
        try {
            int postId = Integer.parseInt(postIdStr);
            int userId = currentUser.getUserId(); // AccountBeansからuserIdを取得

            // いいねデータを作成
            PostLikesBeans like = new PostLikesBeans(postId, userId);

            // いいね処理を実行
            HubLikesLogic hubLikesLogic = new HubLikesLogic();
            boolean isSuccess = hubLikesLogic.addLike(like);

            if (isSuccess) {
                // 成功時は元のページにリダイレクト
                response.sendRedirect("HubPostMainServlet");
            } else {
                // 重複いいねの場合や失敗時も元のページにリダイレクト
                request.setAttribute("errorMsg", "すでにいいね済み、または処理に失敗しました。");
                response.sendRedirect("HubPostMainServlet");
            }

        } catch (NumberFormatException e) {
            // postIdの形式が不正な場合
            e.printStackTrace();
            request.setAttribute("errorMsg", "投稿IDが不正です。");
            response.sendRedirect("HubPostMainServlet");
        }
    }
}
