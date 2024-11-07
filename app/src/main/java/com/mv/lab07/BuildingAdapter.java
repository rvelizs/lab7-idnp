package com.mv.lab07;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {
    private List<Building> buildingList;
    private List<Building> buildingListFull; // copia completa de la lista para el filtro

    public BuildingAdapter(List<Building> buildingList) {
        this.buildingList = buildingList;
        this.buildingListFull = new ArrayList<>(buildingList);
    }

    @NonNull
    @Override
    public BuildingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_building, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingViewHolder holder, int position) {
        Building building = buildingList.get(position);
        holder.tvTitle.setText(building.getTitle());
        holder.tvCategory.setText(building.getCategory());
        holder.tvDescription.setText(building.getDescription());

        Glide.with(holder.itemView.getContext())
                .load(building.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    public void filter(String text) {
        buildingList.clear();
        if (text.isEmpty()) {
            buildingList.addAll(buildingListFull);
        } else {
            text = text.toLowerCase();
            for (Building building : buildingListFull) {
                if (building.getTitle().toLowerCase().contains(text) ||
                        building.getCategory().toLowerCase().contains(text)) {
                    buildingList.add(building);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class BuildingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle, tvCategory, tvDescription;

        BuildingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
