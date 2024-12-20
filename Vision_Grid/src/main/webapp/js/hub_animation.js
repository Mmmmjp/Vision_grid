document.addEventListener("DOMContentLoaded", () => {
    const likeForms = document.querySelectorAll(".like-form");

    likeForms.forEach((form) => {
        const button = form.querySelector(".like-button");
        const icon = form.parentElement.querySelector(".likes");
        const likeCountSpan = form.parentElement.querySelector("span");

        form.addEventListener("submit", (event) => {
            event.preventDefault(); // 通常のフォーム送信を防止

            // メガホンアイコンのアニメーション
            if (icon) {
                icon.classList.add("rotate");
                setTimeout(() => icon.classList.remove("rotate"), 600); // アニメーション終了後にリセット
            }

            // いいね数のアニメーション
            if (likeCountSpan) {
                likeCountSpan.classList.add("highlight");
                setTimeout(() => likeCountSpan.classList.remove("highlight"), 600); // アニメーション終了後にリセット
            }

            // フォーム送信（アニメーション終了後）
            setTimeout(() => {
                form.submit();
            }, 600);
        });
    });
});
