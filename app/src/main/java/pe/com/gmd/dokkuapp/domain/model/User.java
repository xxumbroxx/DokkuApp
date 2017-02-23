package pe.com.gmd.dokkuapp.domain.model;


/**
 * Created by jmauricio on 01/06/2016.
 */
public class User  {

    private String CodigoUsuario;
    private String Cargo;
    private String Departamento;
    private String DominioUsuario;
    private String FotoUsuario;
    private String NombreUsuario;
    private String Proyecto;



    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        CodigoUsuario = codigoUsuario;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getDominioUsuario() {
        return DominioUsuario;
    }

    public void setDominioUsuario(String dominioUsuario) {
        DominioUsuario = dominioUsuario;
    }

    public String getFotoUsuario() {
        return FotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        FotoUsuario = fotoUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String proyecto) {
        Proyecto = proyecto;
    }

}
