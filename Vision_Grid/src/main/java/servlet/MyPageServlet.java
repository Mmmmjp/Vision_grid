package servlet;

import java.io.IOException;
import java.util.List;
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

        try {
            HttpSession session = request.getSession();
            AccountBeans currentUser = (AccountBeans) session.getAttribute("loggedInUser");

            // VISIONの確認
            VisionFetchLogic visionFetchLogic = new VisionFetchLogic();
            VisionBeans vision = visionFetchLogic.getVisionByUserId(currentUser.getUserId());

            if (vision == null) {
                // 目標シートがない場合
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageNoSheet.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // VISIONをセッションに保存
            session.setAttribute("vision", vision);

            // ELEMENTSの確認
            ElementsFetchLogic elementsFetchLogic = new ElementsFetchLogic();
            List<ElementBeans> elementsList = elementsFetchLogic.getElementsByVisionId(vision.getVisionId());
            session.setAttribute("elementsList", elementsList);

            if (elementsList.isEmpty() || elementsList.size() < 8) {
                // 要素が不足している場合
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElements.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // ACTIONSの確認
            ActionsFetchLogic actionsFetchLogic = new ActionsFetchLogic();
            List<Integer> elementIdsList = elementsList.stream()
                .map(ElementBeans::getElementId)
                .collect(Collectors.toList());

            List<ActionBeans> actionsList = actionsFetchLogic.getActionsByElementIds(elementIdsList);
            session.setAttribute("actionsList", actionsList);

            // 要素のキーリストを作成
            List<String> elementKeysList = elementsList.stream()
                .map(ElementBeans::getElementKey)
                .collect(Collectors.toList());

            // 各要素に対応するアクションを確認
            for (int i = 0; i < elementsList.size(); i++) {
                int elementId = elementsList.get(i).getElementId();
                List<ActionBeans> actionsForElement = actionsList.stream()
                    .filter(action -> action.getElementId() == elementId)
                    .collect(Collectors.toList());

                if (actionsForElement.isEmpty() || actionsForElement.size() < 8) {
                    // アクションが不足している場合、セッションスコープに必要なデータを保存
                    session.setAttribute("elementIdsList", elementIdsList);
                    session.setAttribute("elementKeysList", elementKeysList);

                    String redirectPage = "WEB-INF/jsp/mandalaElement_" + (i + 1) + ".jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage);
                    dispatcher.forward(request, response);
                    return;
                }
            }

            // データが揃っている場合、マイページへ
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPageWithSheet.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データ取得中にエラーが発生しました");
        }
    }
}
