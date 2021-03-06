package pe.com.gmd.dokkuapp.domain.orm;

import java.util.List;
import pe.com.gmd.dokkuapp.domain.orm.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "TIPO".
 */
public class TIPO {

    private Long id;
    /** Not-null value. */
    private String IdTipo;
    private String Color;
    private String Icono;
    private String Nombre;
    private String Texto;
    private String TipoPago;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient TIPODao myDao;

    private List<TARJETA> fk_tarjetas;
    private List<ESTACION> fk_estaciones;
    private List<RUTA> fk_rutas;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public TIPO() {
    }

    public TIPO(Long id) {
        this.id = id;
    }

    public TIPO(Long id, String IdTipo, String Color, String Icono, String Nombre, String Texto, String TipoPago) {
        this.id = id;
        this.IdTipo = IdTipo;
        this.Color = Color;
        this.Icono = Icono;
        this.Nombre = Nombre;
        this.Texto = Texto;
        this.TipoPago = TipoPago;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTIPODao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getIdTipo() {
        return IdTipo;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdTipo(String IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getIcono() {
        return Icono;
    }

    public void setIcono(String Icono) {
        this.Icono = Icono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<TARJETA> getFk_tarjetas() {
        if (fk_tarjetas == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TARJETADao targetDao = daoSession.getTARJETADao();
            List<TARJETA> fk_tarjetasNew = targetDao._queryTIPO_Fk_tarjetas(id);
            synchronized (this) {
                if(fk_tarjetas == null) {
                    fk_tarjetas = fk_tarjetasNew;
                }
            }
        }
        return fk_tarjetas;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFk_tarjetas() {
        fk_tarjetas = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ESTACION> getFk_estaciones() {
        if (fk_estaciones == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ESTACIONDao targetDao = daoSession.getESTACIONDao();
            List<ESTACION> fk_estacionesNew = targetDao._queryTIPO_Fk_estaciones(id);
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

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<RUTA> getFk_rutas() {
        if (fk_rutas == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RUTADao targetDao = daoSession.getRUTADao();
            List<RUTA> fk_rutasNew = targetDao._queryTIPO_Fk_rutas(id);
            synchronized (this) {
                if(fk_rutas == null) {
                    fk_rutas = fk_rutasNew;
                }
            }
        }
        return fk_rutas;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFk_rutas() {
        fk_rutas = null;
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
