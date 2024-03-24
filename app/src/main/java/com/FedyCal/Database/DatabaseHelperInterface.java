package com.FedyCal.Database;

import android.database.sqlite.SQLiteDatabase;

import com.FedyCal.DataStructures.ItemsArrayObject;

import java.util.List;

public interface DatabaseHelperInterface {
    List<ItemsArrayObject> getFavourites(SQLiteDatabase sqLiteDatabase);
    ItemsArrayObject getFavouriteById(SQLiteDatabase sqLiteDatabase, String id);
    long addFavourite(SQLiteDatabase sqLiteDatabase, ItemsArrayObject itemsArrayObject);
    long removeFavourite(SQLiteDatabase sqLiteDatabase, String id);
}
