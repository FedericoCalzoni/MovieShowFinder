package com.FedyCal.Listeners;

/**
 * interface used to wait for the click of an element in the recycler view.
 * each element has an id and a type. the type can be movie / tv
 */

public interface OnMovieClickListener {
    void onMovieClicked(String id, String title, String name, String poster_path, String type);
}
