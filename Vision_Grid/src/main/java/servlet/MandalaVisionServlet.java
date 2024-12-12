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
import model.VisionSetLogic;


@WebServlet("/MandalaVisionServlet")
public class MandalaVisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaVision.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//userIdの取得のためユーザ情報の取得
		HttpSession session = request.getSession();
		AccountBeans currentUser = (AccountBeans)session.getAttribute("loggedInUser");
		
		String visionKey = request.getParameter("vision");
		String visionText = request.getParameter("text");
	
		//VisionBeansインスタンス生成しセッションスコープに保存
		VisionBeans vision =  new VisionBeans(currentUser.getUserId(),visionKey,visionText);
		
		// VisionSetLogicを使用してデータベースに保存
		VisionSetLogic visionSetLogic = new VisionSetLogic();
		int visionId = visionSetLogic.execute(vision); // visionIdを取得
		
		if (visionId > 0) {
            // データ保存が成功した場合、visionIdをセッションスコープに保存
            vision.setVisionId(visionId);
            session.setAttribute("vision", vision);

            // 次のページにフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElements.jsp");
            dispatcher.forward(request, response);
        } else {
            // 保存失敗時
            response.sendRedirect("MyPageServlet");
        }
    }
}