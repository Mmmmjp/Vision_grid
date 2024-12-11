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
import model.ElementBeans;

@WebServlet("/MandalaE1ActionServlet")
public class MandalaE1ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // セッションから要素リストを取得
        List<ElementBeans> pendingElementsList = (List<ElementBeans>) session.getAttribute("pendingElementsList");
        if (pendingElementsList == null || pendingElementsList.isEmpty()) {
            response.sendRedirect("MyPageServlet"); // リダイレクト
            return;
        }

        // セッションに保存するListの準備
        List<ActionBeans> pendingE1ActionsList = new ArrayList<>();

        // アクションのキーとテキストを取得し、ActionBeansインスタンスを作成
        String[] positions = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String position : positions) {
            String actionKey = request.getParameter("e1" + position + "Key");
            String actionText = request.getParameter("e1" + position + "Text");

            if (actionKey != null && actionText != null) {
                String fullPosition = "e1_" + position;
                ActionBeans action = new ActionBeans(fullPosition, actionKey, actionText);
                pendingE1ActionsList.add(action);
            }
        }

        // セッションスコープにリストを保存
        session.setAttribute("pendingE1ActionsList", pendingE1ActionsList);

        // 次のページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElement_2.jsp");
        dispatcher.forward(request, response);
    }
}