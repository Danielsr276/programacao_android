package br.com.uniftec.fteclistview.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.model.Filme;

public class FilmeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILME_PARAMETER = "FILME_PARAMETER";

    private Button fecharButton;
    private Filme filme;
    private TextView textViewTitulo;
    private TextView textViewNota;
    private TextView textViewResumo;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        fecharButton = (Button) findViewById(R.id.button_fechar);

        fecharButton.setOnClickListener(this);

        filme = (Filme) getIntent().getSerializableExtra(FILME_PARAMETER);

        textViewTitulo = (TextView) findViewById(R.id.titulo_id);
        textViewTitulo.setText(filme.getTitulo());

        textViewNota = (TextView) findViewById(R.id.nota_id);
        textViewNota.setText(String.valueOf(filme.getNota()));

        textViewResumo = (TextView) findViewById(R.id.resumo_id);
        textViewResumo.setText(filme.getResumo());

        imageView = (ImageView) findViewById(R.id.image_filme_id);
        //imageView

        String nomeImagem = filme.getImagem();

        String uri = "@drawable/"+nomeImagem;  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());

        Drawable res = getResources().getDrawable(imageResource, null);
        imageView.setImageDrawable(res);
    }

    @Override
    public void onClick(View view) {
        if (view == fecharButton) {
            finish();
        }
    }
}
