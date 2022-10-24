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

    static Number number = new Number();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt_intentos = findViewById(R.id.txt_intentos);
        TextView txt_adivina = findViewById(R.id.txt_adivina);
        EditText edit_txt = findViewById(R.id.edit_txt);
        Button btn_prueba = findViewById(R.id.btn_prueba);
        RelativeLayout fondo = findViewById(R.id.main);

        System.out.println("El número es: " + number.randnum);
        txt_intentos.setText(String.format(getString(R.string.intentos_txt), number.intentos));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(edit_txt.getText().toString());

                if (number.checkNumber(num)) {
                    txt_adivina.setText(R.string.numero_acertado);
                    fondo.setBackgroundColor(getResources().getColor(R.color.acertado_backgrund));
                    newNumber();
                } else {
                    number.intentos--;
                    txt_intentos.setText(String.format(getString(R.string.intentos_txt), number.intentos));
                    if (number.intentos == 0) {
                        txt_adivina.setText(String.format(getString(R.string.numero_agotado), number.randnum));
                        fondo.setBackgroundColor(getResources().getColor(R.color.no_acertado_background));
                        newNumber();

                    } else {
                        if (num > number.randnum) {
                            txt_adivina.setText(R.string.numero_grande);
                        } else {
                            txt_adivina.setText(R.string.numero_pequeno);
                        }
                    }
                }
            }

        };

        btn_prueba.setOnClickListener(listener);

    }

    private void newNumber() {
        Button btn_new = findViewById(R.id.btn_prueba);
        btn_new.setText(R.string.new_number);
        btn_new.setVisibility(View.VISIBLE);
        System.out.println("El número es: " + number.randnum);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = new Number();
                recreate();
            }
        };
        btn_new.setOnClickListener(listener);
    }

}