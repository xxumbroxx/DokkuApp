package pe.com.gmd.dokkuapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.gmd.dokkuapp.R;

/**
 * Created by glarab on 2/03/2017.
 */

public class EstacionesAdapter extends RecyclerView.Adapter<EstacionesAdapter.VHEstaciones>{



    @Override
    public VHEstaciones onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_camera, parent, false);
        VHEstaciones viewHolder = new VHEstaciones(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHEstaciones holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 2;
    }

    public class VHEstaciones extends RecyclerView.ViewHolder {
        public VHEstaciones(View itemView) {
            super(itemView);
        }
    }
}
