package com.skripsi.robby.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView txtTitle, txtScore, txtRuntime, txtLanguage, txtDesc;
    ImageView imgFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txt_title);
        txtScore = findViewById(R.id.txt_score);
        txtRuntime = findViewById(R.id.txt_runtime);
        txtLanguage = findViewById(R.id.txt_language);
        txtDesc = findViewById(R.id.txt_desc);
        imgFilm = findViewById(R.id.img_film);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.app_detail);

        Intent intent = getIntent();
        Film film = intent.getParcelableExtra("Film");

        int photo = film.getPhoto();
        String title = film.getTitle();
        String desc = film.getDescription();
        String data_fact = film.getFact();

        String[] arrFact = data_fact.split("-");

        imgFilm.setImageResource(photo);
        txtTitle.setText(title);
        txtDesc.setText(desc);
        txtScore.setText(arrFact[0]+"%");
        txtLanguage.setText(arrFact[1]);
        txtRuntime.setText(arrFact[2]);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return super.onOptionsItemSelected(item);
    }
}
