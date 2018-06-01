package com.example.jordansilva.joquemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageResultado;
    private int cont;
    private int contUser;
    private TextView textoResultado;
    private TextView textContUsuario;
    private TextView textContApp;
    private String[] opcoes = {"Pedra", "Papel", "Tesoura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageResultado = (ImageView) findViewById(R.id.imageResultado);
        textoResultado = (TextView) findViewById(R.id.textResultado);
        textContUsuario = findViewById(R.id.textContUsuario);
        textContApp = findViewById(R.id.textContApp);
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

        }

        else
        {textoResultado.setText("Empatamos!"); }


    }

}
