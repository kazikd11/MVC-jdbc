document.addEventListener('DOMContentLoaded', function () {
    const showPeaksBtn = document.getElementById("showPeaks");
    const peaksContainer = document.getElementById("peaks-table");
    const showSheltersBtn = document.getElementById("showShelters");
    const sheltersContainer = document.getElementById("shelters-table");
    const showTrailsBtn = document.getElementById("fetch-trails-btn");
    const rows = document.querySelectorAll('.table-row');

    if(showTrailsBtn){
        showTrailsBtn.addEventListener("click", async () => {
            const response = await fetch("/api/trails");
            const trails = await response.json();

            const mapContainer = document.querySelector(".map-container");
            mapContainer.innerHTML = ""; // Clear previous content

            Object.entries(trails).forEach(([trailId, points]) => {
                const trailDiv = document.createElement("div");
                trailDiv.className = "trail";

                const trailLabel = document.createElement("h3");
                trailLabel.textContent = `Trail ${trailId}`;
                trailDiv.appendChild(trailLabel);

                points.forEach((point, index) => {
                    const pointDiv = document.createElement("div");
                    pointDiv.textContent = `Punkt ${point}`;
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

    function highlightPoint(id) {
        document.getElementById(`point-${id}`).classList.add('highlight');
        console.log('highlighted', id);
    }

    function clearHighlight() {
        const highlightedPoints = document.querySelectorAll('.highlight');
        highlightedPoints.forEach(point => {
            point.remove();
        });
    }

    rows.forEach(row => {
        row.addEventListener('mouseover', () => {
            const pointId = row.getAttribute('data-id');
            clearHighlight();
            highlightPoint(pointId);
        });
    });
});
