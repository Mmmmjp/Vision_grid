package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostMutterBeans implements Serializable {

    private int postId;       // 投稿ID
    private int userId;       // ユーザーID
    private Timestamp postDate; // 投稿日時
    private String postText;  // 投稿内容
    private String userName;  // ユーザー名

    // デフォルトコンストラクタ
    public PostMutterBeans() {}

    // パラメータ付きコンストラクタ
    
    public PostMutterBeans(int userId,Timestamp postDate, String postText) {
        this.userId = userId;
        this.postText = postText;
        this.postDate = postDate;
    }
    public PostMutterBeans(int postId, int userId,Timestamp postDate, String postText) {
        this.postId = postId;
        this.userId = userId;
        this.postText = postText;
        this.postDate = postDate;
    }
    
    // パラメータ付きコンストラクタ
    public PostMutterBeans(int postId, int userId, String userName, Timestamp postDate, String postText) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.postDate = postDate;
        this.postText = postText;
    }
    

    // Getter & Setter
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

 // 日付のみを返すカスタムメソッド
    public String getFormattedPostDate() {
        if (postDate != null) {
            LocalDate localDate = postDate.toLocalDateTime().toLocalDate();
            return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return null; // 日付がnullの場合
    }

    @Override
    public String toString() {
        return "PostMutterBeans [postId=" + postId + ", userId=" + userId + ", postText=" + postText 
                + ", postDate=" + getFormattedPostDate() + "]";
    }
}