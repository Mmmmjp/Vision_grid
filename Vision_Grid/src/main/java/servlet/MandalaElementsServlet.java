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
import model.ElementBeans;
import model.ElementsFetchLogic;
import model.ElementsSetLogic;
import model.VisionBeans;


@WebServlet("/MandalaElementsServlet")
public class MandalaElementsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	// Vision IDを取得
        HttpSession session = request.getSession();
        VisionBeans vision = (VisionBeans) session.getAttribute("vision");
        if (vision == null) {
            response.sendRedirect("MyPageServlet");
            return;
        }
        int visionId = vision.getVisionId();
        
        //daoに渡すためのリストを準備
        List<ElementBeans> elementsList = new ArrayList<>();


        // パラメータの取得とElementBeansインスタンスの作成
        for (int i = 1; i <= 8; i++) {
            String keyParam = request.getParameter("e" + i + "Key");
            String textParam = request.getParameter("e" + i + "Text");


            System.out.println("Key: " + keyParam + ", Text: " + textParam); // デバッグ用


            if (keyParam != null && !keyParam.trim().isEmpty()) {
                // textParamが空の場合、nullに設定
                if (textParam == null || textParam.trim().isEmpty()) {
                    textParam = null;
                }

                // ポジションは"e1", "e2", ..., "e8"として手動設定
                ElementBeans element = new ElementBeans(visionId, "e" + i, keyParam, textParam);
                elementsList.add(element);
            }
        }

        // リストが空の場合、エラーページへ
        if (elementsList.isEmpty()) {
            System.out.println("Error: elementsList is empty."); // デバッグ用
            request.setAttribute("errorMessage", "要素が入力されていません。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElements.jsp");
            dispatcher.forward(request, response);
            return;
        }


        // 要素をデータベースに保存し要素idを取得
        ElementsSetLogic elementsSetLogic = new ElementsSetLogic();
        List<Integer> elementIdsList;
        try {
            elementIdsList = elementsSetLogic.execute(elementsList);
        } catch (RuntimeException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "データベース保存中にエラーが発生しました。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElements.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // 要素のキーリストを取得
        ElementsFetchLogic elementsFetchLogic = new ElementsFetchLogic();
        List<String> elementKeysList = elementsFetchLogic.getElementKeysByVisionId(visionId);


        // 成功した場合、IDのリストをセッションに保存
        session.setAttribute("elementIdsList", elementIdsList);
        session.setAttribute("elementKeysList", elementKeysList);


        // 次のページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mandalaElement_1.jsp");
        dispatcher.forward(request, response);
    }
}