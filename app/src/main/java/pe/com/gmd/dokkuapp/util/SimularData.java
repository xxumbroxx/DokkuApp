package pe.com.gmd.dokkuapp.util;

import android.content.Context;
import android.util.Log;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.domain.orm.TIPO;
import pe.com.gmd.dokkuapp.service.dao.impl.EstacionRepositorio;
import pe.com.gmd.dokkuapp.service.dao.impl.TIpoRepositoeio;

/**
 * Created by glarab on 2/03/2017.
 */

public class SimularData {
    public boolean simular(Context context){
        //crear tipo

        TIpoRepositoeio tIpoRepositoeio=new TIpoRepositoeio();tIpoRepositoeio.clear(context);

        EstacionRepositorio estacionRepositorio=new EstacionRepositorio();estacionRepositorio.clear(context);


        TIPO metropolitano=new TIPO(String2Long("1"),"","METROPOLITANO","#33333","METROPOLITANO","METROPOLITANO","TARJETA");
        tIpoRepositoeio.insertOrUpdate(context, metropolitano);
        //public ESTACION(Long id, String Nombre, String Direcion, String Descripcion, String Texto, Double Latitud, Double Longitud, Integer Foto, Boolean modulo, Boolean Estado, long tipo_id) {

        ESTACION estacion_naranjal=new ESTACION(String2Long("1"),"NARANJAL","AV. Tupac Amaru Comas","Ultima de lima norte","EST. NARANJAL",1.21212,2.32323,0,true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("2"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. IZAGUIRRE",1.21212,2.32323,0,true,true,String2Long("1"));

        estacionRepositorio.insertOrUpdate(context,estacion_naranjal);
        estacionRepositorio.insertOrUpdate(context,estacion_izaguirre);




        TIPO linea1=new TIPO(String2Long("2"),"","LINEA 1","#33333","LINEA 1","LINEA 1","TARJETA");
        tIpoRepositoeio.insertOrUpdate(context, linea1);


        return true;
    }
    public  long String2Long(String s){
       return Long.valueOf(s);
    }

}
