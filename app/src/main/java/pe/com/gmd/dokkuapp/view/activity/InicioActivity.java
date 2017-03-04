package pe.com.gmd.dokkuapp.view.activity;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.PermissionChecker;
import pe.com.gmd.dokkuapp.util.Util;
import pe.com.gmd.dokkuapp.view.fragment.MapsHowToGetFragmen;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    Location mLocationGPS;
    Location mLocationCamera;

    ImageButton btnGps;
    AppCompatButton btnSearchPlace;
    AppCompatButton btnRouteOne;
    AppCompatButton btnRouteTwo;
    AppCompatButton btnRouteThree;
    Context mContext;

    public static float ZOOM_MAPA_DEFAULT = 14;
    public static double DISTANCIA_FUERA_CENTRO_RUTA = 0.12;

    private Toolbar toolbar;
    private DrawerLayout drawer;

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        translateStatusBar();
        loadingUI();
        buildGoogleApiClient();
        mContext = this;
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void loadingUI(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnSearchPlace = (AppCompatButton) findViewById(R.id.btnSearchPlace);
        btnGps = (ImageButton) findViewById(R.id.btn_gps);
        btnRouteOne= (AppCompatButton) findViewById(R.id.btnRouteOne);
        btnRouteTwo= (AppCompatButton) findViewById(R.id.btnRouteTwo);
        btnRouteThree= (AppCompatButton) findViewById(R.id.btnRouteThree);

        event();

    }

    private void event(){
        btnSearchPlace.setOnClickListener(this);
        btnGps.setOnClickListener(this);
        btnRouteOne.setOnClickListener(this);
        btnRouteTwo.setOnClickListener(this);
        btnRouteThree.setOnClickListener(this);
    }

//    @Override
//    public void onMapReady(GoogleMap map) {
//        LatLng sydney = new LatLng(-33.867, 151.206);
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            map.setMyLocationEnabled(true);
//        } else {
//            // Show rationale and request permission.
//        }
//        map.getUiSettings().setMyLocationButtonEnabled(true);
//        map.getUiSettings().setZoomControlsEnabled(true);
//
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
//
//        map.addMarker(new MarkerOptions()
//                .title("Sydney")
//                .snippet("The most populous city in Australia.")
//                .position(sydney));
//    }

    /***********************************Bloque de mapas*****************************/

    @Override
    protected void onStart() {
        super.onStart();
        try {
            mGoogleApiClient.connect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        try {

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {


        }

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {

                if (mMap != null) {
                    mMap.clear();
                }
                //Enviar ubicación de la Camara del Mapa.
                Location mLocationCamerIdle = new Location("");
                mLocationCamerIdle.setLatitude(mMap.getCameraPosition().target.latitude);
                mLocationCamerIdle.setLongitude(mMap.getCameraPosition().target.longitude);
                mLocationCamera = mLocationCamerIdle;

                try{
                    if(PermissionChecker.isGpsEnable(InicioActivity.this)) {
                        detectarDesplazamientoUbicacionGPS();}
                }catch(Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        mMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
            @Override
            public void onCameraMoveStarted(int i) {
            }
        });
    }


    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation!= null/* && mLocationGPS != null */) {
            changeMap(mLastLocation);
        } else
            try {
                LocationServices.FusedLocationApi.removeLocationUpdates(
                        mGoogleApiClient, this);
            } catch (Exception e) {
                e.printStackTrace();
            }

        try {
            LocationRequest mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(500);//0.5 Segundo
            mLocationRequest.setFastestInterval(100);//1.0 Segundo
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient, mLocationRequest, this);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /**Enviar ultima ubicacion*/
        if (mLocationGPS != null){
            mLocationGPS = mLastLocation;
        }

    }
    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }
    @Override
    public void onLocationChanged(Location location) {
        mLocationGPS = location;
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    private void changeMap(Location location) {
        // check if map is created successfully or not
        if (mMap != null) {
            mMap.getUiSettings().setZoomControlsEnabled(false);
            LatLng latLong;
            latLong = new LatLng(location.getLatitude(), location.getLongitude());
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLong).zoom(ZOOM_MAPA_DEFAULT)/*.tilt(70)*/.build();

            //mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));

            //startIntentService(location);
        } else {
             /*Toast.makeText(getApplicationContext(),

                    "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                    .show();*/
        }

    }
    /**Fin Bloque de mapas*/



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearchPlace:
//                if(searchPlace.isEnabled()){
                    openAutocompleteActivity();
//                    searchPlace.setEnabled(false);//Se bloquea hasta cambiar de panatalla
//                }
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_gps:
                if(mLocationCamera!=null && mLocationGPS!=null){
                    if(Util.distanceBetweenCoordinate(mLocationCamera.getLatitude(),mLocationCamera.getLongitude(),mLocationGPS.getLatitude(),mLocationGPS.getLongitude(),"K")> DISTANCIA_FUERA_CENTRO_RUTA){
                        btnGps.setImageDrawable(getResources().getDrawable(R.mipmap.gps));
                    }
                    changeMap(mLocationGPS);
                }else{
                    Toast.makeText(this, "No se encuentra la Ubicacion de GPS", Toast.LENGTH_SHORT).show();
                }


                Toast.makeText(this, "btn_gps", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRouteOne:
                Toast.makeText(this, "btnRouteOne", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRouteTwo:
                Toast.makeText(this, "btnRouteTwo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRouteThree:
                Toast.makeText(this, "btnRouteThree", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    /**Barra de Busqueda*/
    private void openAutocompleteActivity() {
        try {
            //Filtrado por Pais solo funciona con Play Services 9.6.1+
            AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().setTypeFilter(Place.TYPE_COUNTRY).setCountry("PE").build();
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).setFilter(typeFilter).build(this);
            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
        } catch (GooglePlayServicesRepairableException e) {
            GoogleApiAvailability.getInstance().getErrorDialog(this, e.getConnectionStatusCode(),
                    0 /* requestCode */).show();
//            btnSearchPlace.setEnabled(true);
        } catch (GooglePlayServicesNotAvailableException e) {
            String message = "Google Play Services is not available: " +
                    GoogleApiAvailability.getInstance().getErrorString(e.errorCode);
//            btnSearchPlace.setEnabled(true);
        }
    }
    /**Respuesta de la barra de busqueda*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(mContext, data);
                LatLng latLong;
                latLong = place.getLatLng();
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(latLong).zoom(ZOOM_MAPA_DEFAULT)/*.tilt(70)*/.build();

                /**Enviar ubicación de Lugar al Mapa*/
//                mFirstLocationPlace = new Location("");
//                mFirstLocationPlace.setLatitude(latLong.latitude);
//                mFirstLocationPlace.setLongitude(latLong.longitude);

                /**Enviar mi ubacacion*/
                mMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
            Status status = PlaceAutocomplete.getStatus(mContext, data);
        } else if (resultCode == RESULT_CANCELED) {
        }
//        searchPlace.setEnabled(true);
    }

    /**Cambiar Boton GPS*/
    public void detectarDesplazamientoUbicacionGPS(){
        try{
            if(mMap!=null) {
                LatLng centro = mMap.getCameraPosition().target;
                if (mLocationGPS != null) {
                    if (Util.distanceBetweenCoordinate(centro.latitude, centro.longitude,mLocationGPS.getLatitude(),mLocationGPS.getLongitude(),"K")> DISTANCIA_FUERA_CENTRO_RUTA) {
                        btnGps.setImageDrawable(getResources().getDrawable(R.mipmap.ubicacion_gris));
                    } else {
                        btnGps.setImageDrawable(getResources().getDrawable(R.mipmap.gps));
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private void translateStatusBar(){
        Window w = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else {
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.troncal) {
            startActivity(new Intent(this,DetalleActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.troncal:{
                startActivity(new Intent(this,DetalleActivity.class));
                return true;

            }
            case R.id.alimentador:{
                startActivity(new Intent(this,DetalleActivity.class));
                return true;

            }
        }

        if (id == R.id.troncal) {

        }
        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }  else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
