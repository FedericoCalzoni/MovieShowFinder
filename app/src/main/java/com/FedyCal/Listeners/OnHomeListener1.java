package com.FedyCal.Listeners;

import com.FedyCal.APIMetods.ListsApiResponse;

/**
 * interface used to wait for the receipt of the api response relating to the first recyclerview
 * of the fragment home
 */

public interface OnHomeListener1 {
    void onResponse(ListsApiResponse response);
    void onError(String message);
}
