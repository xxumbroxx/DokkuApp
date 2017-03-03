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
import pe.com.gmd.dokkuapp.domain.orm.RUTA;
import pe.com.gmd.dokkuapp.service.dao.impl.RutaRepositorio;
import pe.com.gmd.dokkuapp.view.adapter.RutasAdapter;

public class RutasFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @Bind(R.id.rvRutas)
    RecyclerView rvRutas;
    Context context;

    List<RUTA> lista;

    private OnFragmentInteractionListener mListener;

    public RutasFragment() {
        // Required empty public constructor
    }


    public static RutasFragment newInstance(String param1, String param2) {
        RutasFragment fragment = new RutasFragment();
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
        View view=  inflater.inflate(R.layout.fragment_rutas, container, false);
        ButterKnife.bind(this, view);

        RutaRepositorio rutaRepositorio = new RutaRepositorio();
        lista = rutaRepositorio.getAll(this.getContext());
        context = view.getContext();
        rvRutas.setLayoutManager(new LinearLayoutManager(context));

        RutasAdapter adapter = new RutasAdapter(lista);
        rvRutas.setAdapter(adapter);
        return  view;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
