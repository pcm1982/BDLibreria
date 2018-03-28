package com.example.usuario.bdlibreria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Usuario on 28/03/2018.
 */

public class DBLibros {
    private static final String TABLA = "libros";
    //Atributos
    private SQLiteDatabase db = null;
    private DatabaseHelper dbhelper = null;
    //Contexto
    Context context;

    public DBLibros(Context ctx) {
        this.context = ctx;
        //crea una instancia del helper
        dbhelper = new DatabaseHelper(context);
        //crea un objeto SQLiteDatabase para operar
        // contra la base de datos
        db = dbhelper.getWritableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    public long altaLibro(String titulo, String autor, double precio) {
        //crea el contentvalues y añade una entrada
        // por cada dato del libro a guardar
        ContentValues initialValues = new ContentValues();
        initialValues.put("titulo", titulo);
        initialValues.put("autor", autor);
        initialValues.put("precio", precio);
        return db.insert(TABLA, null, initialValues);
    }

    public boolean borrarLibro(int id) {
        //elimina el libro a partir del id
        return db.delete(TABLA, "_id =" + id, null)>0;
    }

    public Libro recuperarLibroPorTitulo(String titulo) {
        float valor = 0.0f;
        Libro lib = null;
        Cursor c = db.query(TABLA, new String[]{"_id", "autor","precio"},"titulo =?",
                new String[]{titulo}, null, null, null);
        //el curso apunta a la posición anterior al primer registro
        // debe desplazarlo al siguiente registro para
        // apuntar al primero
        if (c.moveToNext()) {
            lib = new Libro(c.getInt(0), titulo, c.getString(1), c.getDouble(2));
        }
        return lib;
    }

    public Cursor recuperarLibros() {
        //aunque no se utilice, se debe recuperar también
        // el campo _id
        return db.query(TABLA, new String[]{"_id","titulo", "precio","autor"},null, null, null, null, null);

    }
}

