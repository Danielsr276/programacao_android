package br.com.uniftec.fteclistview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.model.Filme;

public class FilmeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILME_PARAMETER = "FILME_PARAMETER";

    private Button fecharButton;
    private Filme filme;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        fecharButton = (Button) findViewById(R.id.button_fechar);

        fecharButton.setOnClickListener(this);

        filme = (Filme) getIntent().getSerializableExtra(FILME_PARAMETER);

        textView = (TextView) findViewById(R.id.filme_id);

        textView.setText(filme.getTitulo());


    }

    @Override
    public void onClick(View view) {
        if (view == fecharButton) {
            finish();
        }
    }
}
