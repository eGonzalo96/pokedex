package com.example.android.pokedex.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pokemon {

    @SerializedName("name")
    public String pokemonName;

    @SerializedName("id")
    public int pokemonId;

    @SerializedName("sprites")
    public Sprites spritesURL;

    public Pokemon(String x, int i) {
        this.pokemonId = i;
        this.pokemonName = x;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public Sprites getSpritesURL() { return spritesURL; }

}
