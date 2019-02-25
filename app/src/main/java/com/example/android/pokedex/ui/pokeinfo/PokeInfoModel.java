package com.example.android.pokedex.ui.pokeinfo;

import com.example.android.pokedex.data.entities.Pokemon;
import com.example.android.pokedex.data.PokemonApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeInfoModel {


    public interface PokeInfoModelListener {
        public void onSuccess(Pokemon pokeInfo);
        public void onFailure();
    }

    Retrofit retrofitObject;
    PokemonApiService pokemonApiService;

    PokeInfoModel() {

        retrofitObject =
                new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonApiService = retrofitObject.create(PokemonApiService.class);
    }


    Pokemon getPokemonFromServer(
            final String pokemonName,
            final PokeInfoModelListener listener) {

        pokemonApiService.getPokemonInfo(pokemonName).enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                if(response.isSuccessful()) {
                    Pokemon info = response.body();

                    if(info != null) {
                        listener.onSuccess(info);
                    }
                } else {
                    listener.onSuccess(new Pokemon(pokemonName + " Doesn't Exist", 666));
                }

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                listener.onFailure();
            }
        });

        return null;
    }

}
