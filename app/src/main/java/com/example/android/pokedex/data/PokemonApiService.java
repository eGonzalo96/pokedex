package com.example.android.pokedex.data;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;

import com.example.android.pokedex.data.entities.Pokemon;

public interface PokemonApiService {

    @GET("{pokemon}")
    Call<Pokemon> getPokemonInfo(@Path("pokemon") String pokemon);

}
