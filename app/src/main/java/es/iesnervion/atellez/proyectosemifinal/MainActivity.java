package es.iesnervion.atellez.proyectosemifinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombre, editTextNumero;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEnviar = (Button) findViewById(R.id.btnEntrar);

        editTextNombre = (EditText) findViewById(R.id.nomUsuario);
        editTextNumero = (EditText) findViewById(R.id.numContacto);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNombre.getText().toString().isEmpty() || editTextNumero.getText().toString().isEmpty()) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No puedes dejar campos vacios", Toast.LENGTH_SHORT);
                    toast1.show();
                } else {
                    if(editTextNumero.getText().length()<9){
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Introduzca un número teléfono válido", Toast.LENGTH_SHORT);
                        toast1.show();
                    }else{

                        SharedPreferences misPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = misPref.edit();
                        editor.putString("nomUsuario",editTextNombre.getText().toString());
                        editor.putString("numContacto",editTextNumero.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(v.getContext(), Activity_emergencia.class);
                        startActivity(intent);
                    }
                }
            }
            });
        }
    }
