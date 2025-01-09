const apiUrl = "http://localhost:8080/api/stock";

// Fetch current stock data
async function fetchStock() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error("Failed to fetch stock data");
        }
        const stockData = await response.json();
        populateTable(stockData);
        populateDropdown(stockData);
    } catch (error) {
        console.error(error);
        alert("Error fetching stock data");
    }
}

// Populate stock table
function populateTable(stockData) {
    const stockTableBody = document.getElementById("stockTableBody");
    stockTableBody.innerHTML = ""; // Clear existing rows

    stockData.forEach(stock => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${stock.bloodGroup}</td>
            <td>${stock.units}</td>
        `;
        stockTableBody.appendChild(row);
    });
}

// Populate blood group dropdown
function populateDropdown(stockData) {
    const bloodGroupSelect = document.getElementById("bloodGroupSelect");
    bloodGroupSelect.innerHTML = '<option value="" disabled selected>Select a Blood Group</option>'; // Reset options

    stockData.forEach(stock => {
        const option = document.createElement("option");
        option.value = stock.bloodGroup;
        option.textContent = stock.bloodGroup;
        bloodGroupSelect.appendChild(option);
    });
}

// Update stock via PATCH request
async function updateStock() {
    const selectedBloodGroup = document.getElementById("bloodGroupSelect").value;
    const changeUnits = parseInt(document.getElementById("changeUnits").value);

    if (!selectedBloodGroup) {
        alert("Please select a blood group");
        return;
    }

    if (isNaN(changeUnits)) {
        alert("Please enter a valid number for units");
        return;
    }

    try {
        const response = await fetch(`${apiUrl}/${encodeURIComponent(selectedBloodGroup)}`, {
            method: "PATCH",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ units: changeUnits })
        });

        if (response.ok) {
            alert("Stock updated successfully");
            fetchStock(); // Refresh stock table
        } else {
            throw new Error("Failed to update stock");
        }
    } catch (error) {
        console.error(error);
        alert("Error updating stock");
    }
}

// Event listener for the update button
document.getElementById("updateStockButton").addEventListener("click", updateStock);

// Initial fetch of stock data
fetchStock();
