package test;

import model.HubLikesLogic;
import model.PostLikesBeans;

public class HubLikesLogicTest {
    public static void main(String[] args) {
        HubLikesLogic logic = new HubLikesLogic();

        int postId = 2; // テスト投稿ID
        int userId = 1; // テストユーザーID

        // 初回いいね
        PostLikesBeans firstLike = new PostLikesBeans(postId, userId);
        boolean firstResult = logic.addLike(firstLike);
        if (firstResult) {
            System.out.println("初回いいねが正常に追加されました！");
        } else {
            System.out.println("初回いいねの追加に失敗しました。");
        }

        // 重複いいね試行
        PostLikesBeans duplicateLike = new PostLikesBeans(postId, userId);
        boolean secondResult = logic.addLike(duplicateLike);
        if (!secondResult) {
            System.out.println("重複いいねが防止されました！");
        } else {
            System.out.println("重複いいねの防止に失敗しました。");
        }
    }
}
