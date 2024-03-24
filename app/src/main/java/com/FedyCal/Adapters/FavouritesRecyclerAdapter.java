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
 * adapter and view holder for the recycler view of the fragment Favourites.
 * They receive the list from the SQLite database and display the results on the recyclerview
 */

public class FavouritesRecyclerAdapter extends RecyclerView.Adapter<FavouriteViewHolder>{
    Context context;
    List<ItemsArrayObject> list;
    OnMovieClickListener onMovieClickListener;
    MaterialFavoriteButton.OnFavoriteChangeListener OnFavoriteChangeListener;


    public FavouritesRecyclerAdapter(Context context, List<ItemsArrayObject> list, OnMovieClickListener onMovieClickListener, MaterialFavoriteButton.OnFavoriteChangeListener OnFavoriteChangeListener) {
        this.context = context;
        this.list = list;
        this.onMovieClickListener = onMovieClickListener;
        this.OnFavoriteChangeListener = OnFavoriteChangeListener;
    }

    public List<ItemsArrayObject> getList() {
        return list;
    }

    public void setList(List<ItemsArrayObject> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_search_and_favourites, parent, false);
        return new FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        if(!list.get(holder.getAdapterPosition()).getTitle().equals("")) {
            holder.textView_movie.setText(list.get(position).getTitle());
            holder.item_container_favourite.setOnClickListener(v -> onMovieClickListener.onMovieClicked(
                    list.get(holder.getAdapterPosition()).getId(),
                    list.get(holder.getAdapterPosition()).getTitle(),
                    list.get(holder.getAdapterPosition()).getName(),
                    list.get(holder.getAdapterPosition()).getPoster_path(),
                    "Movie"));
        }else{
            holder.textView_movie.setText(list.get(position).getName());
            holder.item_container_favourite.setOnClickListener(v -> onMovieClickListener.onMovieClicked(
                    list.get(holder.getAdapterPosition()).getId(),
                    list.get(holder.getAdapterPosition()).getTitle(),
                    list.get(holder.getAdapterPosition()).getName(),
                    list.get(holder.getAdapterPosition()).getPoster_path(),
                    "Show"));
        }
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+list.get(position).getPoster_path()).into(holder.imageView_poster);
        holder.materialFavoriteButton.setFavorite(true);
        holder.materialFavoriteButton.setOnFavoriteChangeListener(
                (buttonView, favorite) -> {
                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                    LoaderInterface loaderInterface = new Loader(databaseHelper);
                    if(favorite){
                        Log.d("DEBUG", "is favourite");
                        loaderInterface.addToFavourite(new ItemsArrayObject(
                                list.get(holder.getAdapterPosition()).getId(),
                                list.get(holder.getAdapterPosition()).getTitle(),
                                list.get(holder.getAdapterPosition()).getName(),
                                list.get(holder.getAdapterPosition()).getPoster_path(),
                                list.get(holder.getAdapterPosition()).getType()
                        ));
                    }else {
                        Log.d("DEBUG", "is not favourite");
                        loaderInterface.removeFavourite(list.get(holder.getAdapterPosition()).getId());
                    }
                });
    }


    @Override
    public int getItemCount() {
        Log.d("DEBUG", " FavouritesRecyclerAdapter - line 68 this is the list");
        //SearchArrayObject searchArrayObject = new SearchArrayObject();

        if(list == null){
            Log.d("DEBUG", "FavouritesRecyclerAdapter - line 68 -LIST == null");
            return 0;
        }
        Log.d("DEBUG", "FavouritesRecyclerAdapter - line 68 - LIST SIZE:"+list.size());
        return list.size();
    }
}

class FavouriteViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView_poster;
    TextView textView_movie;
    CardView item_container_favourite;
    MaterialFavoriteButton materialFavoriteButton;

    public FavouriteViewHolder(@NonNull View itemView){
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.imageView_poster);
        item_container_favourite = itemView.findViewById(R.id.item_container_search_and_favourites);
        materialFavoriteButton = itemView.findViewById(R.id.favourite_button);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        textView_movie.setSingleLine(true);
        textView_movie.postDelayed(() -> textView_movie.setSelected(true), 7000);
    }
}
