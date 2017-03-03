package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.domain.orm.ESTACIONDao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class EstacionRepositorio implements Repositorio<ESTACION,ESTACIONDao> {
    @Override
    public void insertOrUpdate(Context context, ESTACION object) {
        dao(context).insertOrReplace(object);

    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();

    }

    @Override
    public ESTACIONDao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getESTACIONDao();
    }

    @Override
    public ESTACION getForId(Context context, long id) {
        return dao(context).load(id);

    }

    @Override
    public List<ESTACION> getAll(Context context) {
        return dao(context).loadAll();
    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));

    }
}
