package com.FedyCal.Database;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract() {}

    public static class FavouriteEntry implements BaseColumns {
        public static final String TABLE_NAME = "Favourite_movies_and_show";
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String NAME = "name";
        public static final String POSTER_PATH = "poster_path";
        public static final String TYPE = "type";
    }
}
