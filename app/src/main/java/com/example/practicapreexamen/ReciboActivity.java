package com.example.practicapreexamen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReciboActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);

        TextView textView = findViewById(R.id.nombref);

        Intent intent = getIntent();
        String userInput = intent.getStringExtra("nombre");
        textView.setText(userInput);

        EditText numeroReciboEditText = findViewById(R.id.numeroReciboEditText);
        EditText nombreEditText = findViewById(R.id.nombreEditText);
        EditText horasNormalesEditText = findViewById(R.id.horasNormalesEditText);
        EditText horasExtraEditText = findViewById(R.id.horasExtraEditText);
        RadioGroup puestoRadioGroup = findViewById(R.id.puestoRadioGroup);
        Button calcularButton = findViewById(R.id.calcularButton);
        Button limpiarButton = findViewById(R.id.LimpiarButton);
        Button regresarButton = findViewById(R.id.RegresarButton);

        EditText subtotalEditText = findViewById(R.id.subtotalEditText);
        subtotalEditText.setFocusable(false);
        subtotalEditText.setClickable(false);

        EditText impuestoEditText = findViewById(R.id.impuestoEditText);
        impuestoEditText.setFocusable(false);
        impuestoEditText.setClickable(false);

        EditText totalEditText = findViewById(R.id.totalEditText);
        totalEditText.setFocusable(false);
        totalEditText.setClickable(false);

        calcularButton.setOnClickListener(v -> {
            if (!numeroReciboEditText.getText().toString().isEmpty() &&
                    !nombreEditText.getText().toString().isEmpty() &&
                    !horasNormalesEditText.getText().toString().isEmpty() &&
                    !horasExtraEditText.getText().toString().isEmpty() &&
                    puestoRadioGroup.getCheckedRadioButtonId() != -1) {

                int numeroRecibo = Integer.parseInt(numeroReciboEditText.getText().toString());
                String nombre = nombreEditText.getText().toString();
                double horasTrabajadasNormales = Double.parseDouble(horasNormalesEditText.getText().toString());
                double horasTrabajadasExtra = Double.parseDouble(horasExtraEditText.getText().toString());
                int puesto;
                int checkedId = puestoRadioGroup.getCheckedRadioButtonId();
                if (checkedId == R.id.auxiliarRadioButton) {
                    puesto = 1;
                } else if (checkedId == R.id.albanilRadioButton) {
                    puesto = 2;
                } else if (checkedId == R.id.ingObraRadioButton) {
                    puesto = 3;
                } else {
                    puesto = 0;
                }


                ReciboNomina recibo = new ReciboNomina(horasTrabajadasNormales, horasTrabajadasExtra, puesto);

                recibo.calcularSubtotal();
                recibo.calcularImpuesto();
                recibo.calcularTotal();

                // Actualizar los EditTexts con los valores calculados
                subtotalEditText.setText(String.valueOf(recibo.getSubtotal()));
                impuestoEditText.setText(String.valueOf(recibo.getImpuesto()));
                totalEditText.setText(String.valueOf(recibo.getTotal()));

            } else {
                Toast.makeText(ReciboActivity.this, "Por favor, rellene todos los campos.", Toast.LENGTH_SHORT).show();
            }
        });

        limpiarButton.setOnClickListener(v -> {
            numeroReciboEditText.getText().clear();
            nombreEditText.getText().clear();
            horasNormalesEditText.getText().clear();
            horasExtraEditText.getText().clear();

            puestoRadioGroup.clearCheck();

            subtotalEditText.getText().clear();
            impuestoEditText.getText().clear();
            totalEditText.getText().clear();
        });

        regresarButton.setOnClickListener(v -> finish());
    }
}
