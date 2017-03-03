package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.TARJETA;
import pe.com.gmd.dokkuapp.domain.orm.TARJETADao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class TarjetaRepositorio implements Repositorio<TARJETA,TARJETADao> {
    @Override
    public void insertOrUpdate(Context context, TARJETA object) {
        dao(context).insertOrReplace(object);
    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();
    }

    @Override
    public TARJETADao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getTARJETADao();

    }

    @Override
    public TARJETA getForId(Context context, long id) {
        return dao(context).load(id);
    }

    @Override
    public List<TARJETA> getAll(Context context) {
        return dao(context).loadAll();
    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));
    }
}
