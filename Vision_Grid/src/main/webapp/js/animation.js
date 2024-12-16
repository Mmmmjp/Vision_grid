// loginSuccess.jsp - inspiration message =======================

document.addEventListener("DOMContentLoaded", function () {
    const inspirationMessage = document.querySelector(".inspiration-message");

    if (inspirationMessage) {
        // フェードイン＋バウンスのアニメーションを追加
        inspirationMessage.style.opacity = 0; // 初期透明度
        inspirationMessage.style.transform = "translateY(-20px)";
        inspirationMessage.style.transition = "all 1.5s ease-in-out";

        // 少し遅れてアニメーション開始
        setTimeout(() => {
            inspirationMessage.style.opacity = 1;
            inspirationMessage.style.transform = "translateY(0)";
        }, 300); // 300ms後にアニメーション開始
    }
});

// Top page - CTA section =====================================
document.addEventListener("DOMContentLoaded", () => {
    const animatedSection = document.querySelector(".animate-section");

    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    animatedSection.classList.add("fade-in");
                }
            });
        },
        { threshold: 0.2 } // セクションが20%表示されたらアニメーションを開始
    );

    observer.observe(animatedSection);
});

// マンダラチャート作成処理にて途中ログアウトをクリックした際のPOPUP====
    // ページのDOMが完全に読み込まれてから動作
document.addEventListener("DOMContentLoaded", function() {
    const logoutLink = document.querySelector(".mandala-logout");

    if (logoutLink) { // 要素が存在する場合のみ実行
        logoutLink.addEventListener("click", function(event) {
            // 確認メッセージを表示
            const userConfirmation = confirm("注意: ページに記入されている情報は保存されません。本当にログアウトしますか？");
            
            if (!userConfirmation) {
                // キャンセルされた場合、リンク遷移を防止
                event.preventDefault();
            }
        });
    }
});