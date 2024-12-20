--コア機能に関するデータベース ====================

-- USERS テーブルの作成
CREATE TABLE USERS (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(40) NOT NULL UNIQUE,
    real_name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    dob DATE NOT NULL CHECK(dob < CURRENT_DATE),
    gender VARCHAR(10) NOT NULL
);

-- MANDALA_VISION テーブルの作成
CREATE TABLE MANDALA_VISION (
    vision_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    vision_key VARCHAR(100) NOT NULL,
    text VARCHAR(500),
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
    ON DELETE CASCADE
);

-- MANDALA_ELEMENTS テーブルの作成
CREATE TABLE MANDALA_ELEMENTS (
    element_id INT AUTO_INCREMENT PRIMARY KEY,
    vision_id INT NOT NULL,
    position VARCHAR(20) NOT NULL,
    element_key VARCHAR(100) NOT NULL,
    text VARCHAR(500),
    FOREIGN KEY (vision_id) REFERENCES MANDALA_VISION(vision_id)
    ON DELETE CASCADE
);

-- MANDALA_ACTIONS テーブルの作成
CREATE TABLE MANDALA_ACTIONS (
    action_id INT AUTO_INCREMENT PRIMARY KEY,
    element_id INT NOT NULL,
    position VARCHAR(20) NOT NULL,
    action_key VARCHAR(100) NOT NULL,
    text VARCHAR(500),
    FOREIGN KEY (element_id) REFERENCES MANDALA_ELEMENTS(element_id)
    ON DELETE CASCADE
);

-- POSTHUB機能に関するデータベース ====================

-- HUB_POSTS テーブルの作成
CREATE TABLE HUB_POSTS (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    post_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    post_text VARCHAR(500) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
    ON DELETE CASCADE
);

-- HUB_LIKES テーブルの作成
CREATE TABLE HUB_LIKES (
    like_id INT AUTO_INCREMENT PRIMARY KEY,
    mutter_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (mutter_id) REFERENCES HUB_POSTS(post_id)
    ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES USERS(user_id)
    ON DELETE CASCADE,
    UNIQUE (mutter_id, user_id) -- 投稿とユーザーの組み合わせを一意にする
);
