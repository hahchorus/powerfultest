var registrarx = document.getElementById("registrarx");
registrarx.addEventListener("click", () => {
    axios.post("http://localhost:4567/usuario", {
        nombre: document.getElementById("nombre").value,
        apellido: document.getElementById("apellido").value,
        correo: document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value,
    })
        .then(function (res) {
            alert("usuario:" + res.data.status);
        })
        .catch(function (error) {
            console.log(error)
        })
});
