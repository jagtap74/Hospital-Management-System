const BILL_API = "http://localhost:8080/billing";

function generateBill() {

    let patientId = document.getElementById("patientId").value;

    fetch(`${BILL_API}/generate/${patientId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            consultationFee: document.getElementById("consultationFee").value,
            medicineFee: document.getElementById("medicineFee").value,
            roomCharge: document.getElementById("roomCharge").value
        })
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadBills();
    })
    .catch(err => {
        console.error(err);
        alert("Error generating bill");
    });
}

function loadBills() {

    fetch(BILL_API + "/get")
    .then(res => res.json())
    .then(data => {

        let table = document.getElementById("billTable");
        table.innerHTML = "";

        data.forEach(b => {
            table.innerHTML += `
            <tr>
                <td>${b.id}</td>
                <td>${b.patient ? b.patient.name : "-"}</td>
                <td>${b.totalAmount}</td>
                <td>
                    <button onclick="deleteBill(${b.id})">Delete</button>
                </td>
            </tr>`;
        });
    });
}

function deleteBill(id) {

    fetch(`${BILL_API}/delete/${id}`, { method: "DELETE" })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadBills();
    });
}

window.onload = loadBills;