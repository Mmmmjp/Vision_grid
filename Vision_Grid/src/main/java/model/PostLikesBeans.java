package model;

import java.io.Serializable;

public class PostLikesBeans implements Serializable {

    private int likeId;    // LIKEの一意のID
    private int postId;    // 投稿のID
    private int userId;    // LIKEしたユーザーのID

    // デフォルトコンストラクタ
    public PostLikesBeans() {}

    // コンストラクタ（likeIdなし）
    public PostLikesBeans(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
    }

    // コンストラクタ（likeIdあり）
    public PostLikesBeans(int likeId, int postId, int userId) {
        this.likeId = likeId;
        this.postId = postId;
        this.userId = userId;
    }

    // Getter and Setter
    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

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

    // toStringメソッド（デバッグ用）
    @Override
    public String toString() {
        return "PostLikesBeans{" +
                "likeId=" + likeId +
                ", postId=" + postId +
                ", userId=" + userId +
                '}';
    }
    

}
