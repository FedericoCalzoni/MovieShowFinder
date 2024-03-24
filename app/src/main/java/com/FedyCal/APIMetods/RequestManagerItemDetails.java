package com.FedyCal.APIMetods;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.FedyCal.DataStructures.itemsDetailObject;
import com.FedyCal.ItemInformationActivity;
import com.FedyCal.Listeners.OnItemListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * It takes care of making an API call via retrofit.
 * In this case there is an api call, to get the details of a movie or a tv series given as input
 * the ID and type (movie or tv).
 */


//SET UP Retrofit form manege requests
public class RequestManagerItemDetails {
    ItemInformationActivity activity;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManagerItemDetails(ItemInformationActivity activity) {
        this.activity = activity;
    }

    public void getItemDetail(OnItemListener listener, String id, String type){
        Call<itemsDetailObject> call;

        switch(type) {
            case "Movie":
                getMovieDetail getMovieDetail = retrofit.create(getMovieDetail.class);
                call = getMovieDetail.callMovieDetail(id, "b5af17fafe2090ab9f8bd7267f6d2e5a");
                call.enqueue(new Callback<itemsDetailObject>() {
                    @Override
                    public void onResponse(@NonNull Call<itemsDetailObject> call, @NonNull Response<itemsDetailObject> response) {
                        if(!response.isSuccessful()){
                            Log.d("DEBUG", "response not successful - RequestManagerItemDetails line 41");
                            Toast.makeText(activity.getApplicationContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
                            throw new IllegalArgumentException("Argument is not a MOVIE!");
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
                    public void onFailure(@NonNull Call<itemsDetailObject> call, @NonNull Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
                break;
            case "Show":
                getShowDetail getShowDetail = retrofit.create(getShowDetail.class);
                call = getShowDetail.callShowDetail(id, "b5af17fafe2090ab9f8bd7267f6d2e5a");

                call.enqueue(new Callback<itemsDetailObject>() {
                    @Override
                    public void onResponse(@NonNull Call<itemsDetailObject> call, @NonNull Response<itemsDetailObject> response) {

                        if(!response.isSuccessful()){
                            Log.d("DEBUG", "response not successful - RequestManagerItemDetails line 41");
                            Toast.makeText(activity.getApplicationContext(), "ERROR: Impossible to fetch data from API", Toast.LENGTH_LONG).show();
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
                    public void onFailure(@NonNull Call<itemsDetailObject> call, @NonNull Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
                break;
            default:
                Log.e("DEBUG", "the type parameter is not valid - RequestManagerItemDetail line 92 ");
        }
    }

    //interface API
    public interface getMovieDetail{
        @GET ("/3/movie/{movie_id}")
        Call<itemsDetailObject> callMovieDetail(
                @Path("movie_id") String id,
                @Query("api_key") String apiKey
        );
    }

    public interface getShowDetail{
        @GET ("/3/tv/{show_id}")
        Call<itemsDetailObject> callShowDetail(
                @Path("show_id") String id,
                @Query("api_key") String apiKey
        );
    }
}

//https://api.themoviedb.org/3/search/movie?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a&query=Jack+Reacher
//https://image.tmdb.org/t/p/original/{poster_path}
//https://api.themoviedb.org/3/movie/550?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a
//https://api.themoviedb.org/3/movie/popular?api_key=b5af17fafe2090ab9f8bd7267f6d2e5a

// https://api.themoviedb.org/3/movie/{movie_id}?api_key=<<api_key>>&language=en-US