package be.ehb.nootjesdb.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.nootjesdb.R;
import be.ehb.nootjesdb.model.Nut;

public class NutAdapter extends RecyclerView.Adapter<NutAdapter.NutViewHolder> {


    class NutViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV;

        public NutViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.cell_tv_name);
        }
    }

    private ArrayList<Nut> items;

    public NutAdapter() {
        this.items = new ArrayList<>();
    }

    public void addNuts(List<Nut> newItems){
        this.items.clear();
        this.items.addAll(newItems);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);
        return new NutViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull NutViewHolder holder, int position) {
        Nut nut = items.get(position);
        holder.nameTV.setText(nut.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
