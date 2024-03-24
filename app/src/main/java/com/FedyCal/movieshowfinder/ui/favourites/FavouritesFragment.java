package com.FedyCal.movieshowfinder.ui.favourites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.FedyCal.Adapters.FavouritesRecyclerAdapter;
import com.FedyCal.DataStructures.ItemsArrayObject;
import com.FedyCal.Database.DatabaseHelper;
import com.FedyCal.Database.Loader;
import com.FedyCal.Database.LoaderInterface;
import com.FedyCal.ItemInformationActivity;
import com.FedyCal.Listeners.OnMovieClickListener;
import com.FedyCal.movieshowfinder.R;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.Collections;
import java.util.List;

public class FavouritesFragment extends Fragment implements OnMovieClickListener, MaterialFavoriteButton.OnFavoriteChangeListener {
    private RecyclerView recycler_view_favourites;
    FavouritesRecyclerAdapter adapter;
    ProgressDialog dialog;
    DatabaseHelper databaseHelper;
    LoaderInterface loaderInterface;
    TextView textView_Favourite_list_empty;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        recycler_view_favourites = view.findViewById(R.id.recycler_view_favourites);
        recycler_view_favourites.setAdapter(adapter);
        databaseHelper = new DatabaseHelper(this.getContext());
        loaderInterface = new Loader(databaseHelper);
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Loading");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();


        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
        //SQLiteDatabase database = databaseHelper.getWritableDatabase();
        LoaderInterface loader = new Loader(databaseHelper);
        List<ItemsArrayObject> list = loader.getFavourites();
        Collections.reverse(list);

        textView_Favourite_list_empty = view.findViewById(R.id.text_Favourite_List_empty);

        if(list.size()==0){
            textView_Favourite_list_empty.setVisibility(View.VISIBLE);
        }else{
            textView_Favourite_list_empty.setVisibility(View.INVISIBLE);
        }

        showResult(list);
        dialog.dismiss();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResume of FavouriteFragment");

        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Loading");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
        LoaderInterface loader = new Loader(databaseHelper);
        List<ItemsArrayObject> list = loader.getFavourites();
        if(list.size()==0){
            textView_Favourite_list_empty.setVisibility(View.VISIBLE);
        }else{
            textView_Favourite_list_empty.setVisibility(View.INVISIBLE);
        }
        Collections.reverse(list);
        showResult(list);
        dialog.dismiss();
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

    public void onMovieClicked(String id, String title, String name, String poster_path, String type) {
        startActivity(new Intent(getActivity(), ItemInformationActivity.class)
                .putExtra("id", id)
                .putExtra("title", title)
                .putExtra("name", name)
                .putExtra("poster_path", poster_path)
                .putExtra("type", type));
    }


    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
    }


    private void showResult(List<ItemsArrayObject> list) {
        adapter = new FavouritesRecyclerAdapter(getContext(), list, this, this);
        recycler_view_favourites.setAdapter(adapter);
        recycler_view_favourites.setHasFixedSize(true);
        recycler_view_favourites.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}