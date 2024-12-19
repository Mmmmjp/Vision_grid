package test;

import java.util.List;

import model.MuttersFetchLogic;
import model.PostMutterBeans;

public class MuttersFetchLogicTest {

    public static void main(String[] args) {
        // ビジネスロジックのインスタンス化
        MuttersFetchLogic logic = new MuttersFetchLogic();

        // 投稿データを取得
        List<PostMutterBeans> muttersList = logic.getAllMutters();

        // 結果を表示
        if (muttersList != null && !muttersList.isEmpty()) {
            System.out.println("データ取得成功！取得したデータを表示します：");
            for (PostMutterBeans mutter : muttersList) {
                System.out.println("投稿ID: " + mutter.getPostId());
                System.out.println("ユーザーID: " + mutter.getUserId());
                System.out.println("ユーザー名: " + mutter.getUserName());
                System.out.println("投稿日時: " + mutter.getFormattedPostDate());
                System.out.println("投稿内容: " + mutter.getPostText());
                System.out.println("----------------------------");
            }
        } else {
            System.out.println("データが取得できませんでした。");
        }
    }
}
