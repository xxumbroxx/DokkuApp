package pe.com.gmd.dokkuapp.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.security.Principal;
import java.util.Timer;
import java.util.TimerTask;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.AppPreferences;

public class SplashActivity extends AppCompatActivity {
    private TimerTask splash_task_parametric;
    private TimerTask splash_task;
    private Timer timer;
    private Context ctx;
    private ProgressDialog dialog;


    Display display;
    int width;
    float widthFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        widthFloat = (float)width;

        ctx = this;
        timer = new Timer("SplashTimer",true);

        /** En caso sólo sea necesario actualizar token de notificación **/
        splash_task = new TimerTask() {
            @Override
            public void run() {
                goToLogin();
            }
        };

        timer.schedule(splash_task, 4500);


    }

    @Override
    public void onBackPressed() {
        // block back press button
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(splash_task != null)
            splash_task.cancel();
        if(splash_task_parametric != null)
            splash_task_parametric.cancel();

    }

    private void goToLogin(){
        Intent i;
        if(AppPreferences.getInstance(this).token()==null){
           i = new Intent(SplashActivity.this , LoginActivity.class);
        }else{
            i = new Intent(SplashActivity.this , InicioActivity.class);
        }

        startActivity(i);
        finish();
    }




}
