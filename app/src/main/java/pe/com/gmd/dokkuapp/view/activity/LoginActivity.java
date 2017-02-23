package pe.com.gmd.dokkuapp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import pe.com.gmd.dokkuapp.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText inputIniciarSesion;

    EditText inputContrasenia;

    TextInputLayout layoutContrasenia;



    TextView txtRecuperarClave;

    AppCompatButton btnIngreso;

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
    }

    private void ui() {
        inputIniciarSesion=(EditText)findViewById(R.id.input_iniciar_sesion);
        inputContrasenia=(EditText)findViewById(R.id.input_contrasenia);
        btnIngreso=(AppCompatButton)findViewById(R.id.btn_ingreso);
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
    public void onClick(View v) {
      if(validar()){
          startActivity(new Intent(context,MainActivity.class));
      }
    }
}
