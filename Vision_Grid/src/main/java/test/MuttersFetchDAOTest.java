package test;

import java.util.List;

import dao.MuttersFetchDAO;
import model.PostMutterBeans;

public class MuttersFetchDAOTest {

    public static void main(String[] args) {
        // DAOのインスタンスを作成
        MuttersFetchDAO dao = new MuttersFetchDAO();

        // データを取得
        List<PostMutterBeans> muttersList = dao.getAllMutters();

        // 結果の確認
        if (muttersList != null && !muttersList.isEmpty()) {
            System.out.println("データ取得成功！取得したデータを表示します：");
            for (PostMutterBeans mutter : muttersList) {
                System.out.println("投稿ID: " + mutter.getPostId());
                System.out.println("ユーザーID: " + mutter.getUserId());
                System.out.println("投稿日時: " + mutter.getPostDate());
                System.out.println("投稿内容: " + mutter.getPostText());
                System.out.println("----------------------------");
            }
        } else {
            System.out.println("データが取得できませんでした。");
        }
    }
}

