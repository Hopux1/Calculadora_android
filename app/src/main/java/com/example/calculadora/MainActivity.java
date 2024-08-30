package com.example.calculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private TextView tv1;
    private RadioButton rb1,rb2,rb3,rb4;
    private ArrayList<Float> numerosGuardados;


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
        numerosGuardados = new ArrayList<Float>();

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);

    }
    public void presion (View v){
        String s1=et1.getText().toString();
        String s2=et2.getText().toString();
        float v1=Float.parseFloat(s1);
        float v2=Float.parseFloat(s2);
        if (rb1.isChecked()){
            float suma=v1+v2;
            tv1.setText("La suma es:" +suma);
        }
        else if(rb2.isChecked()){
            float resta=v1-v2;
            tv1.setText("La resta es: " +resta);
        }
        else if(rb3.isChecked()){
            float divi=v1/v2;
            tv1.setText("La division es: " + divi);
        }else {
            rb4.isChecked();
            float multi=v1*v2;
            tv1.setText("La multiplicacion es: " +multi);
        }


    }
    public void guardarNumeros(View v) {
        // Obtener los valores ingresados
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        // Convertir los valores a enteros y agregar al ArrayList
        try {
            float numero1 = Float.parseFloat(s1);
            float numero2 = Float.parseFloat(s2);
            numerosGuardados.add(numero1);
            numerosGuardados.add(numero2);

            // Mostrar un mensaje de confirmación
            Toast.makeText(this, "Números guardados"+numerosGuardados, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}