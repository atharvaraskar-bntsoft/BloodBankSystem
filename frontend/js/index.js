document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form'); // Select the form

    form.addEventListener('submit', async function (event) {
        event.preventDefault(); // Prevent the default form submission

        // Collect form data
        const name = form.querySelector('input[name="name"]').value;
        const mobile = form.querySelector('input[name="mobile"]').value;
        const email = form.querySelector('input[name="email"]').value;
        const bloodGroup = form.querySelector('select[name="bloodGroup"]').value;

        // Basic validation
        if (!name || !mobile || !email || !bloodGroup) {
            alert('Please fill out all fields.');
            return;
        }

        // Validate email format
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert('Please enter a valid email address.');
            return;
        }

        // Construct the request payload
        const data = {
            name: name,
            mobile: mobile,
            email: email,
            bloodGroup: bloodGroup,
        };

        try {
            // Make the POST request
            const response = await fetch('http://localhost:8080/api/receivers', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const result = await response.json();
            console.log('Success:', result);
            alert('Donor details submitted successfully!');

            // Optionally reset the form or redirect
            form.reset(); // Reset the form fields
            // window.location.href = '/thank-you.html'; // Redirect after success

        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred while submitting donor details.');
        }
    });
});
