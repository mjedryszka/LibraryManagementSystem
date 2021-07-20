const API_URL = "http://localhost:8080/LibraryManagementSystem"

document.getElementById("allBooksList").addEventListener("click", (event) => {
    event.preventDefault();
    fetch(API_URL + "/hello")
    .then(response => response.text())
    .then((text) => {
        document.getElementById("libraryCenterMenu").innerHTML = text;
        });
    });