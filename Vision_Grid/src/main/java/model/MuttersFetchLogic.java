package model;

import java.util.List;

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
}
