package pe.com.gmd.dokkuapp.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.DETALLE_RUTA;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.service.dao.impl.EstacionRepositorio;
import pe.com.gmd.dokkuapp.service.dao.impl.RutaRepositorio;
import pe.com.gmd.dokkuapp.view.adapter.EstacionesAdapter;

/**
 * Created by glarab on 3/03/2017.
 */

public class DetalleRutaFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.rv)
    RecyclerView rv;
    Context context;


    List<ESTACION> lista;
    private String mParam1;
    private String mParam2;

    private InformacionGeneralFragment.OnFragmentInteractionListener mListener;

    public DetalleRutaFragment() {
        // Required empty public constructor
    }


    public static InformacionGeneralFragment newInstance(String param1, String param2) {
        InformacionGeneralFragment fragment = new InformacionGeneralFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion_general, container, false);
        ButterKnife.bind(this, view);


        RutaRepositorio estacionRepositorio=new RutaRepositorio();
        Long a=Long.parseLong("1");
        List<DETALLE_RUTA> lista2 = estacionRepositorio.getForId(context, a).getFk_estaciones();
        lista2.get(0).getEstacion_id();
        context= view.getContext();

        rv.setLayoutManager(new LinearLayoutManager(context));

        EstacionesAdapter adapter = new EstacionesAdapter(lista);
        rv.setAdapter(adapter);
        return view;


    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
