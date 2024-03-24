package com.FedyCal.Database;

import com.FedyCal.DataStructures.ItemsArrayObject;

import java.util.List;

public interface LoaderInterface {
    List<ItemsArrayObject> getFavourites();
    void addToFavourite(ItemsArrayObject itemsArrayObject);
    void removeFavourite(String id);
    boolean isFavourite(String id);
}
