package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MuttersFetchLogic;
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
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
