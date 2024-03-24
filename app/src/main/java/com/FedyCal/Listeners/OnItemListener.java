package com.FedyCal.Listeners;

import com.FedyCal.DataStructures.itemsDetailObject;

/**
 * interface used to wait for the api response relating to the details of a film / series.
 * For ItemInformationActivity
 */

public interface OnItemListener {
    void onResponse(itemsDetailObject response);
    void onError(String message);
}
