package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.TIPO;
import pe.com.gmd.dokkuapp.domain.orm.TIPODao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class TIpoRepositoeio implements Repositorio<TIPO,TIPODao> {
    @Override
    public void insertOrUpdate(Context context, TIPO object) {
        dao(context).insertOrReplace(object);
    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();
    }

    @Override
    public TIPODao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getTIPODao();

    }

    @Override
    public TIPO getForId(Context context, long id) {
        return dao(context).load(id);

    }

    @Override
    public List<TIPO> getAll(Context context) {
        return dao(context).loadAll();

    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));

    }
}
