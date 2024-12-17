document.addEventListener("DOMContentLoaded", function () {
    const printButton = document.getElementById("print-btn");
    printButton.addEventListener("click", function () {
        window.print(); // 印刷ダイアログを表示
    });
});
