package br.com.uniftec.fteclistview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.uniftec.fteclistview.DataSource;
import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.adapter.MovieAdapter;
import br.com.uniftec.fteclistview.model.Filme;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMovies = (ListView) findViewById(R.id.list_view_movies);

        List<Filme> filmes = DataSource.carregarFilmes(this);

        MovieAdapter movieAdapter = new MovieAdapter(this, 0, filmes);
        listViewMovies.setAdapter(movieAdapter);
        listViewMovies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Filme itemAtPosition = (Filme) adapterView.getItemAtPosition(position);

        Intent intent = new Intent(this, FilmeActivity.class);
        intent.putExtra(FilmeActivity.FILME_PARAMETER,itemAtPosition);
        startActivity(intent);
    }
}
