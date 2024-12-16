document.addEventListener('DOMContentLoaded', function () {
    const resizer = document.querySelector('.resizer');
    const left = document.querySelector('.data-container');
    const right = document.querySelector('.map-container');

    let isResizing = false;

    console.log(resizer)

    resizer.addEventListener('mousedown', (e) => {
        isResizing = true;
        document.addEventListener('mousemove', handleMouseMove);
        document.addEventListener('mouseup', () => {
            isResizing = false;
            document.removeEventListener('mousemove', handleMouseMove);
        });
    });

    function handleMouseMove(e) {
        if (isResizing) {
            const w = e.clientX;
            const leftWidth = w;
            const rightWidth = window.innerWidth - w - resizer.offsetWidth;

            left.style.width = `${leftWidth}px`;
            right.style.width = `${rightWidth}px`;
        }
    }
});