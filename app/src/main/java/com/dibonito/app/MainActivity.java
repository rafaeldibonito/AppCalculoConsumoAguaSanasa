package com.dibonito.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText rc3;
    private EditText rc3a;
    private EditText m3;
    private EditText conta;
    private RadioButton buttonSim;
    private RadioButton buttonNao;
    private EditText juros;
    private RadioButton buttonCasab;
    private RadioButton buttonCasac;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc3 = findViewById(R.id.rc3);
        rc3a = findViewById(R.id.rc3a);
        m3 = findViewById(R.id.m3);
        conta = findViewById(R.id.conta);
        buttonSim = findViewById(R.id.buttonSim);
        buttonNao = findViewById(R.id.buttonNao);
        juros = findViewById(R.id.juros);
        buttonCasab = findViewById(R.id.buttonCasab);
        buttonCasac = findViewById(R.id.buttonCasac);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SOMA CONTA SEM O JUROS
                int n1 = Integer.parseInt(String.valueOf(rc3.getText()));
                int n2 = Integer.parseInt(String.valueOf(rc3a.getText()));
                int n3 = Integer.parseInt(String.valueOf(m3.getText()));
                float n4 = Float.parseFloat(String.valueOf(conta.getText()));
                float j1 = Float.parseFloat(String.valueOf(juros.getText()));
                int c3 = n1 - n2;
                int c2 = n3 - c3;
                float vm = n4 / n3;
                float vtc2 = vm * c2;
                float vtc3 = vm * c3;

                // SOMA CONTA COM O JUROS
                float conta_juros = (n4 - j1) / n3;
                float conta_juros_c2 = conta_juros * c2;
                float conta_juros_c3 = conta_juros * c3;
                float conta_soma_juros_c2 = conta_juros_c2 + j1;
                float conta_soma_juros_c3 = conta_juros_c3 + j1;

                // FORMATA O NÚMERO
                DecimalFormat arredondar = new DecimalFormat("#.##");


                if (buttonSim.isChecked()) {

                    if (buttonCasab.isChecked()) {

                        AlertDialog.Builder dialogoTotal = new AlertDialog.Builder(MainActivity.this);
                        dialogoTotal.setTitle("CONSUMO");
                        dialogoTotal.setMessage(" CASA B:\n " + c2 + " M³ TOTAL R$: " + arredondar.format(conta_soma_juros_c2) + "\n" + "\n CASA C:\n " + c3 + " M³ TOTAL R$: " + arredondar.format(conta_juros_c3));
                        dialogoTotal.show();
                    }

                    if (buttonCasac.isChecked()) {

                        AlertDialog.Builder dialogoTotal = new AlertDialog.Builder(MainActivity.this);
                        dialogoTotal.setTitle("CONSUMO");
                        dialogoTotal.setMessage(" CASA B:\n " + c2 + " M³ TOTAL R$: " + arredondar.format(conta_juros_c2) + "\n" + "\n CASA C:\n " + c3 + " M³ TOTAL R$: " + arredondar.format(conta_soma_juros_c3));
                        dialogoTotal.show();
                    }

                }


                if (buttonNao.isChecked()) {

                    AlertDialog.Builder dialogoTotal = new AlertDialog.Builder(MainActivity.this);
                    dialogoTotal.setTitle("CONSUMO");
                    dialogoTotal.setMessage(" CASA B:\n " + c2 + " M³ TOTAL R$: " + arredondar.format(vtc2) + "\n" + "\n CASA C:\n " + c3 + " M³ TOTAL R$: " + arredondar.format(vtc3));
                    dialogoTotal.show();

                }

            }
        });

    }

}