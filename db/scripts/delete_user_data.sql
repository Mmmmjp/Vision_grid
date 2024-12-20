-- すべてのユーザーを削除
DELETE FROM USERS;

-- ユーザーID 1 を除くすべてのユーザーを削除
DELETE FROM USERS WHERE USER_ID <> 1;

-- ユーザーIDが1と2以外のユーザーを削除
DELETE FROM USERS WHERE USER_ID NOT IN (1, 2);