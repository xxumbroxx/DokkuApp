package pe.com.gmd.dokkuapp.domain.orm;

import java.util.List;
import pe.com.gmd.dokkuapp.domain.orm.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "RUTA".
 */
public class RUTA {

    private Long id;
    private String Nombre;
    private String Direccion;
    private String Origen;
    private String Destino;
    private String Texto;
    private String Dias;
    private Integer DesdeMA;
    private Integer HastaMA;
    private Integer DesdeTA;
    private Integer HastaTA;
    private Integer Frecuencia;
    private Boolean TiempoAproximado;
    private Boolean Estado;
    private long tipo_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RUTADao myDao;

    private List<DETALLE_RUTA> fk_estaciones;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public RUTA() {
    }

    public RUTA(Long id) {
        this.id = id;
    }

    public RUTA(Long id, String Nombre, String Direccion, String Origen, String Destino, String Texto, String Dias, Integer DesdeMA, Integer HastaMA, Integer DesdeTA, Integer HastaTA, Integer Frecuencia, Boolean TiempoAproximado, Boolean Estado, long tipo_id) {
        this.id = id;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Origen = Origen;
        this.Destino = Destino;
        this.Texto = Texto;
        this.Dias = Dias;
        this.DesdeMA = DesdeMA;
        this.HastaMA = HastaMA;
        this.DesdeTA = DesdeTA;
        this.HastaTA = HastaTA;
        this.Frecuencia = Frecuencia;
        this.TiempoAproximado = TiempoAproximado;
        this.Estado = Estado;
        this.tipo_id = tipo_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRUTADao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getDias() {
        return Dias;
    }

    public void setDias(String Dias) {
        this.Dias = Dias;
    }

    public Integer getDesdeMA() {
        return DesdeMA;
    }

    public void setDesdeMA(Integer DesdeMA) {
        this.DesdeMA = DesdeMA;
    }

    public Integer getHastaMA() {
        return HastaMA;
    }

    public void setHastaMA(Integer HastaMA) {
        this.HastaMA = HastaMA;
    }

    public Integer getDesdeTA() {
        return DesdeTA;
    }

    public void setDesdeTA(Integer DesdeTA) {
        this.DesdeTA = DesdeTA;
    }

    public Integer getHastaTA() {
        return HastaTA;
    }

    public void setHastaTA(Integer HastaTA) {
        this.HastaTA = HastaTA;
    }

    public Integer getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(Integer Frecuencia) {
        this.Frecuencia = Frecuencia;
    }

    public Boolean getTiempoAproximado() {
        return TiempoAproximado;
    }

    public void setTiempoAproximado(Boolean TiempoAproximado) {
        this.TiempoAproximado = TiempoAproximado;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public long getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(long tipo_id) {
        this.tipo_id = tipo_id;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DETALLE_RUTA> getFk_estaciones() {
        if (fk_estaciones == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DETALLE_RUTADao targetDao = daoSession.getDETALLE_RUTADao();
            List<DETALLE_RUTA> fk_estacionesNew = targetDao._queryRUTA_Fk_estaciones(id);
            synchronized (this) {
                if(fk_estaciones == null) {
                    fk_estaciones = fk_estacionesNew;
                }
            }
        }
        return fk_estaciones;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFk_estaciones() {
        fk_estaciones = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
