package com.FedyCal.Listeners;

import com.FedyCal.APIMetods.ListsApiResponse;

/**
 * interface used to wait for the reception of the relative api response given the title
 * of the film. Fragment search.
 */

public interface OnSearchListener {
    void onResponse(ListsApiResponse response);
    void onError(String message);
}
