package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        // 投稿データの取得
        MuttersFetchLogic logic = new MuttersFetchLogic();
        Map<String, Map<String, List<PostMutterBeans>>> muttersByYearAndMonth = logic.getMuttersGroupedByYearAndMonth();

        // 年リストを取得
        List<String> years = new ArrayList<>(muttersByYearAndMonth.keySet());
        years.sort(Collections.reverseOrder());

        // 現在の年と月を取得
        LocalDate now = LocalDate.now();
        String currentYear = String.valueOf(now.getYear());
        String currentMonth = String.format("%02d", now.getMonthValue());

        // 月リストを取得 (現在の年の投稿がある場合)
        List<String> months = new ArrayList<>();
        if (muttersByYearAndMonth.containsKey(currentYear)) {
            months.addAll(muttersByYearAndMonth.get(currentYear).keySet());
            Collections.sort(months, Collections.reverseOrder());
        }

        // デフォルトで現在の月の投稿を取得
        List<PostMutterBeans> currentMonthMutters = new ArrayList<>();
        if (muttersByYearAndMonth.containsKey(currentYear) &&
            muttersByYearAndMonth.get(currentYear).containsKey(currentMonth)) {
            currentMonthMutters = muttersByYearAndMonth.get(currentYear).get(currentMonth);
        }

        // リクエストスコープに設定
        request.setAttribute("years", years);
        request.setAttribute("months", months);
        request.setAttribute("selectedYear", currentYear);
        request.setAttribute("selectedMonth", currentMonth);
        request.setAttribute("muttersByYearAndMonth", muttersByYearAndMonth);
        request.setAttribute("currentMonthMutters", currentMonthMutters);

        // JSPにフォワード
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
            HttpSession session = request.getSession();
            session.setAttribute("errorMsg", "投稿内容を入力してください。");
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
        MuttersSetLogic setLogic = new MuttersSetLogic();
        boolean isSuccess = setLogic.execute(mutter);

        // 投稿処理の結果に基づきリダイレクト
        if (isSuccess) {
            response.sendRedirect("HubPostMainServlet"); // 投稿成功時
        } else {
            session.setAttribute("errorMsg", "投稿に失敗しました。再度お試しください。");
            response.sendRedirect("HubPostMainServlet"); // 投稿失敗時
        }
    }
}
