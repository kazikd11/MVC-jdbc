document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("find-path-form");
    const pathContainer = document.querySelector(".path");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();
        const id1 = document.getElementById("start-point").value;
        const id2 = document.getElementById("end-point").value;

        try {
            const response = await fetch(`/findPath?id1=${id1}&id2=${id2}`);
            pathContainer.innerHTML = await response.text();
        } catch (error) {
            console.error(error);
        }
    });
});
