package pe.com.gmd.dokkuapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.Profile;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.AppPreferences;
import pe.com.gmd.dokkuapp.util.CircleTransform;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Bind(R.id.nav_view)
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = getLayoutInflater().inflate(R.layout.nav_header_inicio, navigationView, false);
        navigationView.addHeaderView(headerView);

        ImageView imgUsuario= (ImageView) headerView.findViewById(R.id.img_usuario);
        TextView nombreUsuario= (TextView) headerView.findViewById(R.id.usuario);
        TextView mailUsuario= (TextView)headerView.findViewById(R.id.mail_usuario);
        imgUsuario.setOnClickListener(this);
        mailUsuario.setOnClickListener(this);
        nombreUsuario.setOnClickListener(this);

        Profile profileDefault = Profile.getCurrentProfile();

        if (profileDefault != null){
            nombreUsuario.setText(profileDefault.getName());

            Picasso.with(this).load(profileDefault.getProfilePictureUri(100, 100)).transform(new CircleTransform()).into(imgUsuario);
            AppPreferences preference = AppPreferences.getInstance(this);
            mailUsuario.setText(preference._EmailLogin());
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.troncal) {
            startActivity(new Intent(this, DetalleActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.troncal: {
                Intent i=new Intent(this, DetalleActivity.class);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(i);
                return true;

            }
            case R.id.alimentador: {
                Intent i=new Intent(this, DetalleActivity.class);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(i);
                return true;

            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);





        return true;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,UsuarioActivity.class));
    }
}
