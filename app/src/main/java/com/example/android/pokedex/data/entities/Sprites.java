package com.example.android.pokedex.data.entities;

import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("front_default")
    public String frontDefault;

    @SerializedName("back_default")
    public String backDefault;

    @SerializedName("back_shiny")
    public String backShinyDefault;

    @SerializedName("front_shiny")
    public String frontShinyDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public String getBackShinyDefault() {
        return backShinyDefault;
    }

    public String getFrontShinyDefault() {
        return frontShinyDefault;
    }

}
