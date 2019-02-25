package com.example.android.pokedex.data.entities;

import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("back_default")
    public String frontDefault;

    @SerializedName("front_default")
    public String backDefault;


    public String getFrontDefault() {
        return frontDefault;
    }

    public String getBackDefault() {
        return backDefault;
    }

}
