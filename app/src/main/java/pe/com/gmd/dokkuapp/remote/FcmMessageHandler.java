package pe.com.gmd.dokkuapp.remote;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by jmauriciog on 15/12/2015.
*/

    public class FcmMessageHandler extends FirebaseMessagingService {

    public static final int MESSAGE_NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage message) {

    }

}
