package mx.uv.powerfultest.db;

public class Dato {
    private String titulo;
    private String descripcion;

    public Dato(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
