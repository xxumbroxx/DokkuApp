package pe.com.gmd.dokkuapp.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import pe.com.gmd.dokkuapp.R;

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
        ImageView imgView=(ImageView) findViewById(R.id.imageView);
//        Ion.with(imgView)
//                //.error(R.drawable.default_image)
//                .animateGif(AnimateGifMode.ANIMATE)
//                .load("android.resource://" + getPackageName() + "/" + R.drawable.splash)
//                .withBitmapInfo();

        ctx = this;
        timer = new Timer("SplashTimer",true);


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





}
