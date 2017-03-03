package pe.com.gmd.dokkuapp.util;

import android.content.Context;
import android.util.Log;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.domain.orm.RUTA;
import pe.com.gmd.dokkuapp.domain.orm.TIPO;
import pe.com.gmd.dokkuapp.service.dao.impl.EstacionRepositorio;
import pe.com.gmd.dokkuapp.service.dao.impl.RutaRepositorio;
import pe.com.gmd.dokkuapp.service.dao.impl.TIpoRepositoeio;

/**
 * Created by glarab on 2/03/2017.
 */

public class SimularData {
    public boolean simular(Context context){
        //crear tipo

        TIpoRepositoeio tIpoRepositoeio=new TIpoRepositoeio();tIpoRepositoeio.clear(context);

        EstacionRepositorio estacionRepositorio=new EstacionRepositorio();estacionRepositorio.clear(context);

        RutaRepositorio  rutaRepositorio=new RutaRepositorio();

        TIPO metropolitano=new TIPO(String2Long("1"),"","METROPOLITANO","#33333","METROPOLITANO","METROPOLITANO","TARJETA");
        tIpoRepositoeio.insertOrUpdate(context, metropolitano);
        //public ESTACION(Long id, String Nombre, String Direcion, String Descripcion, String Texto, Double Latitud, Double Longitud, Integer Foto, Boolean modulo, Boolean Estado, long tipo_id) {

        ESTACION estacion_naranjal=new ESTACION(String2Long("1"),"NARANJAL","AV. Tupac Amaru Comas","Ultima de lima norte","EST. NARANJAL",1.21212,2.32323,0,true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("2"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. IZAGUIRRE",1.21212,2.32323,0,true,true,String2Long("1"));

        estacionRepositorio.insertOrUpdate(context,estacion_naranjal);
        estacionRepositorio.insertOrUpdate(context,estacion_izaguirre);




        TIPO linea1=new TIPO(String2Long("2"),"","LINEA 1","#33333","LINEA 1","LINEA 1","TARJETA");
        tIpoRepositoeio.insertOrUpdate(context, linea1);






        //////////////////////rutas  //XXXXX00  //XXXXXXX
//(Long id, String Nombre, String Direccion, String Origen, String Destino, String Texto, String Dias, Integer DesdeMA, Integer HastaMA, Integer DesdeTA, Integer HastaTA, Integer Frecuencia, Boolean TiempoAproximado, Boolean Estado, long tipo_id) {

        RUTA regularA=new RUTA(String2Long("1"),"REGULAR A","A","NARANJAL","MATELLINI","Todas las estaciones","XXX00XX",6,12,12,23,30,true,true,String2Long("1"));
        RUTA regularB=new RUTA(String2Long("2"),"REGULAR B","B","NARANJAL","MATELLINI","Todas las estaciones","XXXXXXX",9,23,1,0,0,true,true,String2Long("1"));
        RUTA regularC=new RUTA(String2Long("3"),"REGULAR C","C","RAMON CASTILLA","MATELLINI","Todas las estaciones","XXXXXXX",6,23,0,0,30,true,true,String2Long("1"));
        RUTA regularD=new RUTA(String2Long("4"),"REGULAR D","D","NARANJAL","MATELLINI","Todas las estaciones","XXXXX00",6,9,0,0,30,true,true,String2Long("1"));
        RUTA superExpresoNorte=new RUTA(String2Long("5"),"SUPER EXPRESO NORTE","SXN","NARANJAL","CENTRAL","Tiempo maximo 20 min.","XXXXX00",6,9,17,21
                ,30,true,true,String2Long("1"));
        rutaRepositorio.insertOrUpdate(context,regularA);
        rutaRepositorio.insertOrUpdate(context,regularB);
        rutaRepositorio.insertOrUpdate(context,regularC);
        rutaRepositorio.insertOrUpdate(context,regularD);
        rutaRepositorio.insertOrUpdate(context,superExpresoNorte);


        return true;
    }
    public  long String2Long(String s){
       return Long.valueOf(s);
    }

}
