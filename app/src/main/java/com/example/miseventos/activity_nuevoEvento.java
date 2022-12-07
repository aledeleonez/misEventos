package com.example.miseventos;

import static com.example.miseventos.MainActivity.eventos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;

public class activity_nuevoEvento extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_evento);

        Button btGuardar = findViewById(R.id.bt_guardar);
        btGuardar.setOnClickListener(this);
        Button btCerrar = findViewById(R.id.bt_cerrar);
        ImageButton btImagen = findViewById(R.id.imageButton);
        btImagen.setOnClickListener(this);

    }

    private void nuevoEvento(Evento evento, Bitmap img){
        EditText nombre = findViewById(R.id.txt_nombre);
        EditText descripcion = findViewById(R.id.txt_desc);
        EditText direccion = findViewById(R.id.txt_dir);
        EditText fecha = findViewById(R.id.txt_fecha);
        EditText precio = findViewById(R.id.txt_precio);
        EditText aforo = findViewById(R.id.txt_aforo);
        ImageButton imagen = findViewById(R.id.imageButton);

        nombre.setText(evento.getNombre());
        descripcion.setText(evento.getDescripcion());
        direccion.setText(evento.getDireccion());
        fecha.setText((CharSequence) evento.getFecha());
        aforo.setText(String.valueOf(evento.getAforo()));
        precio.setText(String.valueOf(evento.getPrecio()));
        imagen.setImageBitmap(img);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_guardar:
                EditText etNombre = findViewById(R.id.txt_nombre);
                EditText etDescripcion = findViewById(R.id.txt_desc);
                EditText etDireccion = findViewById(R.id.txt_dir);
                EditText etFecha = findViewById(R.id.txt_fecha);
                EditText etPrecio = findViewById(R.id.txt_precio);
                EditText etAforo = findViewById(R.id.txt_aforo);
                ImageButton ibImagen = findViewById(R.id.imageButton);

                if (etPrecio.getText().toString().equals("")) {
                    Toast.makeText(this, "Precio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (etAforo.getText().toString().equals(""))
                    etAforo.setText("0");

                Evento evento = new Evento();
                evento.setNombre(etNombre.getText().toString());
                evento.setDescripcion(etDescripcion.getText().toString());
                evento.setDireccion(etDireccion.getText().toString());
                evento.setPrecio(Float.parseFloat(etPrecio.getText().toString()));
                evento.setAforo(Integer.parseInt(etAforo.getText().toString()));
                evento.setImagen(((BitmapDrawable) ibImagen.getDrawable()).getBitmap());

                eventos.add(evento);

                Toast.makeText(this, "El evento " + evento.getNombre() +
                        " se ha guardado", Toast.LENGTH_LONG).show();

                etNombre.setText("");
                etNombre.requestFocus();
                etDescripcion.setText("");
                etDireccion.setText("");
                etPrecio.setText("");
                etAforo.setText("");
                etFecha.setText("");
                break;
            case R.id.bt_cerrar:
                onBackPressed();
                break;
            case R.id.imageButton:
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                break;
            default:
                break;
        }
    }
}