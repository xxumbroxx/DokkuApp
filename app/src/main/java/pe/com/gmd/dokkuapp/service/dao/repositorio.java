package pe.com.gmd.dokkuapp.service.dao;

import android.content.Context;

import java.util.List;


/**
 * Created by innovagmd on 27/10/16.
 */
public interface Repositorio<T,K> {
    public void insertOrUpdate(Context context, T object);
    public  void clear(Context context);
    public  K dao(Context c);
    public  T getForId(Context context, long id) ;
    public List<T> getAll(Context context);
    public  void deleteUserWithId(Context context, long id) ;
    }
