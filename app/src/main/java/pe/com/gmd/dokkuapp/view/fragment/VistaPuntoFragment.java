package pe.com.gmd.dokkuapp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.util.Constants;

/**
 * Created by glarab on 3/03/2017.
 */

public class VistaPuntoFragment  extends Fragment implements OnMapReadyCallback {


    Double latitud;
    Double longitud;

    GoogleMap map;



    GoogleApiClient.Builder builder;
    GoogleApiClient apiClient;

    @Bind(R.id.mapView)
    MapView mapView;

    //public static Fragment newInstance(LatLng punto, String idOcurrencia) {
    public static Fragment newInstance(Double latitud,Double longitud) {
        Fragment fragment = new VistaPuntoFragment();
        Bundle args = new Bundle();
        args.putDouble("latitude",latitud);
        args.putDouble("longitude", longitud);

        /* Ruben - Fin */
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle argumentos = getArguments();
            latitud = argumentos.getDouble("latitude");
            longitud = argumentos.getDouble("longitude");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle_mapa, container, false);
        ButterKnife.bind(this, v);



        if (latitud == null || longitud == null) {
            latitud = 0.2;
            longitud = 0.3;
        }

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setAllGesturesEnabled(false);

        pintarPosicionGPS();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    public void moverUbicacionActual() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitud, longitud))
                .zoom(Constants.VALUES.ZOOM_MAPA_DEFAULT)
                .build();
        map.animateCamera(CameraUpdateFactory.zoomIn());
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 200, null);
        // pintarPosicionGPS();
    }

    private void pintarPosicionGPS() {
        LatLng position = new LatLng(latitud, longitud);
        map.addMarker(new MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        moverUbicacionActual();
    }

}