package pe.com.gmd.dokkuapp.view.fragment;

/**
 * Created by glarab on 2/03/2017.
 */

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.service.dao.Repositorio;
import pe.com.gmd.dokkuapp.service.dao.impl.TIpoRepositoeio;


public class FirstMapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;

    List<Point> listaPuntos;
    @Bind(R.id.mapView)
    MapView mapa;

    @Bind(R.id.photoEstacionD)
    ImageView photoEstacion;
    @Bind(R.id.txt_tituloD)
    TextView txtTitulo;
    @Bind(R.id.txt_direccionD)
    TextView txtDireccion;
    @Bind(R.id.horaD)
    TextView hora;
    @Bind(R.id.lineInfoEstacion)
    LinearLayout lineInfoEstacion;
    GoogleApiClient.Builder builder;


    public static FirstMapFragment newInstance() {
        FirstMapFragment fragment = new FirstMapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home__map, container, false);
        ButterKnife.bind(this, v);

        mapa.onCreate(savedInstanceState);
        mapa.getMapAsync(this);

        lineInfoEstacion.setVisibility(View.GONE);

        return v;
    }

    private long String2Long(String s) {
        return Long.valueOf(s);
    }


    @Override
    public void onResume() {
        super.onResume();
        mapa.onResume();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mapa.onPause();
        //   apiClient.stopAutoManage(getActivity());
        //  apiClient.disconnect();

    }

    @Override
    public void onDestroy() {
//        mapa.onDestroy();
        super.onDestroy();
//
        //  apiClient.stopAutoManage(getActivity());
        //  apiClient.disconnect();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapa.onLowMemory();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
        } else {

        }

        pintarPosicionGPS("0");
    }

    Marker myMaker;
    private void pintarPosicionGPS(String tag) {

        map.clear();
        LatLng punto;


        TIpoRepositoeio tipoRepositorio=new TIpoRepositoeio();
        List<ESTACION> lista = tipoRepositorio.getForId(this.getActivity(), String2Long("1")).getFk_estaciones();

        int i;
        for(i=0 ; i<= lista.size()-1;i++) {
            punto = new LatLng(Double.parseDouble(lista.get(i).getLatitud()), Double.parseDouble(lista.get(i).getLongitud()));
            if(tag.equalsIgnoreCase(lista.get(i).getId().toString())){
                myMaker = map.addMarker(new MarkerOptions().position(punto).icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_estacion_seleccionado)));
                myMaker.setTag(lista.get(i).getId().toString());

                Picasso.with(getContext()).load(lista.get(i).getFoto()).into(photoEstacion);
                txtTitulo.setText(lista.get(i).getNombre().toString());
                txtDireccion.setText(lista.get(i).getDirecion().toString());
                hora.setText("08:00 - 23:00");
            }else{
                myMaker = map.addMarker(new MarkerOptions().position(punto).icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_estacion_noseleccionado)));
                myMaker.setTag(lista.get(i).getId().toString());
            }
        }


        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                lineInfoEstacion.setVisibility(View.VISIBLE);
                pintarPosicionGPS((String) marker.getTag());
                //lineInfoProveedor.setVisibility(View.VISIBLE);
                return false;
            }
        });

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                lineInfoEstacion.setVisibility(View.GONE);
                map.clear();
                pintarPosicionGPS("0");
            }
        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker.getId();
            }
        });

    }




}
