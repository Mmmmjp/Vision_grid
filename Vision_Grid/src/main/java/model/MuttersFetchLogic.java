package model;

import java.util.List;
import java.util.Map;

import dao.MuttersFetchDAO;

public class MuttersFetchLogic {

    /**
     * 全ての投稿を取得するメソッド
     * @return 投稿データのリスト
     */
    public List<PostMutterBeans> getAllMutters() {
        // DAOを利用してデータを取得
        MuttersFetchDAO dao = new MuttersFetchDAO();
        return dao.getAllMutters();
    }
    
    /**
     * 年と月別に投稿を取得するロジック
     * 
     * @return 年をキーにし、さらにその年の月をキーにした投稿リストを返すマップ
     */
    public Map<String, Map<String, List<PostMutterBeans>>> getMuttersGroupedByYearAndMonth() {
        MuttersFetchDAO dao = new MuttersFetchDAO();
        return dao.getMuttersGroupedByYearAndMonth();
    }
}
