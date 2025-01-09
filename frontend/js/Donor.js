document.getElementById('donor-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const name = document.getElementById('name').value;
    const fatherName = document.getElementById('fatherName').value;
    const motherName = document.getElementById('motherName').value;
    const mobile = document.getElementById('mobile').value;
    const email = document.getElementById('email').value;
    const bloodGroup = document.getElementById('bloodGroup').value;
    const address = document.getElementById('address').value;

    const data = {
        name,
        fatherName,
        motherName,
        mobile,
        email,
        bloodGroup,
        address
    };

    try {
        const response = await fetch('http://localhost:8080/api/donor', {
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
        
        // Show success alert
        alert('Donor details submitted successfully!');
        
        const messageElement = document.getElementById('message');
        messageElement.textContent = 'Donor details submitted successfully!';
        messageElement.style.color = 'green';
        messageElement.style.fontWeight = 'bold';


    } catch (error) {
        console.error('Error:', error);
        
        // Show error alert
        alert('An error occurred while submitting donor details.');
        
        // Update message on the page
        document.getElementById('message').textContent = 'An error occurred while submitting donor details.';
        document.getElementById('message').style.color = 'red';
    }
});
