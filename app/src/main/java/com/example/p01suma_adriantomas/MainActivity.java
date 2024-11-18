package com.example.p01suma_adriantomas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void suma(View view){
        //Definimos las variables que vamos a utilizar
        int num1, num2, suma;
        //Asignamos las variables a su vista respectiva
        EditText n1 = findViewById(R.id.eTNum1);
        EditText n2 = findViewById(R.id.eTNum2);
        TextView tv = findViewById(R.id.tVResultado);

        try {
            // Validar que los campos no estén vacíos
            if (n1.getText().toString().trim().isEmpty() ||
                    n2.getText().toString().trim().isEmpty()) {
                mostrarAlerta("Error", "Introduce un número en ambos campos");
            }

            // Convertir y parsear los números
            num1 = Integer.parseInt(n1.getText().toString().trim());
            num2 = Integer.parseInt(n2.getText().toString().trim());

            // Realizar suma
            suma = num1 + num2;

            // Mostrar resultado
            tv.setText(String.format("El resultado es: " + suma));

            // Limpiamos los campos para facilitar su uso
            n1.setText("");
            n2.setText("");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Solo se permiten números enteros, " +
                    "comprueba que no existan espacios entre los dígitos");
        }
    }

    public void salirApp(View view){
        finish();
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        new AlertDialog.Builder(this)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", null)
                .show();
    }

}