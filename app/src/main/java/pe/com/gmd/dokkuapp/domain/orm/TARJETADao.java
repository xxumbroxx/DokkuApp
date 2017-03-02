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

import pe.com.gmd.dokkuapp.domain.orm.TARJETA;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TARJETA".
*/
public class TARJETADao extends AbstractDao<TARJETA, Long> {

    public static final String TABLENAME = "TARJETA";

    /**
     * Properties of entity TARJETA.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IdTipo = new Property(1, String.class, "IdTipo", false, "ID_TIPO");
        public final static Property Color = new Property(2, String.class, "Color", false, "COLOR");
        public final static Property Nombre = new Property(3, String.class, "Nombre", false, "NOMBRE");
        public final static Property Descripcion = new Property(4, String.class, "Descripcion", false, "DESCRIPCION");
        public final static Property Requisitos = new Property(5, String.class, "Requisitos", false, "REQUISITOS");
        public final static Property PrecioTarjeta = new Property(6, String.class, "PrecioTarjeta", false, "PRECIO_TARJETA");
        public final static Property PrecioViaje = new Property(7, String.class, "PrecioViaje", false, "PRECIO_VIAJE");
        public final static Property Dias = new Property(8, String.class, "Dias", false, "DIAS");
        public final static Property Tipo_id = new Property(9, long.class, "tipo_id", false, "TIPO_ID");
    };

    private Query<TARJETA> tIPO_Fk_tarjetasQuery;

    public TARJETADao(DaoConfig config) {
        super(config);
    }
    
    public TARJETADao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TARJETA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ID_TIPO\" TEXT NOT NULL ," + // 1: IdTipo
                "\"COLOR\" TEXT," + // 2: Color
                "\"NOMBRE\" TEXT," + // 3: Nombre
                "\"DESCRIPCION\" TEXT," + // 4: Descripcion
                "\"REQUISITOS\" TEXT," + // 5: Requisitos
                "\"PRECIO_TARJETA\" TEXT," + // 6: PrecioTarjeta
                "\"PRECIO_VIAJE\" TEXT," + // 7: PrecioViaje
                "\"DIAS\" TEXT," + // 8: Dias
                "\"TIPO_ID\" INTEGER NOT NULL );"); // 9: tipo_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TARJETA\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TARJETA entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getIdTipo());
 
        String Color = entity.getColor();
        if (Color != null) {
            stmt.bindString(3, Color);
        }
 
        String Nombre = entity.getNombre();
        if (Nombre != null) {
            stmt.bindString(4, Nombre);
        }
 
        String Descripcion = entity.getDescripcion();
        if (Descripcion != null) {
            stmt.bindString(5, Descripcion);
        }
 
        String Requisitos = entity.getRequisitos();
        if (Requisitos != null) {
            stmt.bindString(6, Requisitos);
        }
 
        String PrecioTarjeta = entity.getPrecioTarjeta();
        if (PrecioTarjeta != null) {
            stmt.bindString(7, PrecioTarjeta);
        }
 
        String PrecioViaje = entity.getPrecioViaje();
        if (PrecioViaje != null) {
            stmt.bindString(8, PrecioViaje);
        }
 
        String Dias = entity.getDias();
        if (Dias != null) {
            stmt.bindString(9, Dias);
        }
        stmt.bindLong(10, entity.getTipo_id());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TARJETA readEntity(Cursor cursor, int offset) {
        TARJETA entity = new TARJETA( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // IdTipo
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Color
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Nombre
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Descripcion
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Requisitos
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // PrecioTarjeta
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // PrecioViaje
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // Dias
            cursor.getLong(offset + 9) // tipo_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TARJETA entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdTipo(cursor.getString(offset + 1));
        entity.setColor(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNombre(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescripcion(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRequisitos(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPrecioTarjeta(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPrecioViaje(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDias(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setTipo_id(cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TARJETA entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TARJETA entity) {
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
    
    /** Internal query to resolve the "fk_tarjetas" to-many relationship of TIPO. */
    public List<TARJETA> _queryTIPO_Fk_tarjetas(long tipo_id) {
        synchronized (this) {
            if (tIPO_Fk_tarjetasQuery == null) {
                QueryBuilder<TARJETA> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Tipo_id.eq(null));
                tIPO_Fk_tarjetasQuery = queryBuilder.build();
            }
        }
        Query<TARJETA> query = tIPO_Fk_tarjetasQuery.forCurrentThread();
        query.setParameter(0, tipo_id);
        return query.list();
    }

}