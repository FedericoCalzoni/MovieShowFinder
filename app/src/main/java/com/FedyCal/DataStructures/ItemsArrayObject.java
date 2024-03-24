package com.FedyCal.DataStructures;

/**
 * The information of the previews are stored here. for both movies and tv series.
 */
public class ItemsArrayObject {
    String id = "";
    String title = "";
    String poster_path = "";
    String name = "";
    String type = "";

    public ItemsArrayObject(){
    }

    public ItemsArrayObject(String id, String title, String name, String poster_path, String type) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}