package com.example.opeyemi.league;

/**
 * Created by opeyemi on 26/05/2016.
 */
public class Champion {

    public Champion(String name/*, String lore , String winRate,  String imageUrl*/){

        this.name = name;
        /*
        this.lore = lore;
        this.winRate = winRate;
        this.imageUrl = imageUrl;
        */
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

    public String getWinRate() {
        return winRate;
    }

    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }

    private String winRate;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String imageUrl;
}
