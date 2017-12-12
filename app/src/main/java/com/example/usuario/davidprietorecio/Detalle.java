package com.example.usuario.davidprietorecio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    private Producto producto;
    private TextView tvNombre,tvPrecio,tvDescripcion,tvCodigo;
    private ImageView im;
    private ImageButton bAtras,bAlante;

    private int puntero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        puntero=-1;

        if(getIntent().getExtras().getSerializable("objeto")!=null) {
            producto = (Producto) getIntent().getExtras().getSerializable("objeto");
        }else{
            producto=null;
        }

        tvNombre=(TextView)findViewById(R.id.tvDTit);
        tvPrecio=(TextView)findViewById(R.id.tvDPrecio);
        tvDescripcion=(TextView)findViewById(R.id.tvDDescrip);
        tvCodigo=(TextView)findViewById(R.id.tvDcodigo);

        im=(ImageView)findViewById(R.id.imDimagen);

        bAtras=(ImageButton)findViewById(R.id.bDAtras);
        bAlante=(ImageButton)findViewById(R.id.bDAdelante);

        tvNombre.setText(producto.getNombreProducto());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));
        tvDescripcion.setText(producto.getDescripcion());
        tvCodigo.setText(String.valueOf(producto.getIdProductto()));

        im.setImageResource(producto.getImagen());
    }

    public void alante (View view){
        if(puntero<producto.getGaleriaImagenes().length-1) {
           puntero++;
            im.setImageResource(producto.getGaleriaImagenes()[puntero]);
        }else{
            puntero=-1;
            im.setImageResource(producto.getImagen());
        }
    }

    public void atras (View view){
        if(puntero>0) {
            puntero--;
            im.setImageResource(producto.getGaleriaImagenes()[puntero]);
        }else if(puntero==0){
            puntero--;
            im.setImageResource(producto.getImagen());
        }else{
            puntero=producto.getGaleriaImagenes().length-1;
            im.setImageResource(producto.getGaleriaImagenes()[puntero]);
        }
    }

    @Override
    public void onBackPressed() {
        Intent volver = new Intent(getApplicationContext(), MainActivity.class);
        finish();
        startActivity(volver);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }
}
