package com.FedyCal.movieshowfinder.ui.search;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.FedyCal.APIMetods.ListsApiResponse;
import com.FedyCal.APIMetods.RequestManagerSearch;
import com.FedyCal.Adapters.SearchRecyclerAdapter;
import com.FedyCal.ItemInformationActivity;
import com.FedyCal.Listeners.OnMovieClickListener;
import com.FedyCal.Listeners.OnSearchListener;
import com.FedyCal.movieshowfinder.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class SearchFragment extends Fragment implements OnMovieClickListener {

    private RecyclerView recycler_view_search;
    private ChipGroup chipGroup;
    SearchView search_view;
    Chip chip_movie;
    SearchRecyclerAdapter adapter;
    RequestManagerSearch manager;
    ProgressDialog dialog;
    String chip;
    String searchQuery = "";


    private final OnSearchListener listener = new OnSearchListener() {
        @Override
        public void onResponse(ListsApiResponse response) {
            dialog.dismiss();
            if(response==null){
                Toast.makeText( getContext(), "error: response==null", Toast.LENGTH_LONG).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(getContext(), "Error: OnSearchListener", Toast.LENGTH_LONG).show();
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        search_view = view.findViewById(R.id.search_view);
        recycler_view_search = view.findViewById(R.id.recycler_view_search);
        recycler_view_search.setAdapter(adapter);
        chipGroup =view.findViewById(R.id.chip_group);
        chip_movie = view.findViewById(R.id.chip_movie);
        manager = new RequestManagerSearch(this);
        dialog = new ProgressDialog(getActivity());


        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchQuery = query;
                dialog.setTitle("Searching...");
                dialog.show();
                manager.searchMovies(listener, query, chipGroup);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        chipGroup.setOnCheckedChangeListener((chipGroup, i) -> {
            if(searchQuery.length()>0){
                dialog.setTitle("Searching...");
                dialog.show();
                manager.searchMovies(listener, searchQuery, chipGroup);
            }
        });

        chip_movie.setOnCloseIconClickListener(view1 -> Toast.makeText(getContext(), "MOVIE is Clicked", Toast.LENGTH_SHORT).show());

        Chip chip_show = view.findViewById(R.id.chip_show);
        chip_show.setOnCloseIconClickListener(view12 -> Toast.makeText(getContext(), "SHOW is Clicked", Toast.LENGTH_SHORT).show());

        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

    @Override
    public void onMovieClicked(String id, String title, String name, String poster_path, String type) {
        startActivity(new Intent(getActivity(), ItemInformationActivity.class)
                .putExtra("id", id)
                .putExtra("title", title)
                .putExtra("name", name)
                .putExtra("poster_path", poster_path)
                .putExtra("type", type));
    }

    private void showResult(@NonNull ListsApiResponse response) {
        int chipId_Movie = 2131230840;
        if(chipGroup.getCheckedChipId()==chipId_Movie) {
            chip = "Movie";
        }else{
            chip = "Show";
        }
        Log.d("DEBUG", ""+chipGroup.getCheckedChipId());
        adapter = new SearchRecyclerAdapter(getContext(), response.getResults(), this, chip);
        recycler_view_search.setAdapter(adapter);
        recycler_view_search.setHasFixedSize(true);
        recycler_view_search.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

}

