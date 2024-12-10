package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.ActionBeans;
import model.ActionsFetchLogic;
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

            //VISIONの取得
            VisionFetchLogic visionFetchLogic = new VisionFetchLogic();
            VisionBeans vision = visionFetchLogic.getVisionByUserId(currentUser.getUserId());

            if (vision == null) {//まだ目標シートがない場合
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageNoSheet.jsp");
                dispatcher.forward(request, response);
            } else {
                session.setAttribute("vision", vision);

                // 要素の取得
                ElementsFetchLogic elementsFetchLogic = new ElementsFetchLogic();
                List<ElementBeans> elementsList = elementsFetchLogic.getElementsByVisionId(vision.getVisionId());
                session.setAttribute("elementsList", elementsList);
                
                // 要素IDリストの作成
                List<Integer> elementIdsList = elementsList.stream()
                    .map(ElementBeans::getElementId)
                    .collect(Collectors.toList());
                
                //アクションの取得
                ActionsFetchLogic actionsFetchLogic = new ActionsFetchLogic();
                List<ActionBeans> actionsList = 
                		actionsFetchLogic.getActionsByElementIds(elementIdsList);
                
                // 要素ごとにアクションリストを分ける
                Map<String, List<ActionBeans>> actionsByElement = new HashMap<>();
                for (ElementBeans element : elementsList) {
                    String position = element.getPosition(); // よりわかりやすく名前を変更
                    List<ActionBeans> relatedActions = actionsList.stream()
                        .filter(action -> action.getElementId() == element.getElementId())
                        .collect(Collectors.toList());
                    actionsByElement.put(position, relatedActions);
                }

                // セッションスコープに格納
                session.setAttribute("actionsByElement", actionsByElement);
                

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageWithSheet.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データ取得中にエラーが発生しました");
        }
    }
}
