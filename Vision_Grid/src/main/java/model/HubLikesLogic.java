package model;

import dao.HubLikesDAO;

public class HubLikesLogic {

    /**
     * いいねを追加するビジネスロジック
     * 
     * @param like いいね情報を含むPostLikesBeans
     * @return 成功すればtrue、失敗すればfalse
     */
    public boolean addLike(PostLikesBeans like) {
        HubLikesDAO dao = new HubLikesDAO();
        return dao.addLikes(like); // DAOの結果をそのまま返す
    }
}
