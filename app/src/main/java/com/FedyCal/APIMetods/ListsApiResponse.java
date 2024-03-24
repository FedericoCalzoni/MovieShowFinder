package com.FedyCal.APIMetods;

import com.FedyCal.DataStructures.ItemsArrayObject;

import java.util.List;

/**
 * It is used to receive a list as a result from the API.
 */
public class ListsApiResponse {
    List<ItemsArrayObject> results = null;
    public List<ItemsArrayObject> getResults() {
        return results;
    }
}

