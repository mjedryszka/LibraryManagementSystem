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
        if(text == "Ok"){
            document.getElementById("createAccountStatus").innerHTML = text;
            showForm("homePageForm");
        }else{
            document.getElementById("createAccountStatus").innerHTML = text;
            document.getElementById("loginPlaceholderInCA").value = "";
            document.getElementById("passwordPlaceholderInCA").value = "";
            document.getElementById("repeatPasswordPlaceholderInCA").value = "";
            }
        });
    });

document.getElementById("createAccountButtonInNEF").addEventListener("click", (event) => {
    event.preventDefault();
    const createAccountEmployeeObj = {
        login: createAccountForm.elements.loginPlaceholderInNEF.value,
        password: createAccountForm.elements.passwordPlaceholderInNEF.value,
        };
    fetch(LMS_URL + "/createemployeeaccount" + "?" + new URLSearchParams(createAccountEmployeeObj))
    .then(response => response.text())
    .then((text) => {
        if(text == "Ok"){
            document.getElementById("createAccountStatusInNEF").innerHTML = text;
            showForm("homePageForm");
        }else{
            document.getElementById("createAccountStatusInNEF").innerHTML = text;
            document.getElementById("loginPlaceholderInNEF").value = "";
            document.getElementById("passwordPlaceholderInNEF").value = "";
            }
        });
    });

document.getElementById("changePasswordButton").addEventListener("click",(event) => {
    event.preventDefault();
    const changePasswordObj = {
        login: editAccountForm.elements.loginPlaceholderInEA.value,
        newPassword: editAccountForm.elements.passwordPlaceholderInEA.value
    };
    fetch(LMS_URL + "/editaccount/changepassword" + "?" + new URLSearchParams(changePasswordObj))
    .then(response => response.text())
    .then((text) => {
        document.getElementById("changeResult").innerHTML = text;
        if(text == "passwordChanged"){
            document.getElementById("loginPlaceholderInEA").value="";
            document.getElementById("newLoginPlaceholderInEA").value=""
            document.getElementById("passwordPlaceholderInEA").value=""
        }
    });
});

document.getElementById("changeLoginButton").addEventListener("click",(event) => {
    event.preventDefault();
    const changeLoginObj = {
        login: editAccountForm.elements.loginPlaceholderInEA.value,
        newLogin: editAccountForm.elements.newLoginPlaceholderInEA.value
    };
    fetch(LMS_URL + "/editaccount/changelogin" + "?" + new URLSearchParams(changeLoginObj))
    .then(response => response.text())
    .then((text) => {
        document.getElementById("changeResult").innerHTML = text;
        if(text == "loginChanged"){
            document.getElementById("loginPlaceholderInEA").value="";
            document.getElementById("newLoginPlaceholderInEA").value=""
            document.getElementById("passwordPlaceholderInEA").value=""
        }
    });
});

document.getElementById("deleteAccountButton").addEventListener("click", (event) => {
    event.preventDefault();
    const deleteAccountObj = {
        login: deleteAccountForm.elements.loginPlaceholderInDA.value
        };
    fetch(LMS_URL + "/deleteaccount" + "?" + new URLSearchParams(deleteAccountObj))
    .then(response => response.text())
    .then((text) => {
        document.getElementById("deleteAccountResult").innerHTML = text;
        if(text == "Account deleted"){
            document.getElementById("loginPlaceholderInDA").value="";
        }
    });
});

document.getElementById("logout").addEventListener("click", (event) => {
    event.preventDefault();
    document.getElementById("userNameLabel").innerHTML = "User name";
    document.getElementById("userNameLabel").style.backgroundColor = "lightgray";
    hideExtraButtons();
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
        if(text == "READER"){
            hideExtraButtons();
            showLogin(loginObj.login);
            showForm("homePageForm");
        }else if(text == "EMPLOYEE"){
            hideExtraButtons();
            showLogin(loginObj.login);
            showEmployeeButtons();
            showForm("homePageForm");
        }else if(text == "ADMIN"){
            hideExtraButtons();
            showLogin(loginObj.login);
            showAdminButtons();
            showForm("homePageForm")
        }else{
            document.getElementById("loginStatus").innerHTML = text;
            document.getElementById("loginPlaceholder").value = "";
            document.getElementById("passwordPlaceholder").value = "";
        }
        });
    });

document.getElementById("login").addEventListener("click",(event) =>{
    event.preventDefault();
    document.getElementById("loginStatus").innerHTML = "";
    document.getElementById("loginPlaceholder").value = "";
    document.getElementById("passwordPlaceholder").value = "";
    showForm("loginForm");
    });

document.getElementById("createAccount").addEventListener("click",(event) =>{
    event.preventDefault();
    document.getElementById("loginPlaceholderInCA").value = "";
    document.getElementById("passwordPlaceholderInCA").value = "";
    document.getElementById("repeatPasswordPlaceholderInCA").value = "";
    showForm("createAccountForm");
    });

document.getElementById("editAccount").addEventListener("click",(event) =>{
    event.preventDefault();
    document.getElementById("loginPlaceholderInEA").value = "";
    document.getElementById("newLoginPlaceholderInEA").value = "";
    showForm("editAccountForm");
    });

document.getElementById("deleteAccount").addEventListener("click",(event) =>{
    event.preventDefault();
    document.getElementById("loginPlaceholderInDA").value = "";
    showForm("deleteAccountForm");
    });

document.getElementById("createNewEmployee").addEventListener("click",(event) =>{
    event.preventDefault();
    document.getElementById("loginPlaceholderInNEF").value = "";
    document.getElementById("passwordPlaceholderInNEF").value = "";
    document.getElementById("repeatPasswordPlaceholderInNEF").value = "";
    showForm("createNewEmployeeForm");
    });

function showForm(id){
    document.getElementById("homePageForm").style.visibility = "hidden";
    document.getElementById("createAccountForm").style.visibility = "hidden";
    document.getElementById("loginForm").style.visibility = "hidden";
    document.getElementById("editAccountForm").style.visibility = "hidden";
    document.getElementById("deleteAccountForm").style.visibility = "hidden";
    document.getElementById("createNewEmployeeForm").style.visibility = "hidden";

    document.getElementById(id).style.visibility = "visible";
}

function showLogin(login){
    document.getElementById("userNameLabel").innerHTML = login;
    document.getElementById("userNameLabel").style.backgroundColor = "green"
}

function showEmployeeButtons(){
    document.getElementById("employeeManageAccountForm").style.visibility = "visible";
    document.getElementById("employeePositionsForm").style.visibility = "visible";
}

function showAdminButtons(){
    document.getElementById("employeeManageAccountForm").style.visibility = "visible";
    document.getElementById("employeePositionsForm").style.visibility = "visible";
    document.getElementById("adminManageAccountForm").style.visibility = "visible";
}

function hideExtraButtons(){
    document.getElementById("employeeManageAccountForm").style.visibility = "hidden";
    document.getElementById("employeePositionsForm").style.visibility = "hidden";
    document.getElementById("adminManageAccountForm").style.visibility = "hidden";
}







