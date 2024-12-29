document.addEventListener('DOMContentLoaded', function () {
    console.log('Admin page scripts loaded.');

    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', event => {
            event.preventDefault();

            const action = form.getAttribute('action');
            const method = form.getAttribute('method').toUpperCase();

            const formData = new FormData(form);
            const data = Object.fromEntries(formData.entries());
            console.log(JSON.stringify(data))
            console.log(method)
            console.log(action)

            fetch(action, {
                method: method,
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Operation successful');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    });
});
