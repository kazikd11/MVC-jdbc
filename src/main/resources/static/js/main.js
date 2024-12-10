document.addEventListener('DOMContentLoaded', function () {
    const showDataBtn = document.getElementById("showDataBtn");
    const dataContainer = document.getElementById("data-container");

    if (showDataBtn) {
        showDataBtn.addEventListener("click", function () {
            fetch("/showData")
                .then(response => response.text())
                .then(data => {
                    dataContainer.innerHTML = data;
                })
                .catch(e => {
                    console.log(e);
                });
        });
    }
});
