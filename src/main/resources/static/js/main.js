document.addEventListener('DOMContentLoaded', function () {
    const showPeaksBtn = document.getElementById("showPeaks");
    const peaksContainer = document.getElementById("peaks-table");
    const showSheltersBtn = document.getElementById("showShelters");
    const sheltersContainer = document.getElementById("shelters-table");
    const showTrailsBtn = document.getElementById("fetch-trails-btn");

    if(showTrailsBtn){
        showTrailsBtn.addEventListener("click", async () => {
            const response = await fetch("/api/trails");
            const trails = await response.json();

            const mapContainer = document.querySelector(".map-container");
            mapContainer.innerHTML = "";

            Object.entries(trails).forEach(([trailId, points]) => {
                const trailDiv = document.createElement("div");
                trailDiv.className = "trail";

                const trailLabel = document.createElement("h3");
                trailLabel.textContent = `Szlak ${trailId}`;
                trailDiv.appendChild(trailLabel);

                points.forEach((point, index) => {
                    const pointDiv = document.createElement("div");
                    pointDiv.textContent = `${point}`;
                    pointDiv.className = `point point-${point}`;
                    console.log(pointDiv);

                    trailDiv.appendChild(pointDiv);

                    if (index < points.length - 1) {
                        const line = document.createElement("div");
                        line.className = "line";
                        trailDiv.appendChild(line);
                    }
                });

                mapContainer.appendChild(trailDiv);
            });
        });

    }

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

    document.addEventListener('click',function(){
        const pointElements = document.querySelectorAll("[class*='point-']");
        console.log(pointElements);
        pointElements.forEach(element => {
            const pointClass = Array.from(element.classList).find(cls => cls.startsWith("point-"));

            if (pointClass) {
                element.addEventListener("mouseover", () => {
                    console.log(pointClass);
                    const elementsToHighlight = document.querySelectorAll(`.${pointClass}`);
                    elementsToHighlight.forEach(el => {
                        el.style.backgroundColor = "lightblue";
                    });
                });

                element.addEventListener("mouseout", () => {
                    const elementsToUnhighlight = document.querySelectorAll(`.${pointClass}`);
                    elementsToUnhighlight.forEach(el => {
                        el.style.backgroundColor = "";
                    });
                });
            }
        });
    })

});
