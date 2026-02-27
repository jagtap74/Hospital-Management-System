const DEPT_API = "http://localhost:8080/department";

/* ADD DEPARTMENT */
function addDepartment() {

    let department = {
        name: document.getElementById("name").value,
        description: document.getElementById("description").value
    };

    if (!department.name || !department.description) {
        alert("Please fill all fields");
        return;
    }

    fetch(DEPT_API + "/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(department)
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadDepartments();
    });
}

/* LOAD DEPARTMENTS */
function loadDepartments() {

    fetch(DEPT_API + "/get")
    .then(res => res.json())
    .then(data => {

        let table = document.getElementById("departmentTable");
        table.innerHTML = "";

        data.forEach((d, index) => {
            table.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${d.name}</td>
                <td>${d.description}</td>
                <td>
                    <button onclick="deleteDepartment(${d.id})">Delete</button>
                </td>
            </tr>`;
        });
    });
}

/* DELETE DEPARTMENT */
function deleteDepartment(id) {

    if (!confirm("Delete this department?")) return;

    fetch(DEPT_API + "/delete/" + id, {
        method: "DELETE"
    })
    .then(res => res.text())
    .then(msg => {
        alert(msg);
        loadDepartments();
    });
}

window.onload = loadDepartments;