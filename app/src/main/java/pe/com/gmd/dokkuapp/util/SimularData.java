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

        ESTACION estacion_naranjal=new ESTACION(String2Long("1"),"NARANJAL","AV. Tupac Amaru Comas","Ultima de lima norte","EST. NARANJAL","-11.982822", "-77.058552","https://0.kekantoimg.com/a7nsrVcjOf1_T2mkenDV5y8s1CI=/308x205/s3.amazonaws.com/kekanto_pics/pics/268/687268.jpg",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("2"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","http://cde.peru21.pe/ima/0/0/1/1/8/118923.jpg",true,true,String2Long("1"));
        ESTACION estacion_pacifico=new ESTACION(String2Long("3"),"PACIFICO","AV. Tupac Amaru Los Olivos","Av. PACIFICO","EST. PACIFICO","-11.994915"," -77.055946","http://senalalternativa.com/wp-content/uploads/2011/02/Metropolitano_opt.jpg",true,true,String2Long("1"));
        ESTACION estacion_independencia=new ESTACION(String2Long("4"),"INDEPENDENCIA","AV. Tupac Amaru Los Olivos","Av. RUFINO MACEDO","EST. INDEPENDENCIA","-11.998553", "-77.055222","http://senalalternativa.com/wp-content/uploads/2012/08/Metro.jpg",true,true,String2Long("1"));
        ESTACION estacion_los_jazmines=new ESTACION(String2Long("5"),"LOS JAZMINES","AV. Tupac Amaru Los Olivos","Av. SANDIAS","EST. LOS JAZMINES","-12.001989", "-77.054782","https://lh3.googleusercontent.com/-ANy13eExSvA/WD7tWFPMwiI/AAAAAAAAC9k/FSOSW4kTn5kDiNo5mv-NGKi8yV0i717nwCLIB/s544-k-no/",true,true,String2Long("1"));
        ESTACION estacion_tomas_valle=new ESTACION(String2Long("6"),"TOMAS VALLE","AV. Tupac Amaru Los Olivos","Av. TOMAS VALLE","EST. TOMAS VALLE","-12.006704", "-77.053920","http://senalalternativa.com/wp-content/gallery/estaciontomasvalle2012/rampa.jpg",true,true,String2Long("1"));
        ESTACION estacion_el_milagro=new ESTACION(String2Long("7"),"EL MILAGRO","AV. Tupac Amaru INDEPENDENCIA","Av. 18 DE ENERO","EST. EL MILAGRO","-12.012092", "-77.052763","https://lh5.googleusercontent.com/proxy/AYR8TEfRQK_L1eXPOyXMjLS9rCGyyNnhSzEPJA17A8IwTQdqDPVVtYvSFpg4t4Tdbi5sZp8uB4zDqZq_Cj8tI7UutliE4Mzo9LHFmngIZ6RQVwTP4IVJZ4PbihN7O00gqXvgVTs4-dewySj-93sJpm6tFyetNA=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_uni=new ESTACION(String2Long("8"),"UNI","AV. Tupac Amaru RIMAC","Av. EDUARDO DE HABICH","EST. HABICH","-12.024247","-77.048853","https://lh4.googleusercontent.com/proxy/fVcHHiDf0PhXfxOSVUL5ul33d5adPYObhQbbpzNANKcZrDcCxVAVb0F_7Sb72M6Tcn7w82R2QmpAbubDlxcNmNT6fWoTVgrUMEDxWFD4nGpegongr5o2_jzOBvGExI1ul0x4h6PsvP8ohoKPB0bfrJMcSXSyRg=w408-h408",true,true,String2Long("1"));
        ESTACION estacion_parque_del_trabajo=new ESTACION(String2Long("9"),"PARQUE DEL TRABAJO","AV. CAQUETA RIMAC","Av. FRANCISCO PIZARRO","EST. PARQUE DEL TRABAJO","-12.029335", "-77.044257","https://lh4.googleusercontent.com/proxy/PR0u1qcjcDAhVh4kf1dsTRLv2FFDbRRNIGrVPKlvqwItY6CkvmfNEJjQqVyfEj_dQabemr1Eiipe4A_sVngQufU2VF2AkLSZ22cvqDgYbNPz8pqyvm7Y_Caw8I7KbNaQN6PgAbGl5MPbwNMkDad4Ys73Le_m8g=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_caqueta=new ESTACION(String2Long("10"),"CAQUETA","AV. CAQUETA RIMAC","PANAMERICANA NORTE","EST. CAQUETA","-12.036706", "-77.043623","https://lh4.googleusercontent.com/proxy/lfRsvH2r1QwHcmn4xNc67fWGV6B7z9v4HgPMXVhBJJDIxmHXbTH9w-g3Dy-9dZ9dQ8GcgD-d9I1eVmDB0pva5PK18ig_wSlpmb2M1tYu-oFh_EYkCkW46v9rk4ZPZ_KDK9fxswxQDPRtwyN0RuI7pL8-z6moP2w=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_dos_de_mayo=new ESTACION(String2Long("11"),"DOS DE MAYO","AV. ALFONSO UGARTE CERCADO DE LIMA","OV. DOS DE MAYO","EST. DOS DE MAYO","-12.047227","-77.042707","https://lh6.googleusercontent.com/proxy/O5fPwV5XHob20WRdDU6PWF1KEty-G3GOh_21z7qiyTQxS0yXXF7ZBCWa2dCQYSpriwA02pqu7bqniKsmAAhjjIijuUmMZRQ7llwWgF22uxuKMGTFzHA8kA4hazIFzsS8L1iHgJf6DzPVF4TUIjBE4KuAwYlRwm0=w408-h256",true,true,String2Long("1"));
        ESTACION estacion_quilca=new ESTACION(String2Long("12"),"QUILCA","AV. ALFONSO UGARTE CERCADO DE LIMA","Av. QUILCA","EST. QUILCA","-12.051835", "-77.042283","https://lh3.googleusercontent.com/proxy/tqXP0eDtvwqQvd2hXO3IB4IdlK1wyRtNylYQaq-7tqSNEaECR7p_-fV_7aldVpi9Cyjkndswsg71sodbD4RLlPlFAcDKdlKK3K4rxsnPTzJgBpP8Jvk8wqmzGCz8Nx1SfVbKECDaLhgPU2xlDiBpB_-IRvZ6Uxg=w408-h229",true,true,String2Long("1"));
/*
        ESTACION estacion_izaguirr=new ESTACION(String2Long("13"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirrzz=new ESTACION(String2Long("14"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("15"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("16"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("17"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("18"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("19"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("20"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("21"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("22"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
        ESTACION estacion_izaguirre=new ESTACION(String2Long("23"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));

*/

        estacionRepositorio.insertOrUpdate(context,estacion_naranjal);
        estacionRepositorio.insertOrUpdate(context,estacion_izaguirre);
        estacionRepositorio.insertOrUpdate(context,estacion_pacifico);
        estacionRepositorio.insertOrUpdate(context,estacion_independencia);
        estacionRepositorio.insertOrUpdate(context,estacion_los_jazmines);
        estacionRepositorio.insertOrUpdate(context,estacion_tomas_valle);
        estacionRepositorio.insertOrUpdate(context,estacion_el_milagro);
        estacionRepositorio.insertOrUpdate(context,estacion_uni);
        estacionRepositorio.insertOrUpdate(context,estacion_parque_del_trabajo);
        estacionRepositorio.insertOrUpdate(context,estacion_caqueta);
        estacionRepositorio.insertOrUpdate(context,estacion_dos_de_mayo);
        estacionRepositorio.insertOrUpdate(context,estacion_quilca);






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
