package com.example.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    ArrayList<FeaturedHelperClass> categoryLocations;

    public CategoryAdapter(ArrayList<FeaturedHelperClass> categoryLocations) {
        this.categoryLocations = categoryLocations;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoryHolder categoryHolder = new CategoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = categoryLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return categoryLocations.size();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);
            desc = itemView.findViewById(R.id.categories_desc);
        }
    }

}
