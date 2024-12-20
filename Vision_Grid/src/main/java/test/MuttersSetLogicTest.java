package test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import model.MuttersSetLogic;
import model.PostMutterBeans;

public class MuttersSetLogicTest {

    public static void main(String[] args) {
        // テストデータの作成
        PostMutterBeans mutter = new PostMutterBeans();
        mutter.setUserId(1); 
        mutter.setPostDate(Timestamp.valueOf(LocalDateTime.now())); 
        mutter.setPostText("今日は新しいことに挑戦しました！"); 

        // ビジネスロジックの呼び出し
        MuttersSetLogic logic = new MuttersSetLogic();
        boolean result = logic.execute(mutter);

        // 結果を確認
        if (result) {
            System.out.println("投稿が正常に保存されました！");
        } else {
            System.out.println("投稿の保存に失敗しました。");
        }
    }
}
