package com.FedyCal.Database;

import android.database.sqlite.SQLiteDatabase;

import com.FedyCal.DataStructures.ItemsArrayObject;

import java.util.List;

public class Loader implements LoaderInterface{

    private final DatabaseHelper databaseHelper;
    private final List<ItemsArrayObject> list;

    public Loader(DatabaseHelper databaseHelper) {
        if(databaseHelper == null) throw new NullPointerException("databaseHelper == NULL");
        this.databaseHelper = databaseHelper;
        this.list = loadAllItemsArrayObjects();
    }

    private List<ItemsArrayObject> loadAllItemsArrayObjects() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        return databaseHelper.getFavourites(db);
    }

    @Override
    public List<ItemsArrayObject> getFavourites() {
        return list;
    }

    @Override
    public void addToFavourite(ItemsArrayObject itemsArrayObject) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long l = databaseHelper.addFavourite(db, itemsArrayObject);
        databaseHelper.close();
    }

    @Override
    public void removeFavourite(String id) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long l = databaseHelper.removeFavourite(db, id);
        databaseHelper.close();
    }

    @Override
    public boolean isFavourite(String id) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        return databaseHelper.isFavourite(db, id);
    }
}
