package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.RUTA;
import pe.com.gmd.dokkuapp.domain.orm.RUTADao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class RutaRepositorio implements Repositorio<RUTA,RUTADao> {
    @Override
    public void insertOrUpdate(Context context, RUTA object) {
        dao(context).insertOrReplace(object);

    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();

    }

    @Override
    public RUTADao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getRUTADao();

    }

    @Override
    public RUTA getForId(Context context, long id) {
        return dao(context).load(id);
    }

    @Override
    public List<RUTA> getAll(Context context) {
        return dao(context).loadAll();
    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));

    }
}
