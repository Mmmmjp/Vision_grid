// loginSuccess.jsp - inspiration message

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

// Top page - CTA section
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