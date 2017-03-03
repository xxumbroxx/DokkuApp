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

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;


public class FirstMapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;

    List<Point> listaPuntos;
    @Bind(R.id.mapView)
    MapView mapa;

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

        return v;
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

    }


}