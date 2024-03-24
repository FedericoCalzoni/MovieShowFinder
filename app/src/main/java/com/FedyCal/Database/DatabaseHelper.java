package com.FedyCal.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.FedyCal.DataStructures.ItemsArrayObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper implements DatabaseHelperInterface {
    public static final int DATABASE_VERSION  = 1;
    public static final String DATABASE_NAME = "favourite_database.db";

    @Override
    public long addFavourite(SQLiteDatabase sqLiteDatabase, ItemsArrayObject itemsArrayObject) {
        ItemsArrayObject itemsArrayObject_check = getFavouriteById(sqLiteDatabase, itemsArrayObject.getId());

        if (itemsArrayObject_check == null) {
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.FavouriteEntry.ID, itemsArrayObject.getId());
            values.put(DatabaseContract.FavouriteEntry.TITLE, itemsArrayObject.getTitle());
            values.put(DatabaseContract.FavouriteEntry.NAME, itemsArrayObject.getName());
            values.put(DatabaseContract.FavouriteEntry.POSTER_PATH, itemsArrayObject.getPoster_path());
            values.put(DatabaseContract.FavouriteEntry.TYPE, itemsArrayObject.getType());
            return sqLiteDatabase.insert(DatabaseContract.FavouriteEntry.TABLE_NAME, null, values);
        }
        // itemsArrayObject is already inside the SQLiteDatabase
        return -1;
    }

    @Override
    public long removeFavourite(SQLiteDatabase sqLiteDatabase, String id) {
        sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(DatabaseContract.FavouriteEntry.TABLE_NAME, "id = ?",new String[] {id});
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_TABLE_FAVOURITES =
            "CREATE TABLE " + DatabaseContract.FavouriteEntry.TABLE_NAME + " (" +
                    DatabaseContract.FavouriteEntry.ID + " TEXT PRIMARY KEY," +
                    DatabaseContract.FavouriteEntry.TITLE + " TEXT," +
                    DatabaseContract.FavouriteEntry.NAME + " TEXT," +
                    DatabaseContract.FavouriteEntry.POSTER_PATH + " TEXT," +
                    DatabaseContract.FavouriteEntry.TYPE + " TEXT)";

    public void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(CREATE_TABLE_FAVOURITES);
        } catch (SQLiteException exception) {
            Log.e("DEBUG", "DataBase ALREADY CREATED");
        }
    }

    private static final String DELETE_TABLE_FAVOURITES = "DROP TABLE IF EXISTS " + DatabaseContract.FavouriteEntry.TABLE_NAME;

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DELETE_TABLE_FAVOURITES);
        onCreate(database);
    }

    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onUpgrade(database, oldVersion, newVersion);
    }

    @Override
    public List<ItemsArrayObject> getFavourites(SQLiteDatabase sqLiteDatabase) {
        List<ItemsArrayObject> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + DatabaseContract.FavouriteEntry.TABLE_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ItemsArrayObject itemsArrayObject = new ItemsArrayObject(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );

            list.add(itemsArrayObject);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    @Override
    public ItemsArrayObject getFavouriteById(SQLiteDatabase sqLiteDatabase, String id) {
        String[] projection = {
                DatabaseContract.FavouriteEntry.ID,
                DatabaseContract.FavouriteEntry.TITLE,
                DatabaseContract.FavouriteEntry.NAME,
                DatabaseContract.FavouriteEntry.POSTER_PATH,
                DatabaseContract.FavouriteEntry.TYPE,
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DatabaseContract.FavouriteEntry.ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DatabaseContract.FavouriteEntry.ID + " DESC";

        Cursor cursor = sqLiteDatabase.query(
                DatabaseContract.FavouriteEntry.TABLE_NAME,
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder              // The sort order
        );

        ItemsArrayObject itemsArrayObject = null;
        while (cursor.moveToNext()) {
            itemsArrayObject = new ItemsArrayObject(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
        }
        cursor.close();
        return itemsArrayObject;
    }

    public boolean isFavourite(SQLiteDatabase sqLiteDatabase, String id) {
        ItemsArrayObject itemsArrayObject_check = getFavouriteById(sqLiteDatabase, id);
        return itemsArrayObject_check != null;
    }
}
