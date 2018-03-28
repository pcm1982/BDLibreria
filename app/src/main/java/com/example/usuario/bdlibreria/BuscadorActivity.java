package com.example.usuario.bdlibreria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuscadorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        findViewById(R.id.buttonBuscar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo=((EditText)findViewById(R.id.textoTitulo)).getText().toString();
                DBLibros db=new DBLibros(BuscadorActivity.this); Libro lib=db.recuperarLibroPorTitulo(titulo);
                String s="";
                //si se encuentra el libro se muestran sus datos
                // si no, un mensaje de aviso
                if(lib!=null) {
                    s += "Titulo: " + lib.getTitulo() + " Autor: " + lib.getAutor() + " Precio: " + lib.getPrecio();
                }else{
                    s="Libro no encontrado";
                }
                ((TextView)findViewById(R.id.resultado)).setText(s);
                db.close();
            }

        });
        findViewById(R.id.buttonSalir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
    }




}