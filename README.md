# VisionGrid📋🚀

【目次】
- [アプリケーションについて](https://github.com/Mmmmjp/Vision_grid?tab=readme-ov-file#%E6%A6%82%E8%A6%81)
- [ターゲットユーザー]()
- [アプリケーションの作成動機]
- [アプリケーションの機能]
- [使用技術]
- [アプリケーション開発を通しての学習目標]
- [レポジトリクローンに関して]
- [データベースに関して]
- [ディレクトリ構図]

--- 
## アプリケーションについて
**VisionGrid**は、目標設定と達成をサポートするためのWebアプリケーションです。  
Mandalaチャートを採用し、ユーザーが大きな目標を具体的な要素とタスクに分解し、それを管理・振り返りながら達成を目指す仕組みを提供します。

---
## ターゲットユーザー
- 目標に向かって努力している方、新しいことを学んでいる方。
- 就職活動やキャリアの転換期にあり、自分自身と向き合う必要がある方。

---


## なぜVisionGridを作成したのか？[作成動機]

### 解決したい課題

このアプリは、以下のような課題を解決するために作成されました：
1. **学びの目的の明確化**  
   未経験からエンジニアを目指す中で、進むべき方向が不明確になり、モチベーションが低下するという経験から、目標設定と振り返りの重要性に気づきました。

2. **紙ベースのMandalaチャートの限界**  
   - 進捗を管理しにくい。
   - 修正や変更が難しい。
   - 振り返りが十分にできない。

### WEBアプリケーションによる解決策

1. **マス目が小さく、書ききれない**  
   - **解決策**: 補足情報を入力できる機能を追加。

2. **目標や要素の振り返りが難しい**  
   - **解決策**: 日記やレポート機能を提供。

3. **進捗管理が手軽にできない**  
   - **解決策**: 編集可能なMandalaチャートを実装。

4. **他の人と共有できない**  
   - **解決策**: ログイン機能を導入し、データをクラウドで管理。

---

## アプリケーション機能

### コア機能

- **質問形式で進めるMandalaチャート作成**  
   質問に答える形で、ユーザーが大きな目標、要素、タスクを設定できます。

- **ログイン認証、新規登録**  
   ユーザーごとのデータを保存し、どの端末からでもアクセス可能。

- **目標達成シートの閲覧**
   ログイン後、マイページより作成したマンダラチャートをいつでも閲覧可能。


### 今後の追加予定機能

- **柔軟な編集機能**  
   目標や要素を進捗に応じて修正可能。

- **振り返りツール**  
   日記やレポート機能を用いて、自分の進捗を定期的に振り返ることができます。

- **進捗グラフ**  
   目標達成度合いをグラフ化。

- **モチベーションアップ機能**  
   達成した目標に対して、バッジや通知で励ましを提供。

- **リマインダー機能**  
   定期的に目標を再確認する通知機能。

---

## アプリケーション開発を通しての学習目標

VisionGridの開発を通じて、以下のスキルを向上させました
- **Webアプリ制作の流れ**  
   企画から開発、デプロイまでの全体像を理解。

- **MVCモデルの理解**  
   アプリケーションの構造とデータ管理方法を学習。

- **GitHubによるバージョン管理**  
   バージョン管理の効率化とコラボレーションの基盤を習得。

---

## 使用技術
- **フロントエンド**: HTML, CSS, JavaScript
- **バックエンド**: Java
- **データベース**: SQL (H2 Database)
- **ツール**: Eclipse, VS Code, Figma, Google Spreadsheets

---

## Clone 
   ```bash
   git clone https://github.com/your-username/VisionGrid.git
   ```

---

## データベース

データベースファイルは、以下のディレクトリに保存してください：
```
~\Documents\database
```

---

## Directory Tree

### ログイン認証、新規登録機能実装までのディレクトリ構成
```
.
└── VisionGrid/
    ├── java/
    │   ├── servlet/
    │   │   ├── LoginServlet.java               # ログイン処理を行うサーブレット
    │   │   ├── RegisterServlet.java            # 新規登録画面への遷移を担当
    │   │   ├── RegCompleteServlet.java         # 登録確認後の処理を行うサーブレット
    │   │   └── Main.java                       # メインページ処理を担当（仮）
    │   ├── model/
    │   │   ├── AccountBeans.java               # ユーザー情報を保持するJavaBeans
    │   │   ├── LoginLogic.java                 # ログイン処理のロジック
    │   │   └── RegisterLogic.java              # 新規登録処理のロジック
    │   ├── filter/
    │   │   └── SetEncodingFilter.java          
    │   ├── dao/
    │   │   ├── BaseDAO.java                    # データベース接続の共通部分を定義
    │   │   ├── AccountsDAO.java                # ログイン用のデータ操作クラス
    │   │   └── AccountRegisterDAO.java         # 新規登録用のデータ操作クラス
    │   └── test/
    │       ├── AccountsDAOTest.java            # AccountsDAOのテストクラス
    │       └── LoginLogicTest.java             # LoginLogicのテストクラス
    └── webapp/
        ├── css/
        │   └── style.css                       
        ├── images/                             
        ├── WEB-INF/
        │   └── jsp/
        │       ├── includes/
        │       │   ├── header.jsp              
        │       │   └── footer.jsp              
        │       ├── login.jsp                   # ログイン画面
        │       ├── loginSuccess.jsp            # ログイン成功画面
        │       ├── registerConfirm.jsp         # 登録内容確認画面
        │       └── registerSuccess.jsp         # 登録成功画面
        └── index.jsp                           # トップページ

```

### 目標シート作成済みの場合のMyPageデータ表示機能を実装までのディレクトリ構成
```
.
└── VisionGrid/
    ├── java/
    │   ├── servlet/
    │   │   ├── LoginServlet.java
    │   │   ├── RegisterServlet.java
    │   │   ├── RegCompleteServlet.java
    │   │   ├── LogoutServlet.java
    │   │   └── MyPageServlet.java  
    │   ├── model/
    │   │   ├── AccountBeans.java[java beans]
    │   │   ├── LoginLogic.java
    │   │   ├── RegisterLogic.java
    │   │   ├── VisionBeans[java beans]
    │   │   ├── ElementBeans[java beans]
    │   │   ├── ActionBeans[java beans]
    │   │   ├── VisionFetchLogic.java
    │   │   ├── ElementsFetchLogic.java
    │   │   └── ActionsFetchLogic.java
    │   ├── filter/
    │   │   ├── SetEncodingFilter.java
    │   │   └── AuthenticationFilter.java
    │   ├── dao/
    │   │   ├── BaseDAO.java
    │   │   ├── AccountsDAO.java
    │   │   ├── AccountRegisterDAO.java
    │   │   ├── VisionFetchDAO.java
    │   │   ├── ElementsFetchDAO.java
    │   │   └── ActionsFetchDAO.java
    │   └── test/
    │       ├── AccountsDAOTest.java 
    │       ├── LoginLogicTest.java
    │       ├── VisionFetchDAOTest.java
    │       ├── VisionFetchLogicTest.java
    │       ├── ElementsFetchDAOTest.java
    │       ├── ElementsFetchLogicTest.java
    │       ├── ActionsFetchDAOTest.java
    │       └── ActionsFetchLogicTest.java
    └── webapp/
        ├── css/
        │   └── style.css
        ├── images
        ├── WEB-INF/
        │   └── jsp/
        │       ├── includes/
        │       │   ├── header.jsp
        │       │   └── footer.jsp
        │       ├── login.jsp
        │       ├── loginSuccess.jsp
        │       ├── registerConfirm.jsp
        │       ├── registerSuccess.jsp
        │       ├── myPageNoSheet.jsp
        │       └── myPageWithSheet.jsp
        └── index.jsp
```

### MyPageでのシート表示機能を実装までのディレクトリ構成
```
.
└── VisionGrid/
    ├── java/
    │   ├── servlet/
    │   │   ├── LoginServlet.java
    │   │   ├── RegisterServlet.java
    │   │   ├── RegCompleteServlet.java
    │   │   ├── LogoutServlet.java
    │   │   └── MyPageServlet.java  
    │   ├── model/
    │   │   ├── AccountBeans.java[java beans]
    │   │   ├── LoginLogic.java
    │   │   ├── RegisterLogic.java
    │   │   ├── VisionBeans[java beans]
    │   │   ├── ElementBeans[java beans]
    │   │   ├── ActionBeans[java beans]
    │   │   ├── VisionFetchLogic.java
    │   │   ├── ElementsFetchLogic.java
    │   │   └── ActionsFetchLogic.java
    │   ├── filter/
    │   │   ├── SetEncodingFilter.java
    │   │   └── AuthenticationFilter.java
    │   ├── dao/
    │   │   ├── BaseDAO.java
    │   │   ├── AccountsDAO.java
    │   │   ├── AccountRegisterDAO.java
    │   │   ├── VisionFetchDAO.java
    │   │   ├── ElementsFetchDAO.java
    │   │   └── ActionsFetchDAO.java
    │   └── test/
    │       ├── AccountsDAOTest.java 
    │       ├── LoginLogicTest.java
    │       ├── VisionFetchDAOTest.java
    │       ├── VisionFetchLogicTest.java
    │       ├── ElementsFetchDAOTest.java
    │       ├── ElementsFetchLogicTest.java
    │       ├── ActionsFetchDAOTest.java
    │       └── ActionsFetchLogicTest.java
    └── webapp/
        ├── css/
        │   ├── reset.css
        │   ├── style.css
        │   └── gridSheet.jsp
        ├── images
        ├── WEB-INF/
        │   └── jsp/
        │       ├── includes/
        │       │   ├── header.jsp
        │       │   ├── footer.jsp
        │       │   ├── gridSheet.jsp
        │       │   └── _gridRow.jspf
        │       ├── login.jsp
        │       ├── loginSuccess.jsp
        │       ├── registerConfirm.jsp
        │       ├── registerSuccess.jsp
        │       ├── myPageNoSheet.jsp
        │       └── myPageWithSheet.jsp
        └── index.jsp
```
#### 目標シートの表示についてポイント

> [!TIP]
>マンダラチャートの表示処理は、再利用性と保守性を高めるために以下のように実装しています：

1. **JSPフラグメントの利用**  
   セッションスコープからデータを取り出す処理や、グリッド構造を生成するコードの重複を避けるため、JSPフラグメントを使用して共通化しました。

2. **インクルードによる分割**  
   目標シートの表示部分をインクルードファイルとして分離し、親ページとロジックを明確に分割しました。このアプローチにより、見通しの良い構造を実現し、メンテナンス性を向上させました。

---

### 目標達成シートの作成完了までのディレクトリ構成
```
.
└── VisionGrid/
    ├── java/
    │   ├── servlet/
    │   │   ├── LoginServlet.java
    │   │   ├── RegisterServlet.java
    │   │   ├── RegCompleteServlet.java
    │   │   ├── LogoutServlet.java
    │   │   ├── MyPageServlet.java 
    │   │   ├── MandalaIntroServlet.java
    │   │   ├── MandalaVisionServlet.java
    │   │   ├── MandalaElementsServlet.java
    │   │   ├── MandalaE1ActionServlet.java
    │   │   ├── MandalaE2ActionServlet.java
    │   │   ├── MandalaE3ActionServlet.java
    │   │   ├── MandalaE4ActionServlet.java
    │   │   ├── MandalaE5ActionServlet.java
    │   │   ├── MandalaE6ActionServlet.java
    │   │   ├── MandalaE7ActionServlet.java
    │   │   └── MandalaE8ActionServlet.java
    │   ├── model/
    │   │   ├── AccountBeans.java[java beans]
    │   │   ├── LoginLogic.java
    │   │   ├── RegisterLogic.java
    │   │   ├── VisionBeans[java beans]
    │   │   ├── ElementBeans[java beans]
    │   │   ├── ActionBeans[java beans]
    │   │   ├── VisionFetchLogic.java
    │   │   ├── ElementsFetchLogic.java
    │   │   ├── ActionsFetchLogic.java
    │   │   ├── ElementsSetLogic.java
    │   │   ├── VisionSetLogic.java
    │   │   └── ActionsSetLogic.java
    │   ├── filter/
    │   │   ├── SetEncodingFilter.java
    │   │   └── AuthenticationFilter.java
    │   ├── dao/
    │   │   ├── BaseDAO.java
    │   │   ├── AccountsDAO.java
    │   │   ├── AccountRegisterDAO.java
    │   │   ├── VisionFetchDAO.java
    │   │   ├── ElementsFetchDAO.java
    │   │   ├── ActionsFetchDAO.java
    │   │   ├── VisionSetDAO.java
    │   │   ├── ElementsSetDAO.java
    │   │   └── ActionsSetDAO.java
    │   └── test/
    │       ├── AccountsDAOTest.java 
    │       ├── LoginLogicTest.java
    │       ├── VisionFetchDAOTest.java
    │       ├── VisionFetchLogicTest.java
    │       ├── ElementsFetchDAOTest.java
    │       ├── ElementsFetchLogicTest.java
    │       ├── ActionsFetchDAOTest.java
    │       ├── ActionsFetchLogicTest.java
    │       └── MandalaCreationTest.java
    └── webapp/
        ├── css/
        │   ├── reset.css
        │   ├── style.css
        │   └── gridSheet.jsp
        ├── images
        ├── WEB-INF/
        │   └── jsp/
        │       ├── includes/
        │       │   ├── header.jsp
        │       │   ├── footer.jsp
        │       │   ├── gridSheet.jsp
        │       │   └── _gridRow.jspf
        │       ├── login.jsp
        │       ├── loginSuccess.jsp
        │       ├── registerConfirm.jsp
        │       ├── registerSuccess.jsp
        │       ├── myPageNoSheet.jsp
        │       ├── myPageWithSheet.jsp
        │       ├── mandalaVision.jsp
        │       ├── mandalaVision.jsp
        │       ├── mandalaElements.jsp
        │       ├── mandalaElement_1.jsp
        │       ├── mandalaElement_2.jsp
        │       ├── mandalaElement_3.jsp
        │       ├── mandalaElement_4.jsp
        │       ├── mandalaElement_5.jsp
        │       ├── mandalaElement_6.jsp
        │       ├── mandalaElement_7.jsp
        │       ├── mandalaElement_8.jsp
        │       ├── mandalaComplete.jsp
        │       └── mandala_error.jsp
        └── index.jsp
```

