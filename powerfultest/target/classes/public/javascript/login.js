var iniciar = document.getElementById("Aceptar");
iniciar.addEventListener("click", function () {
    let email2 = document.getElementById("correo").value;
    let password2 = document.getElementById("contrasena").value;
    axios.get("http://localhost:4567/verificarlogin", {
        params: {
            email: email2,
            password: password2,
        }
    })
        .then(function (res) {
            let resul = res.data; 
            if(resul !=null){
                alert("Bienvenido");
                window.location.replace('tareas.html'); 
          }else{
                alert("Datos no encontrados");
          }
        })
        .catch(function (error) {
            console.log(error);
        });
});