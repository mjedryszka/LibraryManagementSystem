const LMS_URL = "http://localhost:8080/LibraryManagementSystem";
const loginForm = document.getElementById("loginForm");
const createAccountForm = document.getElementById("createAccountForm");

document.getElementById("allBooksList").addEventListener("click", (event) => {
    event.preventDefault();
    fetch(LMS_URL + "/hello")
    .then(response => response.text())
    .then((text) => {
        document.getElementById("libraryCenterMenu").innerHTML = text;
        document.getElementById("homePageForm").style.visibility = "visible";
        document.getElementById("createAccountForm").style.visibility = "hidden";
        document.getElementById("loginForm").style.visibility = "hidden";
        });
    });

document.getElementById("createAccountButtonInCA").addEventListener("click", (event) => {
    event.preventDefault();
    const createAccountObj = {
        login: createAccountForm.elements.loginPlaceholderInCA.value,
        password: createAccountForm.elements.passwordPlaceholderInCA.value,
        repeatPassword: createAccountForm.elements.repeatPasswordPlaceholderInCA.value
        };
    fetch(LMS_URL + "/createaccount" + "?" + new URLSearchParams(createAccountObj))
    .then(response => response.text())
    .then((text) => {
        console.log(text);
        });
    });

document.getElementById("logout").addEventListener("click", (event) => {
    event.preventDefault();
    document.getElementById("userNameLabel").innerHTML = "User name";
    document.getElementById("userNameLabel").style.backgroundColor = "lightgray";
    showForm("homePageForm");
    });

document.getElementById("loginButton").addEventListener("click", (event) => {
    event.preventDefault();
    const loginObj = {
        login: loginForm.elements.loginPlaceholder.value,
        password: loginForm.elements.passwordPlaceholder.value
        };
    fetch(LMS_URL + "/login" + "?" + new URLSearchParams(loginObj))
    .then(response => response.text())
    .then((text) => {
        if(text == "Ok"){
            document.getElementById("userNameLabel").innerHTML = loginObj.login;
			document.getElementById("userNameLabel").style.backgroundColor = "green"
            showForm("homePageForm");
        }else{
            document.getElementById("loginStatus").innerHTML = text;
            document.getElementById("loginPlaceholder").value = "";
            document.getElementById("passwordPlaceholder").value = "";
        }
        });
    });

document.getElementById("login").addEventListener("click",(event) =>{
    document.getElementById("loginStatus").innerHTML = "";
    document.getElementById("loginPlaceholder").value = "";
    document.getElementById("passwordPlaceholder").value = "";
    showForm("loginForm");
    });

document.getElementById("createAccount").addEventListener("click",(event) =>{
    showForm("createAccountForm");
    });
	
function showForm(id){
    document.getElementById("homePageForm").style.visibility = "hidden";
    document.getElementById("createAccountForm").style.visibility = "hidden";
    document.getElementById("loginForm").style.visibility = "hidden";

    document.getElementById(id).style.visibility = "visible";
}







