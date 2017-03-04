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
//DESDE AQUI DE DEBE SEGUIR LLENANDO
        ESTACION estacion_dos_de_mayo=new ESTACION(String2Long("11"),"DOS DE MAYO","AV. ALFONSO UGARTE CERCADO DE LIMA","OV. DOS DE MAYO","EST. DOS DE MAYO","-12.047227","-77.042707","https://lh6.googleusercontent.com/proxy/O5fPwV5XHob20WRdDU6PWF1KEty-G3GOh_21z7qiyTQxS0yXXF7ZBCWa2dCQYSpriwA02pqu7bqniKsmAAhjjIijuUmMZRQ7llwWgF22uxuKMGTFzHA8kA4hazIFzsS8L1iHgJf6DzPVF4TUIjBE4KuAwYlRwm0=w408-h256",true,true,String2Long("1"));
        ESTACION estacion_quilca=new ESTACION(String2Long("12"),"QUILCA","AV. ALFONSO UGARTE CERCADO DE LIMA","Av. QUILCA","EST. QUILCA","-12.051835", "-77.042283","https://lh3.googleusercontent.com/proxy/tqXP0eDtvwqQvd2hXO3IB4IdlK1wyRtNylYQaq-7tqSNEaECR7p_-fV_7aldVpi9Cyjkndswsg71sodbD4RLlPlFAcDKdlKK3K4rxsnPTzJgBpP8Jvk8wqmzGCz8Nx1SfVbKECDaLhgPU2xlDiBpB_-IRvZ6Uxg=w408-h229",true,true,String2Long("1"));
        ESTACION estacion_españa=new ESTACION(String2Long("13"),"ESPAÑA","AV. ALFONSO UGARTE,CERCADO DE LIMA","Av. ESPAÑA","EST. ESPAÑA","-12.057185", "-77.041822","https://lh3.googleusercontent.com/-SyBTSe1zbWw/WJuziHqDAwI/AAAAAAAAtRk/XmLol1zKynQnkGOav5HghFVEStBTtRf9ACLIB/s634-k-no/",true,true,String2Long("1"));

        ESTACION estacion_tacna=new ESTACION(String2Long("14"),"TACNA","AV. EMANCIPACION,CERCADO DE LIMA","Av. TACNA","EST. TACNA","-12.046585", "-77.037274","https://lh4.googleusercontent.com/proxy/WgSvQjvpntOqmwv6GfM-845c9MFh8tND7BemxSOHZOXdQb04KaY6ZdDuV-y5c2_Ma3CrKjLVgwAAN4aKy2zyigpo4_tbVw9C2lOJV1DA4Kqs3BjnmI2WbcI9bVFcXmT3qpPSQFNSYorXwDifvP9E8OS9n_OvrA=w507-h200",true,true,String2Long("1"));
        ESTACION estacion_jiron_de_la_union=new ESTACION(String2Long("15"),"JIRON DE LA UNION","AV. EMANCIPACION CERCADO DE LIMA", "JR DE LA UNION","EST. JR DE LA UNION","-12.049223", "-77.032944","https://lh3.googleusercontent.com/-N7S8eYboa7c/VHPY84HjU0I/AAAAAAAABl0/2wwF8NOE0_UV7jTMGF8Q1bEZUoPo2ypzQCJkC/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_colmena=new ESTACION(String2Long("16"),"COLMENA","AV. NICOLAS DE PIEROLA ,CERCADO DE LIMA","JR LAMPA","EST. COLMENA","-12.052182", "-77.032753","https://lh6.googleusercontent.com/proxy/HcKv0VIH9bxA0yQ7_QOnQENwpRnl48dVIfebTcVfsy4gops97-xG9wpICZmVEtMOBQ-pcSNNaBw--dqM12NTMGqI4-dqQecewEQ3V5k5GE4yixGXdrdOUILp9PhMwQbBNCzIk_qElTfXA11hYrdCsaYjdePC5g=w408-h228",true,true,String2Long("1"));

        ESTACION estacion_central=new ESTACION(String2Long("17"),"CENTRAL","AV. PASEO DE LA REPUBLICA, CERCADO DE LIMA","Av. BOLIVIA","EST. CENTRAL","-12.057736", "-77.035982","https://lh5.googleusercontent.com/proxy/Yq0gWYctL2Px7AilsAUTNhEwh1IKm42n6M8_RKJ7ClaQ5TG0TqyR1LPmzo6YoSIzRDT0viGjK1ftt0blOUGVk3uwJq1CdajzihYXSV-Zm7fhWqdiuCViG32VHtPlJ14uTni73G-qo4bWhdUOBt_kf5s4q0tDvw=w408-h306",true,true,String2Long("1"));

        ESTACION estacion_estadio_nacional=new ESTACION(String2Long("18"),"ESTADIO NACIONAL","AV. PASEO DE LA REPUBLICA, CERCADO DE LIMA","JR SEBASTIAN BARRANCA","EST. ESTADIO NACIONAL","-11.989815", "-77.057035","https://lh3.googleusercontent.com/-X8qNoFve5uc/V9Ltf1VuMfI/AAAAAAAAGwU/KVaHv6fKQ440x88ctuoRrFoyZahVqou5QCJkC/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_mexico=new ESTACION(String2Long("19"),"MEXICO","AV. PASEO DE LA REPUBLICA,LA VICTORIA","Av. MEXICO","EST. MEXICO","-12.076919", "-77.028870","https://lh3.googleusercontent.com/-wUbqPUxpHfI/V6YVyksSpTI/AAAAAAAAm8A/oY4mdrQbleENb0dxec3XIAAMYG5qBABLwCJkC/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_canada=new ESTACION(String2Long("20"),"CANADA","\"AV. PASEO DE LA REPUBLICA","Av. CANADA","EST. CARLOS CANADA","-12.082368", "-77.026632","https://lh4.googleusercontent.com/-XDyGIpyauzA/WKOEUcXqRaI/AAAAAAAAC04/pm8txe5NoMY3KCsIA0IpG1KsCdmLRlS8QCLIB/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_javier_prado=new ESTACION(String2Long("21"),"JAVIER PRADO","AV. PASEO DE LA REPUBLICA","Av. JAVIER PRADO","EST. JAVIER PRADO","-12.089260", "-77.023568","https://lh4.googleusercontent.com/proxy/L4vzyO5EnEANzJfD4rdIEnA29Xb2T-xNX3ySAGJr_718CutqnkwefUcMDoKFTQhdwAWSJexFOZantzJybDuejA8Om1QCVk0lksxLkjDPRidF6kjsDpSTjyVtmQL6YeNr8rCqu-uCLTkHgKCaWdtSKQslpO-tag=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_carnaval_moreyra=new ESTACION(String2Long("22"),"CARNAVAL Y MOREYRA","AV. PASEO DE LA REPUBLICA","Av. CARNAVAL Y MOREYRA","EST. CARNAVL Y MOREYRA","-12.096943","-77.025104","https://lh3.googleusercontent.com/proxy/iYlNVeusNUa0MUXp60Qqm6URt5_BdkTBZiPPuvGDRnyBzoOUeE1Ksf6-o9vG8GhVZ_x10KMe6CHSJ2Kli746pCL6bQINex_uB5aa_Y93m-Y8Tw3X2MbzzXVd8ds7As9CU0WnncsQ7NFYnsr_HI4lebYGAioY04Y=w408-h228",true,true,String2Long("1"));
        ESTACION estacion_aramburu=new ESTACION(String2Long("23"),"ARAMBURU","AV. PASEO DE LA REPUBLICA","Av. ARAMBURU","EST. ARAMBURU","-12.102702", "-77.027334","https://lh3.googleusercontent.com/proxy/XR9thCfbmcGz8nP6J9-UZShCpI241SWutVyBSc4Ft155zBh5cRV22hSa7B-nj9uLk0Y3iHQ1U1c7C3v6vsADuEG-G_56Soag98VLKQI-1ai41T3jlN8TB88F-izE7ksVBPPhBQBRPDCQugEInSzO6LJwgHKZlw=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_domingo_orue=new ESTACION(String2Long("24"),"DOMINGO ORUE","AV. PASEO DE LA REPUBLICA","Av.DOMINGO ORUE","EST. DOMINGO ORUE","-12.108525", "-77.026431","https://lh4.googleusercontent.com/-zngiUfdn1RM/V65WraU8DHI/AAAAAAAAEYk/8S6f6CMKrH0gWIF0czVfkraYbixCdd2OQCJkC/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_angamos=new ESTACION(String2Long("25"),"ANGAMOS","AV. PASEO DE LA REPUBLICA","Av. ANGAMOS","EST. ANGAMOS","-12.113328", "-77.025970","https://www.google.com.pe/maps/place/Estaci%C3%B3n+Angamos/@-12.113485,-77.0259832,3a,75y,90t/data=!3m8!1e2!3m6!1s-p-qdcsCsy70%2FWE8aGS0y40I%2FAAAAAAAClNE%2FgLPkl7ODYLkRlxRSTPuMYpazsCVWEljVwCLIB!2e4!3e12!6s%2F%2Flh6.googleusercontent.com%2F-p-qdcsCsy70%2FWE8aGS0y40I%2FAAAAAAAClNE%2FgLPkl7ODYLkRlxRSTPuMYpazsCVWEljVwCLIB%2Fs156-k-no%2F!7i3264!8i2448!4m5!3m4!1s0x9105c8116111d40f:0xac43ee237d1bd894!8m2!3d-12.1132935!4d-77.0259679!6m1!1e1",true,true,String2Long("1"));
        ESTACION estacion_ricardo_palma=new ESTACION(String2Long("26"),"RICARDO PALMA","AV. PASEO DE LA REPUBLICA","Av.RICARDO PALMA","EST. RICARDO PALMA","-12.119014", "-77.025899","https://www.google.com.pe/maps/place/Estaci%C3%B3n+Ricardo+Palma/@-12.1191347,-77.0258697,3a,75y,90t/data=!3m8!1e2!3m6!1s-PflveqSkQOA%2FWB--wLPnf5I%2FAAAAAAABlIs%2FLKvJM8VIC4IWweph5NXzoKfOAIEPMPkdACLIB!2e4!3e12!6s%2F%2Flh4.googleusercontent.com%2F-PflveqSkQOA%2FWB--wLPnf5I%2FAAAAAAABlIs%2FLKvJM8VIC4IWweph5NXzoKfOAIEPMPkdACLIB%2Fs156-k-no%2F!7i4618!8i3464!4m12!1m6!3m5!1s0x9105c8116111d40f:0xac43ee237d1bd894!2sEstaci%C3%B3n+Angamos!8m2!3d-12.1132935!4d-77.0259679!3m4!1s0x9105c81a741e5b71:0x28bc88e9df18f11d!8m2!3d-12.118979!4d-77.0258948!6m1!1e1",true,true,String2Long("1"));
        ESTACION estacion_benavides=new ESTACION(String2Long("27"),"BENAVIDES","AV. PASEO DE LA REPUBLICA","Av. BENAVIDES","EST. BENAVIDES","-12.125073", "-77.024219","https://lh3.googleusercontent.com/proxy/lxMtHnmMCoFdmDTxVmQIE_e59yt6OCc7KFmwOzNKpCu8zlLelYqd9lD4klmIu_-57Bjv-3GrvXtSdMH361eg-PioPpalqcuW5lmWGBo7GtVzohLpYxv99el7069Mou4g6xFp7sRAsDy-uX5ektk3O27cTWAXxw=w408-h305",true,true,String2Long("1"));
        ESTACION estacion_28_de_julio=new ESTACION(String2Long("28"),"28 DE JULIO","AV. PASEO DE LA REPUBLICA","Av. 28 DE JULIO","EST. 28 DE JULIO","-12.129639", "-77.022768","https://lh6.googleusercontent.com/proxy/TCc_l5-jkWizC3IJy9zCP6ILUBagLP6fvzViLCyEZly0gZgJSaONKnJxuOfIDFYI8gDzWAUHz8vluY0_tfUBiV4de0tFinmRui8dq8FrhcFZzuvZhCOV7SzAFJK_xhFR_UgQkTzJL1nMQHsrcNORjHEWOKQrRA=w408-h271",true,true,String2Long("1"));
        ESTACION estacion_plaza_de_flores=new ESTACION(String2Long("29"),"PLAZA DE FLORES","AV. PASEO DE LA REPUBLICA","Av. REPUBLICA DE PANAMA","EST. PLAZA DE LAS FLORES","-12.135682", "-77.018652","https://lh3.googleusercontent.com/--Xm6x89X75I/WGxs_jYmGNI/AAAAAAAAN4c/5hpY_krTqOwdx25MQsXbnwN_dQbNDkrLACLIB/s408-k-no/",true,true,String2Long("1"));
        ESTACION estacion_balta=new ESTACION(String2Long("30"),"BALTA","AV. BRT METROLIANO","Av. BALTA","EST. BALTA","-12.141380", "-77.017773","https://lh6.googleusercontent.com/-4eiox4qYa30/WFhLgUGnSdI/AAAAAAAAFkg/nT_2mPEP2Qcn2g9A4K-HksBeROUytruKgCLIB/s544-k-no/",true,true,String2Long("1"));
        ESTACION estacion_boulevard=new ESTACION(String2Long("31"),"BOULEVARD","CLL PAZOS","","EST. BOULEVARD","-12.148103", "-77.020032","https://lh6.googleusercontent.com/proxy/afmwwTJwh5jo56FMdYQwLnQf87We9TjSNRFZKECmaM9DtwB_X5ys5gCJp7GX_qUjH-RAV24svV0YjDxX6r0xiOFyzQlbwR62SJqlMIPXR3bzCNrmQrAFBPLxAGUMV5njSfp621NrtAJRy6BsOQSVrtmqva-TkX4=w507-h200",true,true,String2Long("1"));
        ESTACION estacion_huaylas_chorrillos=new ESTACION(String2Long("32"),"HUAYLAS CHORRILLOS","PAN. SUR","VIA DEL METROPOLITANO","EST. HUAYLAS CHORRILLOS","-12.152772", "-77.019735","https://www.google.com.pe/maps/place/Haylas+Chorrillos/@-12.1527079,-77.0196178,3a,75y,90t/data=!3m8!1e2!3m6!1zaHR0cDovL2NkZS4zLmVsY29tZXJjaW8ucGUvaW1hLzAvMS8wLzEvNy8xMDE3MDc5LmpwZw!2e7!3e27!6s%2F%2Flh5.googleusercontent.com%2Fproxy%2FJYmIR0w3VduM1jaAhV10lOAarB-dCXEXy9dZbpz6k_zM0idMw0OMwWkTs6HPKQ7jCPnP6zdWY0Lo2l1hp0evVY-2RYpcpJ1AU7JVL8Y8KmwxNfg3GmHgoOXEdl5Nl8_jqMjmkIj5zUxnZxWFOZ001wZ-a8avxcE%3Dw203-h113!7i619!8i347!4m5!3m4!1s0x9105b78d2fd8455d:0x576f0f934f92a8fe!8m2!3d-12.152761!4d-77.0197338!6m1!1e1",true,true,String2Long("1"));
        ESTACION estacion_escuela_militar=new ESTACION(String2Long("33"),"ESCUELA MILITAR","AV. ESCUELA MILITAR","CIRCULO MILITAR","EST.ESCUELA MILITAR","-12.159427", "-77.018912","https://geo3.ggpht.com/cbk?panoid=ZUBxy8QpKt0kvSWHD5wyUg&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=1.3879434&pitch=0&thumbfov=100",true,true,String2Long("1"));
        ESTACION estacion_teran=new ESTACION(String2Long("34"),"FERNANDO TERAN","AV. PASEO DE LA REPUBLICA","Av. COSAC I","EST. TERAN","-12.168335","-77.018792","https://www.google.com.pe/maps/place/Estaci%C3%B3n+Teran/@-12.1683139,-77.0187709,3a,75y,90t/data=!3m8!1e2!3m6!1shttp:%2F%2Flh5.ggpht.com%2Fa21vDUGfS3sO3JmKJtptC7uYWVWXcuvTrXblTWGuz99H3h_Q5GG1vEOZR6oeoaxKxJFwZJUCq45mGVsyRVf5!2e7!3e27!6s%2F%2Flh3.googleusercontent.com%2Fproxy%2FIU1eJ4Qyu28FYkA9m-491tLtY0_LlcjDXApYmc31CDmWfPy9ZcYalJZ890_T52m8HUsfM9V4So3O1sqjMqUgSwOzwxLSksbl-vZNJ0AmzZZhZWPVcf2QyUhxu7bQVWBXnLhk7n2YaASUCLLt4BS-27ej-VbSvw%3Dw203-h152!7i512!8i384!4m5!3m4!1s0x9105b7847cebc927:0x89fbd448e7606cfe!8m2!3d-12.1683253!4d-77.018795!6m1!1e1",true,true,String2Long("1"));
        ESTACION estacion_rosario_de_villa=new ESTACION(String2Long("35"),"ROSARIO DE VILLA","Paseo De La Republica",", Distrito de Lima 15064","EST. ROSARIO DE VILLA","-12.173060", "-77.015089","http://img.uterodemarita.com.s3.amazonaws.com/wp-content/uploads/2014/08/park-and-ride.png",true,true,String2Long("1"));
        ESTACION estacion_matellini=new ESTACION(String2Long("36"),"MATELLINI","AV. PASEO DE LA REPUBLICA","Av. PROL ARIOSTO MATELLINI","EST. CARLOS IZAGUIRRE","-12.179332", "-77.009622","https://lh4.googleusercontent.com/proxy/Q0hqyjtCszgHxaLbfqvDt_lC00kCxbVhssbv0k5EL6Ev6-oMtSayQnXqs8YrhSimN2gmuoJoy96RvNtCiywa8pjhGi7o4safO4UEn2B7LDFRkn9Fbd3QVOk00bQwbBk6NeRMOK5Y6N3me7_n0xxntIarFYW4Wg=w408-h277",true,true,String2Long("1"));
        ESTACION estacion_explotacion=new ESTACION(String2Long("37"),"EXPLOTACION","AV. NO HAY VIDA","TODO ES AMANECIDA","EST. ESCLAVITUD","-12.048514", "-77.031127","https://www.google.com.pe/maps/place/GMD+Corporaci%C3%B3n+Gra%C3%B1a+y+Montero/@-12.048538,-77.0311503,3a,75y,90t/data=!3m8!1e2!3m6!1s-KjfOLsR_npM%2FV0Rm5DnRsoI%2FAAAAAAAAdKw%2F2CUjGw9k1JEwy3vD3hqFajGhSAMFEtOIQCLIB!2e4!3e12!6s%2F%2Flh6.googleusercontent.com%2F-KjfOLsR_npM%2FV0Rm5DnRsoI%2FAAAAAAAAdKw%2F2CUjGw9k1JEwy3vD3hqFajGhSAMFEtOIQCLIB%2Fs114-k-no%2F!7i1600!8i1200!4m5!3m4!1s0x0:0x209d37918c657e77!8m2!3d-12.048506!4d-77.031124!6m1!1e1",true,true,String2Long("1"));
        ///ESTACION estacion_izaguirre=new ESTACION(String2Long("38"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
       /// ESTACION estacion_izaguirre=new ESTACION(String2Long("39"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
       // ESTACION estacion_izaguirre=new ESTACION(String2Long("40"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));
      ///  ESTACION estacion_izaguirre=new ESTACION(String2Long("41"),"IZAGUIRRE","AV. Tupac Amaru Los Olivos","Av. iZAGUIRRE","EST. CARLOS IZAGUIRRE","-11.989815", "-77.057035","0",true,true,String2Long("1"));



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
        estacionRepositorio.insertOrUpdate(context,estacion_españa);
        estacionRepositorio.insertOrUpdate(context,estacion_tacna);
        estacionRepositorio.insertOrUpdate(context,estacion_jiron_de_la_union);
        estacionRepositorio.insertOrUpdate(context,estacion_colmena);
        estacionRepositorio.insertOrUpdate(context,estacion_central);
        estacionRepositorio.insertOrUpdate(context,estacion_estadio_nacional);
        estacionRepositorio.insertOrUpdate(context,estacion_mexico);
        estacionRepositorio.insertOrUpdate(context,estacion_canada);
        estacionRepositorio.insertOrUpdate(context,estacion_javier_prado);
        estacionRepositorio.insertOrUpdate(context,estacion_carnaval_moreyra);
        estacionRepositorio.insertOrUpdate(context,estacion_aramburu);
        estacionRepositorio.insertOrUpdate(context,estacion_domingo_orue);
        estacionRepositorio.insertOrUpdate(context,estacion_angamos);
        estacionRepositorio.insertOrUpdate(context,estacion_ricardo_palma);
        estacionRepositorio.insertOrUpdate(context,estacion_benavides);
        estacionRepositorio.insertOrUpdate(context,estacion_28_de_julio);
        estacionRepositorio.insertOrUpdate(context,estacion_plaza_de_flores);
        estacionRepositorio.insertOrUpdate(context,estacion_balta);
        estacionRepositorio.insertOrUpdate(context,estacion_boulevard);
        estacionRepositorio.insertOrUpdate(context,estacion_huaylas_chorrillos);
        estacionRepositorio.insertOrUpdate(context,estacion_escuela_militar);
        estacionRepositorio.insertOrUpdate(context,estacion_teran);
        estacionRepositorio.insertOrUpdate(context,estacion_rosario_de_villa);
        estacionRepositorio.insertOrUpdate(context,estacion_matellini);
        estacionRepositorio.insertOrUpdate(context,estacion_explotacion);

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
