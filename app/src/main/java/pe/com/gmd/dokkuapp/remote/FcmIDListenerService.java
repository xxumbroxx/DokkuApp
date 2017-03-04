package pe.com.gmd.dokkuapp.remote;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FcmIDListenerService extends FirebaseInstanceIdService {



    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN FCM",refreshedToken);

    }
}