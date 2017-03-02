package pe.com.gmd.dokkuapp.domain.orm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import pe.com.gmd.dokkuapp.domain.orm.USUARIO;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USUARIO".
*/
public class USUARIODao extends AbstractDao<USUARIO, Long> {

    public static final String TABLENAME = "USUARIO";

    /**
     * Properties of entity USUARIO.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IdUsuario = new Property(1, String.class, "IdUsuario", false, "ID_USUARIO");
        public final static Property Usuario = new Property(2, String.class, "Usuario", false, "USUARIO");
        public final static Property Contrasena = new Property(3, String.class, "Contrasena", false, "CONTRASENA");
        public final static Property Dni = new Property(4, String.class, "Dni", false, "DNI");
        public final static Property Nombres = new Property(5, String.class, "Nombres", false, "NOMBRES");
        public final static Property Celular = new Property(6, String.class, "Celular", false, "CELULAR");
        public final static Property Email = new Property(7, String.class, "email", false, "EMAIL");
    };


    public USUARIODao(DaoConfig config) {
        super(config);
    }
    
    public USUARIODao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USUARIO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ID_USUARIO\" TEXT NOT NULL ," + // 1: IdUsuario
                "\"USUARIO\" TEXT," + // 2: Usuario
                "\"CONTRASENA\" TEXT," + // 3: Contrasena
                "\"DNI\" TEXT," + // 4: Dni
                "\"NOMBRES\" TEXT," + // 5: Nombres
                "\"CELULAR\" TEXT," + // 6: Celular
                "\"EMAIL\" TEXT);"); // 7: email
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USUARIO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, USUARIO entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getIdUsuario());
 
        String Usuario = entity.getUsuario();
        if (Usuario != null) {
            stmt.bindString(3, Usuario);
        }
 
        String Contrasena = entity.getContrasena();
        if (Contrasena != null) {
            stmt.bindString(4, Contrasena);
        }
 
        String Dni = entity.getDni();
        if (Dni != null) {
            stmt.bindString(5, Dni);
        }
 
        String Nombres = entity.getNombres();
        if (Nombres != null) {
            stmt.bindString(6, Nombres);
        }
 
        String Celular = entity.getCelular();
        if (Celular != null) {
            stmt.bindString(7, Celular);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(8, email);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public USUARIO readEntity(Cursor cursor, int offset) {
        USUARIO entity = new USUARIO( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // IdUsuario
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Usuario
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Contrasena
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // Dni
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Nombres
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Celular
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // email
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, USUARIO entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdUsuario(cursor.getString(offset + 1));
        entity.setUsuario(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContrasena(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDni(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setNombres(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCelular(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEmail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(USUARIO entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(USUARIO entity) {
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
    
}
