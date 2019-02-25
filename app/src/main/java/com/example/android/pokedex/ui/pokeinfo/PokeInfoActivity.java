package com.example.android.pokedex.ui.pokeinfo;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pokedex.R;
import com.example.android.pokedex.data.entities.Pokemon;
import com.example.android.pokedex.data.entities.Sprites;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PokeInfoActivity
    extends AppCompatActivity
    implements PokeInfoView {

    private TextView nameTextView;
    private TextView idTextView;
    private TextView nameTagTextView;
    private TextView idTagTextView;

    private CheckBox shinyChechBox;

    private ImageView backImageView;
    private ImageView frontImageView;
    private ProgressDialog progressDoalog;

    private PokeInfoPresenter pokeInfoPresenter;
    private Pokemon pokemon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeinfo);

        String pokemonName =  getIntent().getStringExtra("formatted_name");

        idTagTextView = (TextView) findViewById(R.id.tv_idTag);
        idTextView = (TextView) findViewById(R.id.text_view_id);
        nameTagTextView = (TextView) findViewById(R.id.tv_nameTag);
        nameTextView = (TextView) findViewById(R.id.text_view_name);

        shinyChechBox = (CheckBox) findViewById(R.id.chbx_shiny);

        frontImageView = (ImageView) findViewById(R.id.imageView_frontdefault);
        backImageView = (ImageView) findViewById(R.id.imageView_backdefault);

        // Set up progress before call
        progressDoalog = new ProgressDialog(PokeInfoActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();

        pokeInfoPresenter = new PokeInfoPresenterImplementation(this);
        pokeInfoPresenter.getPokemonInfo(pokemonName);


        shinyChechBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPokemonImage();
            }
        });
    }


    @Override
    public void setPokemonInfoOnScreen(Pokemon pokemon) {

        this.pokemon = pokemon;
        progressDoalog.dismiss();

        setPokemonImage();

        idTagTextView.setVisibility(TextView.VISIBLE);
        idTextView.setText(
                pokemon.getPokemonId() + "");

        nameTagTextView.setVisibility(TextView.VISIBLE);
        nameTextView.setText(
                capitalize(pokemon.getPokemonName())
        );

        shinyChechBox.setVisibility(View.VISIBLE);
    }


    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() +
                string.substring(1);
    }

    private String printArrayListElements(
            Sprites list) {

        return list.getBackDefault() + "\n" + list.getFrontDefault();
    }


    private void setPokemonImage() {
        String frontImage;
        String backImage;

        if (shinyChechBox.isChecked()) {
            frontImage = pokemon.getSpritesURL().getFrontShinyDefault();
            backImage = pokemon.getSpritesURL().getBackShinyDefault();
        } else {
            frontImage = pokemon.getSpritesURL().getFrontDefault();
            backImage = pokemon.getSpritesURL().getBackDefault();
        }


        Picasso.with(getBaseContext())
                .load(backImage)
                .into(backImageView);

        Picasso.with(getBaseContext())
                .load(frontImage)
                .into(frontImageView);
    }
}
