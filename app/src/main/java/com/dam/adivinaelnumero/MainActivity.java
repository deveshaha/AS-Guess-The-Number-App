package com.dam.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int MAX = 100;
    public static int MIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_intentos = findViewById(R.id.txt_intentos);
        TextView txt_adivina = findViewById(R.id.txt_adivina);
        EditText edit_txt = findViewById(R.id.edit_txt);
        Button btn_prueba = findViewById(R.id.btn_prueba);
        RelativeLayout fondo = findViewById(R.id.main);

        int randnum = getRandnum();
        System.out.println(randnum);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intentos = 5;
                txt_intentos.setText(String.format(getString(R.string.intentos_txt), String.valueOf(randnum)));

                while (intentos > 0 ) {
                    System.out.println("Numero de intentos: " + intentos);

                    if (Integer.parseInt(edit_txt.getText().toString()) == randnum) {
                        txt_adivina.setText(R.string.numero_acertado);
                        fondo.setBackgroundColor(R.color.acertado_backgrund);
                    } else if (Integer.parseInt(edit_txt.getText().toString()) > randnum){
                        txt_adivina.setText(R.string.numero_pequeno);
                        intentos--;
                    } else if (Integer.parseInt(edit_txt.getText().toString()) < randnum){
                        txt_adivina.setText(R.string.numero_grande);
                        txt_intentos.setText(String.format(getString(R.string.intentos_txt), String.valueOf(intentos)));
                        intentos--;
                    }

                    if (intentos == 0){
                        txt_adivina.setText(String.format(getString(R.string.numero_agotado), randnum));
                        fondo.setBackgroundColor(R.color.no_acertado_background);
                    }
                }

            }
        };

        btn_prueba.setOnClickListener(listener);

    }

    private int getRandnum() {
        Random rd = new Random();
        int randnum = rd.nextInt(MAX - MIN + 1) + MIN;
        System.out.println(randnum);
        return randnum;
    }


}