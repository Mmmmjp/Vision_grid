package model;

import dao.MuttersSetDAO;

public class MuttersSetLogic {

    /**
     * 投稿を保存するロジック
     * 
     * @param mutter 保存する投稿データ
     * @return 成功すればtrue、失敗すればfalse
     */
    public boolean execute(PostMutterBeans mutter) {
        // DAOを使用して投稿を保存
        MuttersSetDAO dao = new MuttersSetDAO();
        return dao.createPost(mutter);
    }
}

