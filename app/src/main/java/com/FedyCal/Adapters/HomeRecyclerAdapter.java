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
 * adapter and view holder for the 2 recycler views of the fragment home.
 * They receive the list from the API and display the results on the recyclerview
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder>{
    Context context;
    List<ItemsArrayObject> list;
    OnMovieClickListener listener;


    public HomeRecyclerAdapter(Context context, List<ItemsArrayObject> list, OnMovieClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    public List<ItemsArrayObject> getList() {
        return list;
    }

    public void setList(List<ItemsArrayObject> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        if(!list.get(position).getTitle().equals("")) {
            holder.textView_movie.setText(list.get(position).getTitle());
            holder.item_container_home.setOnClickListener(v -> listener.onMovieClicked(
                    list.get(holder.getAdapterPosition()).getId(),
                    list.get(holder.getAdapterPosition()).getTitle(),
                    list.get(holder.getAdapterPosition()).getName(),
                    list.get(holder.getAdapterPosition()).getPoster_path(),
                    "Movie"));
        }else {
            holder.textView_movie.setText(list.get(position).getName());
            holder.item_container_home.setOnClickListener(v -> listener.onMovieClicked(
                    list.get(holder.getAdapterPosition()).getId(),
                    list.get(holder.getAdapterPosition()).getTitle(),
                    list.get(holder.getAdapterPosition()).getName(),
                    list.get(holder.getAdapterPosition()).getPoster_path(),
                    "Show"));
        }
        Picasso.get().load("https://image.tmdb.org/t/p/original/"+list.get(position).getPoster_path()).into(holder.imageView_poster);

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
        Log.d("DEBUG", "this is the list");
        //SearchArrayObject searchArrayObject = new SearchArrayObject();

        if(list == null){
            Log.d("DEBUG", "LIST == null");
            return 0;
        }
        return list.size();
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView_poster;
    TextView textView_movie;
    CardView item_container_home;
    MaterialFavoriteButton materialFavoriteButton;


    public HomeViewHolder(@NonNull View itemView){
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.imageView_poster);
        item_container_home = itemView.findViewById(R.id.item_container_home);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        textView_movie.setSingleLine(true);
        textView_movie.postDelayed(() -> textView_movie.setSelected(true), 7000);
        materialFavoriteButton = itemView.findViewById(R.id.favourite_button);
    }
}