const DOCTOR_API = "http://localhost:8080/doctor";

/* ADD DOCTOR */
function addDoctor() {

    let doctor = {
        name: document.getElementById("name").value,
        specialization: document.getElementById("specialization").value,
        contact: document.getElementById("contact").value
    };

    if (!doctor.name || !doctor.specialization || !doctor.contact) {
        alert("Please fill all fields");
        return;
    }

    fetch(DOCTOR_API + "/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(doctor)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadDoctors();
    });
}

/* LOAD DOCTORS */
function loadDoctors() {

    fetch(DOCTOR_API + "/get")
    .then(res => res.json())
    .then(data => {

        let table = document.getElementById("doctorTable");
        table.innerHTML = "";

        data.forEach((d, index) => {
            table.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${d.name}</td>
                <td>${d.specialization}</td>
                <td>${d.contact}</td>
                <td>
                    <button onclick="deleteDoctor(${d.id})">Delete</button>
                </td>
            </tr>`;
        });
    });
}

/* DELETE DOCTOR */
function deleteDoctor(id) {

    if (!confirm("Delete this doctor?")) return;

    fetch(DOCTOR_API + "/delete/" + id, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadDoctors();
    });
}

window.onload = loadDoctors;