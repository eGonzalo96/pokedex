package com.example.android.pokedex.ui.pokeinfo;

import android.widget.Toast;

import com.example.android.pokedex.data.entities.Pokemon;

public class PokeInfoPresenterImplementation implements PokeInfoPresenter {

    PokeInfoView pokeInfoView;
    PokeInfoModel pokeInfoModel = new PokeInfoModel();

    PokeInfoPresenterImplementation(
            PokeInfoView piv) {
        this.pokeInfoView = piv;
    }


    @Override
    public void getPokemonInfo(String pokemonName) {

        pokeInfoModel.getPokemonFromServer(pokemonName,

                new PokeInfoModel.PokeInfoModelListener() {
                    @Override
                    public void onSuccess(Pokemon pokeInfo) {
                        pokeInfoView.setPokemonInfoOnScreen(pokeInfo);
                    }

                    @Override
                    public void onFailure() {
                        pokeInfoView.setPokemonInfoOnScreen(new Pokemon("hola", 10));
                    }
                });

    }
}
