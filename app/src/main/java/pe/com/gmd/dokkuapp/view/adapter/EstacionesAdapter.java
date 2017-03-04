package pe.com.gmd.dokkuapp.view.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.orm.ESTACION;
import pe.com.gmd.dokkuapp.view.activity.DetalleActivity;
import pe.com.gmd.dokkuapp.view.activity.DetalleEstacionActivity;

/**
 * Created by glarab on 2/03/2017.
 */

public class EstacionesAdapter extends RecyclerView.Adapter<EstacionesAdapter.VHEstaciones> {

    List<ESTACION> lista;

    public EstacionesAdapter(List<ESTACION> lista) {
        this.lista = lista;
    }

    @Override
    public VHEstaciones onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_paraderos, parent, false);
        VHEstaciones viewHolder = new VHEstaciones(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHEstaciones v, int position) {
            v.txtTitulo.setText(lista.get(position).getNombre());
            v.txtDireccion.setText(lista.get(position).getDirecion());
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class VHEstaciones extends RecyclerView.ViewHolder {
        @Bind(R.id.photoRestaurante)
        ImageView photoRestaurante;
        @Bind(R.id.txt_titulo)
        TextView txtTitulo;
        @Bind(R.id.txt_direccion)
        TextView txtDireccion;
        @Bind(R.id.recargar)
        ImageView recargar;
        @Bind(R.id.hora)
        TextView hora;
        @Bind(R.id.cv)
        CardView cv;
        public VHEstaciones(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), DetalleEstacionActivity.class);
                    intent.putExtra("id",lista.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }


}
