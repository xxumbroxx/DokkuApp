package pe.com.gmd.dokkuapp.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.AppPreferences;
import pe.com.gmd.dokkuapp.util.CircleTransform;

public class UsuarioActivity extends AppCompatActivity {

    @Bind(R.id.btn_cambiar_foto)
    ImageView btnCambiarFoto;
    @Bind(R.id.btn_edir_user)
    ImageView btnEdirUser;
    @Bind(R.id.img_user)
    ImageView imgUser;
    @Bind(R.id.txt_usuario)
    TextView txtUsuario;
    @Bind(R.id.txt_mail)
    TextView txtMail;
    @Bind(R.id.ly_notificaciones)
    LinearLayout lyNotificaciones;
    @Bind(R.id.ly_idioma)
    LinearLayout lyIdioma;
    @Bind(R.id.ly_ubicaciones)
    LinearLayout lyUbicaciones;
    @Bind(R.id.ly_denuncias)
    LinearLayout lyDenuncias;
    @Bind(R.id.ly_cerrar_session)
    LinearLayout lyCerrarSession;


    AlertDialog alert = null;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        ButterKnife.bind(this);
        context=this;
        Profile profileDefault = Profile.getCurrentProfile();

        if (profileDefault != null){
            txtUsuario.setText(profileDefault.getName());

            Picasso.with(this).load(profileDefault.getProfilePictureUri(100, 100)).transform(new CircleTransform()).into(imgUser);
            AppPreferences preference = AppPreferences.getInstance(this);
            txtMail.setText(preference._EmailLogin());
            }

    }


    private void AlertClose() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea cerrar sesión?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {

                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {

                        LoginManager.getInstance().logOut();
                        startActivity(new Intent(context, LoginActivity.class));
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();

                    }
                });
        alert = builder.create();
        alert.show();
    }
}
