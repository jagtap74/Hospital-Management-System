const LOGIN_API = "http://localhost:8080/auth/login";

function login() {

    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();
    let errorMsg = document.getElementById("error-msg");

    errorMsg.innerText = "";

    if (username === "" || password === "") {
        errorMsg.innerText = "Please enter username and password";
        return;
    }

    fetch(LOGIN_API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(res => {
        if (res.ok) {
            return res.text();
        }
        throw new Error("Invalid");
    })
    .then(() => {
        alert("Login Successful");
        window.location.href = "index.html";
    })
    .catch(() => {
        errorMsg.innerText = "Invalid Username or Password";
    });
}