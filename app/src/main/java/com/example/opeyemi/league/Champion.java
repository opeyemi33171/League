package com.example.opeyemi.league;

/**
 * Created by opeyemi on 26/05/2016.
 */
public class Champion {

    public Champion(String name, String lore , String imageUrl,String id){

        this.name = name;

        this.lore = lore;

        this.imageUrl = imageUrl;

        this.id = id;



    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    private String lore;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
}
