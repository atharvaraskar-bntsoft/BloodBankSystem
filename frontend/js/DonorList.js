// Function to fetch and display donor data in table
async function fetchDonors() {
    try {
        const response = await fetch('http://localhost:8080/api/donor'); // Update this URL if needed
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const donors = await response.json(); // Assuming the response is in JSON format

        // Get the table body
        const tableBody = document.querySelector('#donor-table tbody');
        tableBody.innerHTML = ''; // Clear any previous rows

        // Populate the table with donor data
        donors.forEach(donor => {
            const row = document.createElement('tr');
            
            // Create table cells for each donor's details
            const nameCell = document.createElement('td');
            nameCell.textContent = donor.name;
            row.appendChild(nameCell);

            const fatherNameCell = document.createElement('td');
            fatherNameCell.textContent = donor.fatherName;
            row.appendChild(fatherNameCell);

            const motherNameCell = document.createElement('td');
            motherNameCell.textContent = donor.motherName;
            row.appendChild(motherNameCell);

            const mobileCell = document.createElement('td');
            mobileCell.textContent = donor.mobile;
            row.appendChild(mobileCell);

            const emailCell = document.createElement('td');
            emailCell.textContent = donor.email;
            row.appendChild(emailCell);

            const bloodGroupCell = document.createElement('td');
            bloodGroupCell.textContent = donor.bloodGroup;
            row.appendChild(bloodGroupCell);

            const addressCell = document.createElement('td');
            addressCell.textContent = donor.address;
            row.appendChild(addressCell);

            // Append the row to the table
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred while fetching donor data.');
    }
}

// Fetch donor data when the page loads
window.onload = fetchDonors;
