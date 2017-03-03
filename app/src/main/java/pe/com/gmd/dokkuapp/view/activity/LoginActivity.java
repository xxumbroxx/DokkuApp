package pe.com.gmd.dokkuapp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.AsyncListUtil;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.AppPreferences;
import pe.com.gmd.dokkuapp.util.SimularData;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText inputIniciarSesion;

    EditText inputContrasenia;

    TextInputLayout layoutContrasenia;


    CallbackManager callbackManager;
    TextView txtRecuperarClave;

    AppCompatButton btnIngreso;
    LoginButton loginButton;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        context=this;
        ui();
        btnIngreso.setOnClickListener(this);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email","public_profile");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                goMain(loginResult);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("Eroror",error.toString());
            }
        });

    }

    private void goMain(final LoginResult loginResult) {


        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                String token = loginResult.getAccessToken().getUserId();

                String mail="";
                try {
                     mail = object.getString("email");
                } catch (JSONException e) {

                    e.printStackTrace();
                }finally {

                }
                AppPreferences appPreferences=new AppPreferences(context);
                appPreferences.savePreference(appPreferences.USER_MAIL,mail);
                appPreferences.savePreference(appPreferences.USER_FB_TOKEN,token);
                startActivity(new Intent(context,SlideActivity.class));
                finish();
            }
        });
        Bundle parameters = new Bundle();
        //solicitando el campo email
        parameters.putString("fields","email,name,picture");

        request.setParameters(parameters);
        request.executeAsync();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void ui() {
        inputIniciarSesion=(EditText)findViewById(R.id.input_iniciar_sesion);
        inputContrasenia=(EditText)findViewById(R.id.input_contrasenia);
        btnIngreso=(AppCompatButton)findViewById(R.id.btn_ingreso);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        SimularData simularData=new SimularData();
        simularData.simular(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {

        super.onStop();
    }


    @Override
    protected void onDestroy() {
     super.onDestroy();
    }



    private boolean validar() {
        //validar
        if(inputIniciarSesion.getText().length()<=0){
            /*YoYo.with(Techniques.Tada)
                    .duration(700)
                    .playOn(findViewById(R.id.input_iniciar_sesion));*/

            inputIniciarSesion.requestFocus();
            return false;
        }
        if(inputContrasenia.getText().length()<=0){
            /*YoYo.with(Techniques.Tada)
                   .duration(700)
                    .playOn(findViewById(R.id.input_contrasenia));*/



            inputContrasenia.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        finish();

    }

    @Override
    public void onClick(View v) {
      if(validar()){
          //startActivity(new Intent(context,MainActivity.class));
          startActivity(new Intent(context,SlideActivity.class));
      }
    }
}
