const APPOINT_API = "http://localhost:8080/appointment";

/* BOOK APPOINTMENT */
function bookAppointment() {

    let patientId = document.getElementById("patientId").value;
    let doctorId = document.getElementById("doctorId").value;

    fetch(`${APPOINT_API}/book/${patientId}/${doctorId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            appointmentDate: document.getElementById("date").value,
            appointmentTime: document.getElementById("time").value
        })
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadAppointments();
    });
}

/* LOAD APPOINTMENTS */
function loadAppointments() {

    fetch(APPOINT_API + "/get")
    .then(res => res.json())
    .then(data => {

        let table = document.getElementById("appointmentTable");
        table.innerHTML = "";

        data.forEach((a, index) => {
            table.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${a.patient ? a.patient.name : "-"}</td>
                <td>${a.doctor ? a.doctor.name : "-"}</td>
                <td>${a.appointmentDate}</td>
                <td>${a.appointmentTime}</td>
                <td>${a.status}</td>
                <td>
                    <button onclick="deleteAppointment(${a.id})">Delete</button>
                </td>
            </tr>`;
        });
    });
}

/* DELETE APPOINTMENT */
function deleteAppointment(id) {

    if (!confirm("Delete this appointment?")) return;

    fetch(`${APPOINT_API}/delete/${id}`, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadAppointments();
    });
}

window.onload = loadAppointments;