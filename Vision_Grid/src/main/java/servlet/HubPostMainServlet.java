package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.MuttersFetchLogic;
import model.MuttersSetLogic;
import model.PostMutterBeans;


@WebServlet("/HubPostMainServlet")
public class HubPostMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// つぶやきリストを取得
        MuttersFetchLogic getMutterListLogic = new MuttersFetchLogic();
        List<PostMutterBeans> mutterList = getMutterListLogic.getAllMutters();

//        // いいね数を取得して設定
//        LikesLogic likesLogic = new LikesLogic();
//        for (MutterBeans mutter : mutterList) {
//            int likeCount = likesLogic.getLikeCount(mutter.getMutterId());
//            mutter.setLikeCount(likeCount);
//        }

        // リクエストスコープに保存
        request.setAttribute("mutterList", mutterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/hubPostMain.jsp");
        dispatcher.forward(request, response);
    }
		

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // リクエストパラメータの取得
	    String postText = request.getParameter("text");

	    // 入力チェック
	    if (postText == null || postText.trim().isEmpty()) {
	        // エラーメッセージをセッションスコープに保存
	        HttpSession session = request.getSession();
	        session.setAttribute("errorMsg", "投稿内容を入力してください。");

	        // リダイレクトでエラーメッセージを保持
	        response.sendRedirect("HubPostMainServlet");
	        return;
	    }

	    // ログインユーザの情報取得
	    HttpSession session = request.getSession(false);
	    if (session == null) {
	        response.sendRedirect("LoginServlet");
	        return;
	    }

	    AccountBeans currentUser = (AccountBeans) session.getAttribute("loggedInUser");
	    if (currentUser == null) {
	        response.sendRedirect("LoginServlet");
	        return;
	    }

	    // 投稿データの作成
	    PostMutterBeans mutter = new PostMutterBeans();
	    mutter.setUserId(currentUser.getUserId());
	    mutter.setPostDate(new Timestamp(System.currentTimeMillis()));
	    mutter.setPostText(postText);

	    // ロジッククラスを使用して投稿を保存
	    MuttersSetLogic logic = new MuttersSetLogic();
	    boolean isSuccess = logic.execute(mutter);

	    // 投稿処理の結果に基づきリダイレクト
	    if (isSuccess) {
	        response.sendRedirect("HubPostMainServlet"); // 投稿成功時
	    } else {
	        session.setAttribute("errorMsg", "投稿に失敗しました。再度お試しください。");
	        response.sendRedirect("HubPostMainServlet"); // 投稿失敗時
	    }
	}
	
}
