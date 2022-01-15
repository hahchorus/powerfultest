var tarea = document.getElementById("tareax");
tarea.addEventListener("click", () => {
    axios.post("http://localhost:4567/registradato", {
        titulo: document.getElementById("titulo").value,
        descripcion: document.getElementById("descripcion").value,
    })
        .then(function (res) {
            alert("Dato:" + res.data.status);
        })
        .catch(function (error) {
            console.log(error)
        })
});