package br.com.uniftec.fteclistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.model.Filme;

/**
 * Created by daniel on 21/09/17.
 */

public class MovieAdapter extends ArrayAdapter<Filme> {

    private LayoutInflater layoutInflater;

    public MovieAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Filme> objects) {
        super(context, resource, objects);

        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_movies, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.img_movie);
        TextView textView = (TextView) convertView.findViewById(R.id.name_movie);

        Filme filme = getItem(position);

        textView.setText(filme.getTitulo());

        Log.i("IMG: ------------", filme.getImagem());



        int idImagem = getContext().getResources().getIdentifier(filme.getImagem(), "drawable", getContext().getPackageName());


        image.setImageDrawable(getContext().getDrawable(idImagem));


        return convertView;
    }
}
