package com.example.jordansilva.joquemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int contEmpate = 0;
    private int cont = 0;
    private int contUser = 0;
    private ImageView imageResultado;
    private TextView textoResultado;
    private TextView textContUsuario;
    private TextView textContApp;
    private TextView textContEmpate;
    private String[] opcoes = {"Pedra", "Papel", "Tesoura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageResultado = (ImageView) findViewById(R.id.imageResultado);
        textoResultado = (TextView) findViewById(R.id.textResultado);
        textContUsuario = findViewById(R.id.textContUsuario);
        textContApp = findViewById(R.id.textContApp);
        textContEmpate = findViewById(R.id.textContEmpate);
    }

    public void selecionarPedra( View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "Pedra" : imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" : imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" : imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp.equals("Pedra")  && escolhaUsuario.equals("Tesoura")) ||
                (escolhaApp.equals("Papel") && escolhaUsuario.equals("Pedra"))   ||
                (escolhaApp.equals("Tesoura") && escolhaUsuario.equals("Papel"))

                ) {textoResultado.setText("Você perdeu!!");

                cont = Integer.parseInt(textContApp.getText().toString() ) + 1;
                textContApp.setText(String.valueOf(cont) ) ;
                Log.d("Teste", "Cont: " + cont);
        }

        else if (

                (escolhaUsuario.equals("Pedra") && escolhaApp.equals("Tesoura")) ||
                (escolhaUsuario.equals("Papel") && escolhaApp.equals("Pedra"))   ||
                (escolhaUsuario.equals("Tesoura") && escolhaApp.equals("Papel"))

                ) {textoResultado.setText("Você foi o ganhador!");

                contUser = Integer.parseInt(textContUsuario.getText().toString() ) + 1;
                textContUsuario.setText(String.valueOf(contUser) );
                Log.d("Teste cont Usuario", "Cont Usuario: " + contUser);

        }

        else
        {textoResultado.setText("Empatamos!");
            contEmpate = Integer.parseInt(textContEmpate.getText().toString() ) + 1;
            textContEmpate.setText(String.valueOf(contEmpate));
            Log.d("Teste cont Empate", "Cont Empate: " + contEmpate);
        }

    }

}
