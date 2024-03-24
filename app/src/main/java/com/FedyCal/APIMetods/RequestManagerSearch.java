package com.FedyCal.APIMetods;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.FedyCal.Listeners.OnSearchListener;
import com.FedyCal.movieshowfinder.ui.search.SearchFragment;
import com.google.android.material.chip.ChipGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * It takes care of making API calls via retrofit. In this case there is an api call,
 * to get the search results once a movie title has been entered
 */

//SET UP Retrofit form manege requests
public class RequestManagerSearch {

    SearchFragment fragment;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManagerSearch(SearchFragment fragment) {
        this.fragment = fragment;
    }

    public void searchMovies(OnSearchListener listener, String movie_name, ChipGroup chipGroup){
        String chip;
        int chipId_Movie = 2131230840;
        if(chipGroup.getCheckedChipId()==chipId_Movie) {
            chip = "Movie";
        }else{
            chip = "Show";
        }
        Log.d("DEBUG", ""+chipGroup.getCheckedChipId());

        if (chip.equals("Movie")) {
            getMovies getMovies = retrofit.create(RequestManagerSearch.getMovies.class);
            Call<ListsApiResponse> call = getMovies.callMovies("b5af17fafe2090ab9f8bd7267f6d2e5a", movie_name);

            call.enqueue(new Callback<ListsApiResponse>() {
                @Override
                public void onResponse(@NonNull Call<ListsApiResponse> call, @NonNull Response<ListsApiResponse> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(fragment.getContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
                        return;
                    }
                    listener.onResponse(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<ListsApiResponse> call, @NonNull Throwable t) {
                    listener.onError(t.getMessage());
                }
            });
        }else{
            getShow getShow = retrofit.create(RequestManagerSearch.getShow.class);
            Call<ListsApiResponse> call = getShow.callShow("b5af17fafe2090ab9f8bd7267f6d2e5a", movie_name);

            call.enqueue(new Callback<ListsApiResponse>() {
                @Override
                public void onResponse(@NonNull Call<ListsApiResponse> call, @NonNull Response<ListsApiResponse> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(fragment.getContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
                        return;
                    }
                    listener.onResponse(response.body());
                }

                @Override
                public void onFailure(@NonNull Call<ListsApiResponse> call, @NonNull Throwable t) {
                    listener.onError(t.getMessage());
                }
            });
        }

    }

    //interface API
    public interface getMovies{
        @GET("/3/search/movie")
        Call<ListsApiResponse> callMovies(
            //@Path("typeOfResult" String typeOfResult),
            @Query("api_key") String apiKey,
            @Query("query") String movie_name
        );
    }

    public interface getShow{
        @GET("/3/search/tv")
        Call<ListsApiResponse> callShow(
                @Query("api_key") String apikey,
                @Query("query") String movie_name
        );
    }
}

//https://api.themoviedb.org/3/search/movie?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a&query=Jack+Reacher
//https://image.tmdb.org/t/p/original/{poster_path}
//https://api.themoviedb.org/3/movie/550?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a
//https://api.themoviedb.org/3/search/tv?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a&query=friends