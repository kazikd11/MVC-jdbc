document.addEventListener('DOMContentLoaded', () => {
    const navButtons = document.querySelectorAll('.nav-button');
    const divs = document.querySelectorAll('.form-section');

    navButtons.forEach(button => {
        button.addEventListener('click', () => {
            const targetId = button.getAttribute('data-target');
            console.log(targetId);
            console.log("sections");
            divs.forEach(s => {
                s.classList.add('hidden');
                console.log("hidden");
            });
            document.querySelector(`#${targetId}`).classList.remove('hidden');
        });
    });

    const addPeakForm = document.getElementById('add-peak-form');
    if (addPeakForm) {
        addPeakForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = addPeakForm.getAttribute('action');
            const formData = new FormData(addPeakForm);
            const data = Object.fromEntries(formData.entries());

            fetch(action, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Szczyt dodany');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const updatePeakForm = document.getElementById('update-peak-form');
    if (updatePeakForm) {
        updatePeakForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = updatePeakForm.getAttribute('action');
            const formData = new FormData(updatePeakForm);
            const data = Object.fromEntries(formData.entries());
            const id = formData.get('id');
            const url = `${action}?id=${id}`;

            fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Szczyt zaktualizowany');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const deletePeakForm = document.getElementById('delete-peak-form');
    if (deletePeakForm) {
        deletePeakForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = deletePeakForm.getAttribute('action');
            const formData = new FormData(deletePeakForm);
            const id = formData.get('id');
            const url = `${action}?id=${id}`;

            fetch(url, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
                .then(response => {
                    if (response.ok) {
                        alert('Szczyt usuniety');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const addShelterForm = document.getElementById('add-shelter-form');
    if (addShelterForm) {
        addShelterForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = addShelterForm.getAttribute('action');
            const formData = new FormData(addShelterForm);
            const data = Object.fromEntries(formData.entries());
            const statusCheckbox = addShelterForm.querySelector('input[name="status"]');
            if (statusCheckbox) {
                data.status = statusCheckbox.checked;
            }
            console.log(data)


            fetch(action, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Schronisko dodane');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const updateShelterForm = document.getElementById('update-shelter-form');
    if (updateShelterForm) {
        updateShelterForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = updateShelterForm.getAttribute('action');
            const formData = new FormData(updateShelterForm);
            const data = Object.fromEntries(formData.entries());
            const id = formData.get('id');
            const url = `${action}?id=${id}`;
            const statusCheckbox = addShelterForm.querySelector('input[name="status"]');
            if (statusCheckbox) {
                data.status = statusCheckbox.checked;
            }

            fetch(url, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Schronisko zaktualizowane');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const deleteShelterForm = document.getElementById('delete-shelter-form');
    if (deleteShelterForm) {
        deleteShelterForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = deleteShelterForm.getAttribute('action');
            const formData = new FormData(deleteShelterForm);
            const id = formData.get('id');
            const url = `${action}?id=${id}`;

            fetch(url, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
                .then(response => {
                    if (response.ok) {
                        alert('Schronisko usuniete');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const addTrailPointForm = document.getElementById('add-trail-point-form');
    if (addTrailPointForm) {
        addTrailPointForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = addTrailPointForm.getAttribute('action');
            const formData = new FormData(addTrailPointForm);
            const data = Object.fromEntries(formData.entries());

            fetch(action, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Fragment szlaku dodany');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const updateTrailPointForm = document.getElementById('update-trail-point-form');
    if (updateTrailPointForm) {
        updateTrailPointForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = updateTrailPointForm.getAttribute('action');
            const formData = new FormData(updateTrailPointForm);
            const data = Object.fromEntries(formData.entries());

            fetch(action, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (response.ok) {
                        alert('Fragment szlaku zaktualizowany');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }

    const deleteTrailPointForm = document.getElementById('delete-trail-point-form');
    if (deleteTrailPointForm) {
        deleteTrailPointForm.addEventListener('submit', event => {
            event.preventDefault();
            const action = deleteTrailPointForm.getAttribute('action');
            const formData = new FormData(deleteTrailPointForm);
            const point1Id = formData.get('point1Id');
            const point2Id = formData.get('point2Id');
            const url = `${action}?id1=${point1Id}&id2=${point2Id}`;

            fetch(url, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
                .then(response => {
                    if (response.ok) {
                        alert('Fragment szlaku usuniety');
                    } else {
                        alert('Error: ' + response.status);
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    }
});
