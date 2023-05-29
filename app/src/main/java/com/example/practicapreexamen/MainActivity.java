package com.example.practicapreexamen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button entrarButton;
    private Button salirButton;
    private EditText totalEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalEditText = findViewById(R.id.totalEditText);
        entrarButton = findViewById(R.id.entrarButton);
        salirButton = findViewById(R.id.salirButton);

        entrarButton.setOnClickListener(v -> {
            if (!totalEditText.getText().toString().isEmpty()) {
                Intent intent = new Intent(MainActivity.this, ReciboActivity.class);
                intent.putExtra("nombre", totalEditText.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Por favor ingrese el nombre del trabajador", Toast.LENGTH_SHORT).show();
            }
        });

        salirButton.setOnClickListener(v -> finish());
    }
}
