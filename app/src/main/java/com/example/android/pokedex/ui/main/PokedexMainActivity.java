package com.example.android.pokedex.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.pokedex.R;
import com.example.android.pokedex.ui.pokeinfo.PokeInfoActivity;

public class PokedexMainActivity
        extends AppCompatActivity implements PokemonView {


    PokemonPresenter pokemonPresenter;
    EditText editTextPokemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex_main);

        editTextPokemon = (EditText) findViewById(R.id.edit_text_search);
        Button button = (Button) findViewById(R.id.button_submit);

        pokemonPresenter = new PokemonPresenterImplementation(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = getIntentToInfo().putExtra(
                        "formatted_name",
                        pokemonPresenter.formatPokemonName()
                );

                startActivity(i);
            }
        });

    }


    @Override
    public String getPokemonName() {
        return editTextPokemon.getText().toString();
    }


    private Intent getIntentToInfo() {
        return new Intent(
                this, PokeInfoActivity.class);
    }
}
