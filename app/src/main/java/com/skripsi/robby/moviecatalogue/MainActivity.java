package com.skripsi.robby.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private FilmAdapter adapter;
    private String[] dataTitle;
    private String[] dataDescription;
    private String[] dataFact;
    private TypedArray dataPhoto;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new FilmAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        prepare();
        addItem();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, films.get(i).getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        films = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setTitle(dataTitle[i]);
            film.setDescription(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

}
