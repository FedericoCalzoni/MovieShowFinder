package com.FedyCal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.FedyCal.APIMetods.RequestManagerItemDetails;
import com.FedyCal.DataStructures.ItemsArrayObject;
import com.FedyCal.DataStructures.itemsDetailObject;
import com.FedyCal.Database.DatabaseHelper;
import com.FedyCal.Database.Loader;
import com.FedyCal.Database.LoaderInterface;
import com.FedyCal.Listeners.OnItemListener;
import com.FedyCal.movieshowfinder.R;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.squareup.picasso.Picasso;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Class for the activity that show the details of the movie or Show
 */
public class ItemInformationActivity extends AppCompatActivity {
    TextView textView_title, textView_vote_average,textView_overview,textView_original_language, textView_release_date, textView_adult_content;
    ImageView imageView_backdrop, imageView_poster;
    RatingBar ratingBar;
    RequestManagerItemDetails manager;
    ProgressDialog dialog;
    String id, title, name, poster_path, type;
    MaterialFavoriteButton materialFavoriteButton;
    DatabaseHelper databaseHelper;
    LoaderInterface loaderInterface;

    //TO DO
    private final OnItemListener listener = new OnItemListener() {
        @Override
        public void onResponse(itemsDetailObject response) {
            dialog.dismiss();
            if (response == null) {
                Log.d("DEBUG", "response == null");
                Toast.makeText(getApplicationContext(), "error: response==null", Toast.LENGTH_LONG).show();
                return;
            }
            Log.d("DEBUG", "response fetched correctly", null);
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Log.e("DEBUG", message);
            Toast.makeText(getApplicationContext(), "Error: OnItemListener", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results_information);

        textView_title = findViewById(R.id.textView_title);
        textView_vote_average =findViewById(R.id.textView_vote_average);
        textView_overview= findViewById(R.id.textView_overview);
        textView_original_language = findViewById(R.id.textView_original_language);
        textView_release_date = findViewById(R.id.textView_release_date);
        textView_adult_content = findViewById(R.id.textView_adult_content);
        imageView_backdrop = findViewById(R.id.imageView_backdrop);
        imageView_poster = findViewById(R.id.imageView_poster);
        ratingBar = findViewById(R.id.rating);
        manager= new RequestManagerItemDetails(this);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        loaderInterface = new Loader(databaseHelper);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();

        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        name = getIntent().getStringExtra("name");
        poster_path = getIntent().getStringExtra("poster_path");
        type = getIntent().getStringExtra("type");


        Log.d("DEBUG","id:"+id+"  type:"+type);
        manager.getItemDetail(listener, id, type);
        materialFavoriteButton = findViewById(R.id.favourite_button);

        materialFavoriteButton.setFavorite(loaderInterface.isFavourite(id));

        materialFavoriteButton.setOnFavoriteChangeListener(
                (buttonView, favorite) -> {
                    if(favorite){
                        Log.d("DEBUG", "is favourite");
                        loaderInterface.addToFavourite(new ItemsArrayObject(id,title, name, poster_path, type));
                        Toast.makeText(getApplicationContext(), "ELEMENT ADDED TO FAVOURITES", Toast.LENGTH_SHORT).show();
                    }else {
                        Log.d("DEBUG", "is not favourite");
                        loaderInterface.removeFavourite(id);
                        Toast.makeText(getApplicationContext(), "ELEMENT REMOVED FROM FAVOURITES", Toast.LENGTH_SHORT).show();
                    }
                });

        Log.d("DEBUG" ,"color:"+textView_overview.getCurrentTextColor());

    }
    private void showResult(@NonNull itemsDetailObject response){
        DecimalFormat df = new DecimalFormat("#.0");
        df.setRoundingMode(RoundingMode.CEILING);
        if(!response.getTitle().equals("")) {
            textView_title.setText(response.getTitle());
            textView_overview.setText(response.getOverview());
            String originalLanguage = "Original language: " + response.getOriginal_language();
            textView_original_language.setText(originalLanguage);
            String voteAverage = "" + df.format(Float.parseFloat(response.getVote_average()) / 2);
            textView_vote_average.setText(voteAverage);
            String adultContent = "Adult Content: " + response.getAdult();
            textView_adult_content.setText(adultContent);
            String releaseDate = "Release date: " + response.getRelease_date();
            textView_release_date.setText(releaseDate);
            ratingBar.setRating((Float.parseFloat(response.getVote_average())) / 2);
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + response.getBackdrop_path()).into(imageView_backdrop);
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + response.getPoster_path()).into(imageView_poster);
        }else if(response.getTitle().equals("")){
            textView_title.setText(response.getName());
            textView_overview.setText(response.getOverview());
            String originalLanguage = "Original language: " + response.getOriginal_language();
            textView_original_language.setText(originalLanguage);
            String voteAverage = "" + df.format((Float.parseFloat(response.getVote_average())) / 2);
            textView_vote_average.setText(voteAverage);
            String adultContent = "Adult Content: " + response.getAdult();
            textView_adult_content.setText(adultContent);
            String releaseDate = "First Air Date: " + response.getFirst_air_date();
            textView_release_date.setText(releaseDate);
            ratingBar.setRating((Float.parseFloat(response.getVote_average())) / 2);
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + response.getBackdrop_path()).into(imageView_backdrop);
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + response.getPoster_path()).into(imageView_poster);

        }
    }
}

