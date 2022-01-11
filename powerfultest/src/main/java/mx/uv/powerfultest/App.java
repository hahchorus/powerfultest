package mx.uv.powerfultest;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;

//import java.util.UUID.*;

import com.google.gson.*;

import mx.uv.powerfultest.db.DAO;
import mx.uv.powerfultest.db.Usuario;

public class App 
{

    private static Gson gson = new Gson();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        staticFiles.location("/");
        init();

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        /*------------------ Agregar usuario ---------------------*/
        post("/usuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);

            DAO dao = new DAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            return respuesta;
        });

        /*------------------- Valida login ---------------------- */

        get("/verificarUsuario", (req, res)->{
            Boolean resultado;
            DAO dao = new DAO();
            Usuario u;
            String correo = req.queryParams("correo"); //Recuperamos los datos del .js
            String password = req.queryParams("contraseña");
            u = dao.verificarUsuario(correo); //los datos los mandamos al DAO
            if(u!=null){
                if(password.equals(String.valueOf(u.getContraseña()))){
                    resultado = true;
                    return resultado;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        });

    }
}
