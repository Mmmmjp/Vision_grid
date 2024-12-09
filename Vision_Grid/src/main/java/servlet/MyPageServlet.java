package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.ElementBeans;
import model.ElementsFetchLogic;
import model.VisionBeans;
import model.VisionFetchLogic;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {//データ取得処理中に例外が発生した場合に500エラー
            HttpSession session = request.getSession();
            AccountBeans currentUser = (AccountBeans) session.getAttribute("loggedInUser");

            VisionFetchLogic visionFetchLogic = new VisionFetchLogic();
            VisionBeans vision = visionFetchLogic.getVisionByUserId(currentUser.getUserId());

            if (vision == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageNoSheet.jsp");
                dispatcher.forward(request, response);
            } else {
                session.setAttribute("vision", vision);

                // 要素の取得
                ElementsFetchLogic elementsFetchLogic = new ElementsFetchLogic();
                List<ElementBeans> elementsList = elementsFetchLogic.getElementsByVisionId(vision.getVisionId());
                session.setAttribute("elementsList", elementsList);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageWithSheet.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データ取得中にエラーが発生しました");
        }
    }
}
