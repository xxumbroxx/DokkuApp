package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.NOTIFICACION;
import pe.com.gmd.dokkuapp.domain.orm.NOTIFICACIONDao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class NotificacionRepositorio implements Repositorio<NOTIFICACION,NOTIFICACIONDao> {
    @Override
    public void insertOrUpdate(Context context, NOTIFICACION object) {
        dao(context).insertOrReplace(object);

    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();

    }

    @Override
    public NOTIFICACIONDao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getNOTIFICACIONDao();

    }

    @Override
    public NOTIFICACION getForId(Context context, long id) {
        return dao(context).load(id);
    }

    @Override
    public List<NOTIFICACION> getAll(Context context) {
        return dao(context).loadAll();
    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));

    }
}
