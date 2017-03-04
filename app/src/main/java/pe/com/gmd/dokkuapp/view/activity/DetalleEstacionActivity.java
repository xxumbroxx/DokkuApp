package pe.com.gmd.dokkuapp.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.service.dao.impl.EstacionRepositorio;
import pe.com.gmd.dokkuapp.view.fragment.VistaPuntoFragment;

public class DetalleEstacionActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.txt_atencion)
    TextView txtAtencion;
    @Bind(R.id.txt_tarjetas)
    TextView txtTarjetas;
    @Bind(R.id.txt_horario)
    TextView txtHorario;
    @Bind(R.id.fragment)
    FrameLayout fragment;
    @Bind(R.id.txt_direccion)
    TextView txtDireccion;
    @Bind(R.id.txt_texto)
    TextView txtTexto;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.fondo)
    ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estacion);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EstacionRepositorio estacionRepositorio = new EstacionRepositorio();
        Long id = getIntent().getLongExtra("id", 0);
        ESTACION estacion = estacionRepositorio.getForId(this, id);
        toolbar.setTitle(estacion.getNombre());
        if (estacion.getModulo()) {
            txtAtencion.setText("SI");
            txtTarjetas.setText("SI");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        double latitud = Double.parseDouble(estacion.getLatitud());
        double longitud = Double.parseDouble(estacion.getLongitud());
        txtDireccion.setText(estacion.getDirecion());
        txtTexto.setText(estacion.getTexto());

        Picasso.with(this).load(estacion.getFoto()).into(fondo);
        /////////

        FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment fragment = FragmentMapaDetalle.newInstance(new LatLng(latiud, longitud), ocurrencia.getResult().getIdOcurrencia());
        Fragment fragment = VistaPuntoFragment.newInstance(latitud, longitud);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();

    }
}
