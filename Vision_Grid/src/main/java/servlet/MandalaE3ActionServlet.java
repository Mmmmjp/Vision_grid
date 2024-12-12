package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ActionBeans;
import model.ActionsSetLogic;

@WebServlet("/MandalaE3ActionServlet")
public class MandalaE3ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // セッションから要素IDリストを取得
        List<Integer> elementIdsList = (List<Integer>) session.getAttribute("elementIdsList");

        // DAOに渡すためのリストを準備
        List<ActionBeans> e3ActionsList = new ArrayList<>();

        // JSPからアクションのキーとテキストを取得し、ActionBeansインスタンスを作成
        String[] positions = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String position : positions) {
            String actionKey = request.getParameter("e3" + position + "Key");
            String actionText = request.getParameter("e3" + position + "Text");

            // アクションキーが有効かどうかを確認
            if (actionKey != null && !actionKey.isEmpty()) {
                String fullPosition = "e3_" + position;
                // actionTextがnullまたは空の場合も許容
                ActionBeans action = new ActionBeans(
                        elementIdsList.get(2), 
                        fullPosition, 
                        actionKey, 
                        actionText != null ? actionText : ""
                );
                e3ActionsList.add(action);
            }
        }

        // アクションリストが空の場合、エラーメッセージを設定して元のページに戻る
        if (e3ActionsList.isEmpty()) {
            request.setAttribute("errorMessage", "E3に対するアクションが入力されていません。");
            forwardToPage(request, response, "WEB-INF/jsp/mandalaElement_3.jsp");
            return;
        }

        // アクションをデータベースに保存
        ActionsSetLogic actionsSetLogic = new ActionsSetLogic();
        if (!actionsSetLogic.execute(e3ActionsList)) {
            // 保存が失敗した場合
            request.setAttribute("errorMessage", "データベース保存中にエラーが発生しました。");
            forwardToPage(request, response, "WEB-INF/jsp/mandalaElement_3.jsp");
            return;
        }

        // 次のページにフォワード
        forwardToPage(request, response, "WEB-INF/jsp/mandalaElement_4.jsp");
    }

    // ページ遷移処理を共通化
    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}