package com.FedyCal.APIMetods;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.FedyCal.Listeners.OnHomeListener1;
import com.FedyCal.Listeners.OnHomeListener2;
import com.FedyCal.movieshowfinder.ui.home.HomeFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


//SET UP Retrofit form manege requests
public class RequestManagerHome {

    /**
     * It takes care of making API calls via retrofit.
     * In this case there a4re 2 api calls, one for each recyclerview.
     * One to receive the Top Movies, and one to receive the Top Shows.
     */

    HomeFragment fragment;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManagerHome(HomeFragment fragment) {
        this.fragment = fragment;
    }

    public void getResultApi(OnHomeListener1 listener){
        getPopularMovies getPopularMovies = retrofit.create(getPopularMovies.class);
        Call<ListsApiResponse> call = getPopularMovies.callTopMovies("b5af17fafe2090ab9f8bd7267f6d2e5a");

        call.enqueue(new Callback<ListsApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListsApiResponse> call, @NonNull Response<ListsApiResponse> response) {
                if(!response.isSuccessful()){
                    Log.d("DEBUG", "response not successful - RequestManagerHome line42");
                    Toast.makeText(fragment.getContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
                    return;
                }
                if(response.body() == null){
                    Log.d("DEBUG", "response.body() == null");
                }else{
                    String str = response.body().toString();
                    Log.d("DEBUG", "response"+str);
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ListsApiResponse> call, @NonNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


    public void getResultApi(OnHomeListener2 listener){
        getPopularShow getPopularShow = retrofit.create(getPopularShow.class);
        Call<ListsApiResponse> call = getPopularShow.callTopShow("b5af17fafe2090ab9f8bd7267f6d2e5a");

        call.enqueue(new Callback<ListsApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ListsApiResponse> call, @NonNull Response<ListsApiResponse> response) {
                if(!response.isSuccessful()){
                    Log.d("DEBUG", "response not successful - RequestManagerHome line 71");
                    Toast.makeText(fragment.getContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
                    return;
                }

                if(response.body() == null){
                    Log.d("DEBUG", "response.body() == null");
                }else{
                    String str = response.body().toString();
                    Log.d("DEBUG", "response"+str);
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ListsApiResponse> call, @NonNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    //interface API
    public  interface getPopularMovies {
        @GET("/3/movie/popular")
        Call<ListsApiResponse> callTopMovies(
                @Query("api_key") String apiKey
        );
    }

    public interface getPopularShow {
        @GET("/3/tv/popular")
        Call<ListsApiResponse> callTopShow(
                @Query("api_key") String apiKey
        );
    }
}

//https://api.themoviedb.org/3/search/movie?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a&query=Jack+Reacher
//https://image.tmdb.org/t/p/original/{poster_path}
//https://api.themoviedb.org/3/movie/550?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a
//https://api.themoviedb.org/3/movie/popular?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a