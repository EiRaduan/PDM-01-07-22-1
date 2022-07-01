package com.example.meufragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnConversas;
    private Button btnContatos;
    private PrimeiroFragmento conversaFragment;
    private SegundoFragmento contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remove o sombreamento da barra do app
        getSupportActionBar().setElevation(0);
        btnContatos = findViewById(R.id.btn_contatos);
        btnConversas = findViewById(R.id.btn_conversas);

        //instanciando obj para transação (APENAS EXIBE o fragmento)
        conversaFragment = new PrimeiroFragmento();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_conteudo, conversaFragment);
        fragmentTransaction.commit();

        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversaFragment = new PrimeiroFragmento();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo, contatoFragment);
                fragmentTransaction.commit();
            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatoFragment = new SegundoFragmento();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo, conversaFragment);
                fragmentTransaction.commit();
            }
        });
    }
}