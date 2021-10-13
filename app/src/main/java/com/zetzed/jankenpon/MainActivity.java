package com.zetzed.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); // 0 1 2

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        String escolhaApp = opcoes[ numero ];

        switch (escolhaApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.rock);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.paper);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.scissors);
                break;
        }

        if( //App Ganhador
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ){
            textoResultado.setText("Você PERDEU :( ");
        }else if(  //Usuário Ganhador
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ){
            textoResultado.setText("Você GANHOU :) ");
        }else{//Empate
            textoResultado.setText("EMPATAMOS ;) ");
        }

        System.out.println("Escolha do usuário: " + escolhaUsuario);
        System.out.println("Item random: " + escolhaApp);

    }
}