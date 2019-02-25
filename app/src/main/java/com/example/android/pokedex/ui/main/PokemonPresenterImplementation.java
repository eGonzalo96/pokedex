package com.example.android.pokedex.ui.main;

public class PokemonPresenterImplementation
    implements PokemonPresenter {

    PokemonView pokemonView;
    PokemonModel pokemonModel = new PokemonModel();


    PokemonPresenterImplementation(PokemonView v) {
        this.pokemonView = v;
    }


    @Override
    public String formatPokemonName() {
        return pokemonModel
                .format(pokemonView.getPokemonName());

    }
}
