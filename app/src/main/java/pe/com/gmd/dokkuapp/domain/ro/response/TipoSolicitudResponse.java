package pe.com.gmd.dokkuapp.domain.ro.response;

/**
 * Created by icaceres on 24/02/2017.
 */

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

public class TipoSolicitudResponse {

    @SerializedName("TipoSolicitud")
    private String tipoSolicitud;
    @SerializedName("CodigoSolicitud")
    private String codigoSolicitud;
    @SerializedName("Nombres")
    private String nombres;
    @SerializedName("Apellidos")
    private String apellidos;
    @SerializedName("Cargo")
    private String cargo;
    @SerializedName("Empresa")
    private String empresa;
    @SerializedName("Proyecto")
    private String proyecto;
    @SerializedName("FechaSolicitud")
    private String fechaSolicitud;
    @SerializedName("FlagVisto")
    private int flagVisto;

    public TipoSolicitudResponse(String tipoSolicitud, String codigoSolicitud, String nombres, String apellidos, String cargo, String empresa, String proyecto, String fechaSolicitud) {

        this.tipoSolicitud = tipoSolicitud;
        this.codigoSolicitud = codigoSolicitud;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.empresa = empresa;
        this.proyecto = proyecto;
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

//    public String getFlagVisto() {
//        return flagVisto;
//    }
//
//    public void setFlagVisto(String flagVisto) {
//        this.flagVisto = flagVisto;
//    }


    public int getFlagVisto() {
        return flagVisto;
    }

    public void setFlagVisto(int flagVisto) {
        this.flagVisto = flagVisto;
    }
}
