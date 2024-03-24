package com.FedyCal.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.FedyCal.DataStructures.ItemsArrayObject;
import com.FedyCal.Database.DatabaseHelper;
import com.FedyCal.Database.Loader;
import com.FedyCal.Database.LoaderInterface;
import com.FedyCal.Listeners.OnMovieClickListener;
import com.FedyCal.movieshowfinder.R;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * adapter and view holder for the recycler view showing the search results. (fragment search).
 * Once the results list is received from the API, they are used to display the recyclerview list.
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchViewHolder>{
    Context context;
    List<ItemsArrayObject> list;
    OnMovieClickListener listener;
    String type;

    public SearchRecyclerAdapter(Context context, List<ItemsArrayObject> list, OnMovieClickListener listener, String type) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        this.type = type;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_container_search_and_favourites, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        if(!list.get(position).getTitle().equals("")) {
            holder.textView_movie.setText(list.get(position).getTitle());
        }else{
            holder.textView_movie.setText(list.get(position).getName());
        }
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+list.get(position).getPoster_path()).into(holder.imageView_poster);
        holder.item_container.setOnClickListener(v -> listener.onMovieClicked(
                list.get(holder.getAdapterPosition()).getId(),
                list.get(holder.getAdapterPosition()).getTitle(),
                list.get(holder.getAdapterPosition()).getName(),
                list.get(holder.getAdapterPosition()).getPoster_path(),
                type));

        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        LoaderInterface loaderInterface = new Loader(databaseHelper);
        MaterialFavoriteButton materialFavoriteButton = holder.itemView.findViewById(R.id.favourite_button);


        materialFavoriteButton.setFavorite(loaderInterface.isFavourite(list.get(holder.getAdapterPosition()).getId()));

        holder.materialFavoriteButton.setOnFavoriteChangeListener(
                (buttonView, favorite) -> {
                    if(favorite){
                        Log.d("DEBUG", "is favourite");
                        loaderInterface.addToFavourite(new ItemsArrayObject(
                                list.get(holder.getAdapterPosition()).getId(),
                                list.get(holder.getAdapterPosition()).getTitle(),
                                list.get(holder.getAdapterPosition()).getName(),
                                list.get(holder.getAdapterPosition()).getPoster_path(),
                                type
                        ));
                    }else {
                        Log.d("DEBUG", "is not favourite");
                        loaderInterface.removeFavourite(list.get(holder.getAdapterPosition()).getId());
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class SearchViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView_poster;
    TextView textView_movie;
    CardView item_container;
    MaterialFavoriteButton materialFavoriteButton;

    public SearchViewHolder(@NonNull View itemView){
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.imageView_poster);
        item_container = itemView.findViewById(R.id.item_container_search_and_favourites);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        textView_movie.setSingleLine(true);
        textView_movie.postDelayed(() -> textView_movie.setSelected(true), 7000);
        materialFavoriteButton = itemView.findViewById(R.id.favourite_button);
    }
}