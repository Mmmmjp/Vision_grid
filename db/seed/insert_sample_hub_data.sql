-- HUB_POSTS データの挿入 =================================
INSERT INTO HUB_POSTS (POST_ID, USER_ID, POST_DATE, POST_TEXT)
VALUES
-- 翔平の投稿 (野球関連)
(1, 1, CURRENT_TIMESTAMP, '今日も160km/hを目指して練習しました！'),

-- 美和1の投稿 (IT関連)
(2, 2, CURRENT_TIMESTAMP, 'デバッグで1時間かかりましたが、原因がわかってスッキリしました！');

-- HUB_LIKES データの挿入 ==================================
INSERT INTO HUB_LIKES (LIKE_ID, MUTTER_ID, USER_ID)
VALUES
-- 翔平が美和1の投稿に「いいね」
(1, 2, 1);
