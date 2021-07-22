const LMS_URL = "http://localhost:8080/LibraryManagementSystem";
const loginForm = document.getElementById("loginForm");

document.getElementById("loginButton").addEventListener("click", (event) => {
    event.preventDefault();
    const loginObj = {
        login: loginForm.elements.loginPlaceholder.value,
        password: loginForm.elements.passwordPlaceholder.value
        };
    console.log(LMS_URL + "/login" + "?" + new URLSearchParams(loginObj));
    fetch(LMS_URL + "/login" + "?" + new URLSearchParams(loginObj))
    .then(response => response.text())
    .then((data) => {
    console.log(data);
    });
    });

document.getElementById("allBooksList").addEventListener("click", (event) => {
    event.preventDefault();
    fetch(LMS_URL + "/hello")
    .then(response => response.text())
    .then((text) => {
        document.getElementById("libraryCenterMenu").innerHTML = text;
        });
    });

document.getElementById("login").addEventListener("click",(event) =>{
    document.getElementById("homePageForm").style.visibility = "hidden";
    document.getElementById("createAccountForm").style.visibility = "hidden";
    document.getElementById("loginForm").style.visibility = "visible";
    });

document.getElementById("createAccount").addEventListener("click",(event) =>{
    document.getElementById("homePageForm").style.visibility = "hidden";
    document.getElementById("createAccountForm").style.visibility = "visible";
    document.getElementById("loginForm").style.visibility = "hidden";
    });





