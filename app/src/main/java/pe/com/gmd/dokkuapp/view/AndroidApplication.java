package pe.com.gmd.dokkuapp.view;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.support.multidex.MultiDex;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.ro.RetrofitService;
import pe.com.gmd.dokkuapp.util.Constants;


/**
 * Created by jmauriciog on 01/06/16.
 * Clase principal de la app
 */
public class AndroidApplication extends Application{

    private static AndroidApplication sApplication;
   // private Retrofit retrofit;

    private int notificationsCount = 0;
    private ArrayList<String> notificationList = new ArrayList<>();
    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        sApplication = this;
        //ViewTarget.setTagId(R.id.glide_tag);
      /*
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        */
      //  Utils.init(sApplication);
       // LogUtils.getBuilder().setTag("MIAPP").setLog2FileSwitch(true).create();
    }

    public static AndroidApplication getInstance() {
        return sApplication;
    }

    /** Retrofit Global methods **/






    /** Retrofit Global methods **/


    /** GCM Global Methods **/
    public int incrementAndGetNotificationCount(){
        notificationsCount++;
        return notificationsCount;
    }

    public ArrayList<String> getNotificationList() {
        return notificationList;
    }

    public void clearNotifications(){
        notificationsCount = 0;
        getNotificationManager().cancelAll();
        notificationList.clear();
    }

    public NotificationManager getNotificationManager() {
        if(notificationManager == null)
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        return notificationManager;
    }
    /** GCM Global Methods **/

}
