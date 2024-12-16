document.addEventListener('DOMContentLoaded', function () {
    const showPeaksBtn = document.getElementById("showPeaks");
    const peaksContainer = document.getElementById("peaks-table");
    const showSheltersBtn = document.getElementById("showShelters");
    const sheltersContainer = document.getElementById("shelters-table");


    if (showPeaksBtn) {
        showPeaksBtn.addEventListener("click", function () {
            fetch("/showPeaks")
                .then(response => response.text())
                .then(data => {
                    peaksContainer.innerHTML = data;
                })
                .catch(e => {
                    console.log(e);
                });
        });
    }

    if (showSheltersBtn) {
        showSheltersBtn.addEventListener("click", function () {
            fetch("/showShelters")
                .then(response => response.text())
                .then(data => {
                    sheltersContainer.innerHTML = data;
                })
                .catch(e => {
                    console.log(e);
                });
        });
    }
});
