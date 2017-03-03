package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MyDBGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        //pe.com.gym.concar.sos
        Schema schema = new Schema(4, "pe.com.gmd.dokkuapp.domain.orm");
        schema.enableKeepSectionsByDefault();
        //schema.
        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "/app/src/main/java/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addTables(final Schema schema) {

     /*   Entity user = addUser(schema);


        Entity proyecto = addProyecto(schema);
        Entity ambientes = addAmbientes(schema);
        Entity termometros = addTermometros(schema);
        Entity humedad = addHumedad(schema);
        Entity ph = addPH(schema);




        Property pisoId = ambientes.addLongProperty("pisoId").notNull().getProperty();
        proyecto.addToMany(ambientes, pisoId, "fk_ambientes");



        Property ambientesId = termometros.addLongProperty("ambienteId").notNull().getProperty();
        ambientes.addToMany(termometros, ambientesId, "fk_temperatura");

        Property ambientesId2 = humedad.addLongProperty("ambienteId").notNull().getProperty();
        ambientes.addToMany(humedad, ambientesId2, "fk_humedad");

        Property ambientesId3 = ph.addLongProperty("ambienteId").notNull().getProperty();
        ambientes.addToMany(ph, ambientesId2, "fk_ph");



      /*
//
// Añadir customerId clave externa a la entidad orden
Property customerId = order.addLongProperty("customerId").notNull().getProperty();
// Establecer una relación a muchos a la entidad órdenes de la entidad de cliente
 customer.addToMany(order, customerId);
// Opcionales: nombre de la relación y especificar el orden de los elementos referenciados
customerToOrders.setName("orders");
customerToOrders.orderAsc(orderDate);

*/
        Entity usuario=addUser(schema);

        Entity tipo=addTipo(schema);
        Entity tarjeta=addTarjetas(schema);
        Entity estacion=addEstacion(schema);
        Entity ruta=addRuta(schema);
        Entity detalle=addDetalle(schema);

        Entity notific=addNotificacion(schema);


        Property tarjeta_id = tarjeta.addLongProperty("tipo_id").notNull().getProperty();
        tipo.addToMany(tarjeta, tarjeta_id, "fk_tarjetas");

        Property estacion_id = estacion.addLongProperty("tipo_id").notNull().getProperty();
        tipo.addToMany(estacion, estacion_id, "fk_estaciones");

        Property ruta_id = ruta.addLongProperty("tipo_id").notNull().getProperty();
        tipo.addToMany(ruta, ruta_id, "fk_rutas");


        Property ruta_2_id = detalle.addLongProperty("ruta_id").notNull().getProperty();
        Property estacion_id1 = detalle.addLongProperty("estacion_id").notNull().getProperty();

        ruta.addToMany(detalle,ruta_2_id,"fk_estaciones");
        estacion.addToMany(detalle,estacion_id1,"fk_embarque");

    }

    private static Entity addUser(final Schema schema) {
        Entity user = schema.addEntity("USUARIO");
        user.addIdProperty().primaryKey().autoincrement();
        user.addStringProperty("IdUsuario").notNull();
        user.addStringProperty("Usuario");
        user.addStringProperty("Contrasena");
        user.addStringProperty("Dni");
        user.addStringProperty("Nombres");
        user.addStringProperty("Celular");
        user.addStringProperty("email");


        return user;
    }

    private static Entity addTipo(final Schema schema) { //METROPOLITANO //LINEA 1 //ALIMENTADORES
        Entity tipo = schema.addEntity("TIPO");
        tipo.addIdProperty().primaryKey().autoincrement();
        tipo.addStringProperty("IdTipo").notNull();
        tipo.addStringProperty("Color");
        tipo.addStringProperty("Icono");
        tipo.addStringProperty("Nombre");
        tipo.addStringProperty("Texto");
        tipo.addStringProperty("TipoPago");
       return tipo;
    }
    private static Entity addTarjetas(final Schema schema) { //METROPOLITANO //LINEA 1 //ALIMENTADORES
        Entity tarjeta = schema.addEntity("TARJETA");
        tarjeta.addIdProperty().primaryKey().autoincrement();
        tarjeta.addStringProperty("IdTipo").notNull();
        tarjeta.addStringProperty("Color");
        tarjeta.addStringProperty("Nombre");
        tarjeta.addStringProperty("Descripcion");
        tarjeta.addStringProperty("Requisitos");
        tarjeta.addStringProperty("PrecioTarjeta");
        tarjeta.addStringProperty("PrecioViaje");
        tarjeta.addStringProperty("Dias");//LMMJVSD   *****--
        return tarjeta;
    }


    private static  Entity addEstacion(final  Schema schema){
        Entity estacion = schema.addEntity("ESTACION");
        estacion.addIdProperty().primaryKey().autoincrement();
        estacion.addStringProperty("Nombre");
        estacion.addStringProperty("Direcion");
        estacion.addStringProperty("Descripcion");
        estacion.addStringProperty("Texto");
        estacion.addStringProperty("Latitud");
        estacion.addStringProperty("Longitud");
        estacion.addStringProperty("Foto");
        estacion.addBooleanProperty("modulo"); //MODULO DE ATENCION
        estacion.addBooleanProperty("Estado");
        return  estacion;
    }

    private static  Entity addRuta(final  Schema schema){
        Entity estacion = schema.addEntity("RUTA");
        estacion.addIdProperty().primaryKey().autoincrement();
        estacion.addStringProperty("Nombre");
        estacion.addStringProperty("Direccion");
        estacion.addStringProperty("Origen");
        estacion.addStringProperty("Destino");
        estacion.addStringProperty("Texto");
        estacion.addStringProperty("Dias");//LMMJVSD   *****--
        estacion.addIntProperty("DesdeMA");
        estacion.addIntProperty("HastaMA");
        estacion.addIntProperty("DesdeTA");
        estacion.addIntProperty("HastaTA");
        estacion.addIntProperty("Frecuencia");//MINUTOS
        estacion.addBooleanProperty("TiempoAproximado"); //MINUTOS
        estacion.addBooleanProperty("Estado"); //ACTIVO
        return  estacion;
    }

    private static  Entity addDetalle(final  Schema schema){
        Entity detalle = schema.addEntity("DETALLE_RUTA");
        detalle.addIdProperty().primaryKey().autoincrement();
        detalle.addStringProperty("Embarque");
        detalle.addStringProperty("Orden");
    return  detalle;}


     private static Entity addNotificacion(final Schema schema) {
            Entity noti = schema.addEntity("NOTIFICACION");
            noti.addIdProperty().primaryKey().autoincrement();

            noti.addStringProperty("Titulo");
            noti.addStringProperty("Tipo");
            noti.addStringProperty("Descripcion");
            noti.addBooleanProperty("Estado");

            return noti;
        }



}
