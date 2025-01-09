document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form'); // Select the form

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the form from submitting

        // Get the username and password input values
        const username = form.querySelector('input[name="username"]').value;
        const password = form.querySelector('input[name="psw"]').value;

        // Check if the username and password match "admin"
        if (username === 'admin' && password === 'admin') {
            alert('Successful login');
            window.location.href = '/Dashboard.html'; // Redirect after success
        } else {
            alert('Invalid username or password');
        }
    });
});
