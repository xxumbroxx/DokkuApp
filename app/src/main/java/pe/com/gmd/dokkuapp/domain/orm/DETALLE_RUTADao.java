package pe.com.gmd.dokkuapp.domain.orm;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import pe.com.gmd.dokkuapp.domain.orm.DETALLE_RUTA;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DETALLE__RUTA".
*/
public class DETALLE_RUTADao extends AbstractDao<DETALLE_RUTA, Long> {

    public static final String TABLENAME = "DETALLE__RUTA";

    /**
     * Properties of entity DETALLE_RUTA.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Embarque = new Property(1, String.class, "Embarque", false, "EMBARQUE");
        public final static Property Orden = new Property(2, String.class, "Orden", false, "ORDEN");
        public final static Property Ruta_id = new Property(3, long.class, "ruta_id", false, "RUTA_ID");
        public final static Property Estacion_id = new Property(4, long.class, "estacion_id", false, "ESTACION_ID");
    };

    private Query<DETALLE_RUTA> rUTA_Fk_estacionesQuery;
    private Query<DETALLE_RUTA> eSTACION_Fk_embarqueQuery;

    public DETALLE_RUTADao(DaoConfig config) {
        super(config);
    }
    
    public DETALLE_RUTADao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DETALLE__RUTA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"EMBARQUE\" TEXT," + // 1: Embarque
                "\"ORDEN\" TEXT," + // 2: Orden
                "\"RUTA_ID\" INTEGER NOT NULL ," + // 3: ruta_id
                "\"ESTACION_ID\" INTEGER NOT NULL );"); // 4: estacion_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DETALLE__RUTA\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DETALLE_RUTA entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Embarque = entity.getEmbarque();
        if (Embarque != null) {
            stmt.bindString(2, Embarque);
        }
 
        String Orden = entity.getOrden();
        if (Orden != null) {
            stmt.bindString(3, Orden);
        }
        stmt.bindLong(4, entity.getRuta_id());
        stmt.bindLong(5, entity.getEstacion_id());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DETALLE_RUTA readEntity(Cursor cursor, int offset) {
        DETALLE_RUTA entity = new DETALLE_RUTA( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Embarque
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Orden
            cursor.getLong(offset + 3), // ruta_id
            cursor.getLong(offset + 4) // estacion_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DETALLE_RUTA entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEmbarque(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOrden(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRuta_id(cursor.getLong(offset + 3));
        entity.setEstacion_id(cursor.getLong(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DETALLE_RUTA entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DETALLE_RUTA entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "fk_estaciones" to-many relationship of RUTA. */
    public List<DETALLE_RUTA> _queryRUTA_Fk_estaciones(long ruta_id) {
        synchronized (this) {
            if (rUTA_Fk_estacionesQuery == null) {
                QueryBuilder<DETALLE_RUTA> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Ruta_id.eq(null));
                rUTA_Fk_estacionesQuery = queryBuilder.build();
            }
        }
        Query<DETALLE_RUTA> query = rUTA_Fk_estacionesQuery.forCurrentThread();
        query.setParameter(0, ruta_id);
        return query.list();
    }

    /** Internal query to resolve the "fk_embarque" to-many relationship of ESTACION. */
    public List<DETALLE_RUTA> _queryESTACION_Fk_embarque(long estacion_id) {
        synchronized (this) {
            if (eSTACION_Fk_embarqueQuery == null) {
                QueryBuilder<DETALLE_RUTA> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Estacion_id.eq(null));
                eSTACION_Fk_embarqueQuery = queryBuilder.build();
            }
        }
        Query<DETALLE_RUTA> query = eSTACION_Fk_embarqueQuery.forCurrentThread();
        query.setParameter(0, estacion_id);
        return query.list();
    }

}
