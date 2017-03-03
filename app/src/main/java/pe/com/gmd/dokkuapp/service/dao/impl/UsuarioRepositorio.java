package pe.com.gmd.dokkuapp.service.dao.impl;

import android.content.Context;

import java.util.List;

import pe.com.gmd.dokkuapp.domain.orm.USUARIO;
import pe.com.gmd.dokkuapp.domain.orm.USUARIODao;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.view.AndroidApplication;

/**
 * Created by glarab on 2/03/2017.
 */

public class UsuarioRepositorio implements Repositorio<USUARIO,USUARIODao> {
    @Override
    public void insertOrUpdate(Context context, USUARIO object) {
        dao(context).insertOrReplace(object);

    }

    @Override
    public void clear(Context context) {
        dao(context).deleteAll();

    }

    @Override
    public USUARIODao dao(Context c) {
        return ((AndroidApplication) c.getApplicationContext()).getDaoSession().getUSUARIODao();

    }

    @Override
    public USUARIO getForId(Context context, long id) {
        return dao(context).load(id);
    }

    @Override
    public List<USUARIO> getAll(Context context) {
        return dao(context).loadAll();
    }

    @Override
    public void deleteUserWithId(Context context, long id) {
        dao(context).delete(getForId(context, id));

    }
}
