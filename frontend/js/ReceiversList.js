// Fetch receiver data from the API
fetch('http://localhost:8080/api/receivers')
    .then(response => response.json()) // Parse JSON data
    .then(data => {
        // Get the table body element
        const tableBody = document.getElementById('receivers-table').getElementsByTagName('tbody')[0];

        // Loop through the data and add each receiver to the table
        data.forEach(receiver => {
            const row = tableBody.insertRow();

            // Insert cells for each receiver's details
            const cell1 = row.insertCell(0);
            cell1.textContent = receiver.id;

            const cell2 = row.insertCell(1);
            cell2.textContent = receiver.name;

            const cell3 = row.insertCell(2);
            cell3.textContent = receiver.mobile;

            const cell4 = row.insertCell(3);
            cell4.textContent = receiver.email;

            const cell5 = row.insertCell(4);
            cell5.textContent = receiver.bloodGroup;

            const cell6 = row.insertCell(5); // Status column
            cell6.textContent = receiver.status;

            // Actions column
            const cell7 = row.insertCell(6);
            const completeBtn = document.createElement('button');
            completeBtn.textContent = 'Mark Complete';
            completeBtn.className = 'complete-btn';

            const deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Delete';
            deleteBtn.className = 'delete-btn';

            // Event listener for "Mark Complete" button
            completeBtn.addEventListener('click', async () => {
                try {
                    const response = await fetch(`http://localhost:8080/api/receivers/${receiver.id}`, {
                        method: 'PATCH',
                        headers: {
                            'Content-Type': 'application/json' // Specify that the body is JSON
                        },
                        body: JSON.stringify({ status: 'Completed' }) // Send the status in the body
                    });
            
                    if (response.ok) {
                        cell6.textContent = 'Completed'; // Update the status
                        completeBtn.disabled = true; // Disable button
                        alert('Successfully update status');
                    } else {
                        alert('Failed to update status');
                    }
                } catch (error) {
                    console.error('Error updating status:', error);
                    alert('An error occurred while updating the status.');
                }
            });
            

            // Event listener for "Delete" button
            deleteBtn.addEventListener('click', () => {
                if (confirm(`Are you sure you want to delete ${receiver.name}?`)) {
                    fetch(`http://localhost:8080/api/receivers/${receiver.id}`, {
                        method: 'DELETE'
                    })
                    .then(response => {
                        if (response.ok) {
                            row.remove(); // Remove row from table
                        } else {
                            alert('Failed to delete receiver');
                        }
                    })
                    .catch(error => {
                        console.error('Error deleting receiver:', error);
                        alert('An error occurred while deleting the receiver.');
                    });
                }
            });

            // Append buttons to the Actions cell
            cell7.appendChild(completeBtn);
            cell7.appendChild(deleteBtn);
        });
    })
    .catch(error => {
        console.error('Error fetching receiver data:', error);
        alert('An error occurred while fetching the receiver data.');
    });
