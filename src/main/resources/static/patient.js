const PATIENT_API = "http://localhost:8080/patient";

/* ADD PATIENT */
function addPatient() {

    let patient = {
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        gender: document.getElementById("gender").value,
        contact: document.getElementById("contact").value,
        disease: document.getElementById("disease").value
    };

    if (!patient.name || !patient.age || !patient.gender || !patient.contact || !patient.disease) {
        alert("Please fill all fields");
        return;
    }

    fetch(PATIENT_API + "/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(patient)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadPatients();
    });
}

/* LOAD PATIENTS */
function loadPatients() {

    fetch(PATIENT_API + "/get")
    .then(res => res.json())
    .then(data => {

        let table = document.getElementById("patientTable");
        table.innerHTML = "";

        data.forEach((p, index) => {
            table.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>${p.gender}</td>
                <td>${p.contact}</td>
                <td>${p.disease}</td>
                <td>
                    <button onclick="deletePatient(${p.id})">Delete</button>
                </td>
            </tr>`;
        });
    });
}

/* DELETE PATIENT */
function deletePatient(id) {

    if (!confirm("Delete this patient?")) return;

    fetch(PATIENT_API + "/delete/" + id, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadPatients();
    });
}

window.onload = loadPatients;