package pe.com.gmd.dokkuapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.RUTA;

/**
 * Created by jsaenz on 3/3/2017.
 */

public class RutasAdapter extends RecyclerView.Adapter<RutasAdapter.VHRutas> {

    List<RUTA> lista;

    public RutasAdapter(List<RUTA> lista) {
        this.lista = lista;
    }

    @Override
    public RutasAdapter.VHRutas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_rutas,parent,false);
        VHRutas viewHolder = new VHRutas(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHRutas v, int position) {
        TextView diasView[]={v.d1,v.d2,v.d3,v.d4,v.d5,v.d6,v.d7};
        v.txtLetraRu.setText(lista.get(position).getDireccion());
        v.txtNombreRu.setText(lista.get(position).getNombre());
        v.txtParadasRu.setText(lista.get(position).getTexto());
//        v.txtHoraRu.setText(lista.get(position).getHastaMA());
//        v.txtFrecuRu.setText(lista.get(position).getFrecuencia());
//        v.d1
//        v.d2
//        v.d3
        char[] dias = lista.get(position).getDias().toCharArray();
        for (int i = 0; i <dias.length ; i++) {
            if(dias[i]=='X'){
                diasView[i].setVisibility(View.VISIBLE);
            }else{
                diasView[i].setVisibility(View.GONE);
            }
        }

        String tarde = "";
        String maniana= lista.get(position).getDesdeMA().toString()+":00" +" a "+ lista.get(position).getHastaMA().toString()+":00";
        if(!lista.get(position).getDesdeTA().equals(0)) {
            tarde = " / " + lista.get(position).getDesdeTA().toString() + ":00" + " a " + lista.get(position).getHastaTA().toString() + ":00";
        }

        v.txtFrecuRu.setText("Cada "+lista.get(position).getFrecuencia().toString()+" minutos");
        v.txtHoraRu.setText(maniana + tarde);


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class VHRutas extends RecyclerView.ViewHolder {
        @Bind(R.id.txtLetraRu)
        TextView txtLetraRu;
        @Bind(R.id.txtNombreRu)
        TextView txtNombreRu;
        @Bind(R.id.txtParadasRu)
        TextView txtParadasRu;
        @Bind(R.id.txtHoraRu)
        TextView txtHoraRu;
        @Bind(R.id.txtFrecuRu)
        TextView txtFrecuRu;
        @Bind(R.id.d1)
        TextView d1;
        @Bind(R.id.d2)
        TextView d2;
        @Bind(R.id.d3)
        TextView d3;
        @Bind(R.id.d4)
        TextView d4;
        @Bind(R.id.d5)
        TextView d5;
        @Bind(R.id.d6)
        TextView d6;
        @Bind(R.id.d7)
        TextView d7;


        public VHRutas(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
