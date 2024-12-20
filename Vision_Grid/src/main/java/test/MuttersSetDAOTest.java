package test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import dao.MuttersSetDAO;
import model.PostMutterBeans;

public class MuttersSetDAOTest {

    public static void main(String[] args) {
        // 投稿データを作成
        PostMutterBeans mutter = new PostMutterBeans();
        mutter.setUserId(1); // ユーザーID
        mutter.setPostDate(Timestamp.valueOf(LocalDateTime.now())); // 現在日時
        mutter.setPostText("今日はとても良い日でした！"); // 投稿内容

        // DAOを使用して投稿を登録
        MuttersSetDAO dao = new MuttersSetDAO();
        boolean result = dao.createPost(mutter);

        // 結果を表示
        if (result) {
            System.out.println("投稿が正常に作成されました！");
        } else {
            System.out.println("投稿の作成に失敗しました。");
        }
    }
}

