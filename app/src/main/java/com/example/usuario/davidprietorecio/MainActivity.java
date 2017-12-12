package com.example.usuario.davidprietorecio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listV;
    private ArrayList<Producto> listaProduc;
    private AdaptadorProducto adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV=(ListView)findViewById(R.id.idlista);

        listaProduc=new ArrayList<Producto>();

        int[] galeria={R.drawable.galeria_tv1,R.drawable.galeria_tv2,R.drawable.galeria_tv3};
        Producto p=new Producto(1,R.drawable.televisor_lg,"Televisor LG F21-40","Televisor imagen 4K de 40 pulgadas 400Mhz",399,galeria);
        int[] galeria1={R.drawable.galeria_microcadena1,R.drawable.galeria_microcadena2,R.drawable.galeria_microcadena3};
        Producto p1=new Producto(2,R.drawable.minicadena_sony,"Microcadena Sony HT-100sd","Cadena musical conexión USB y iPod 40W",199,galeria1);
        int[] galeria2={R.drawable.galeria_plancha1,R.drawable.galeria_plancha2,R.drawable.galeria_plancha3};
        Producto p2=new Producto(3,R.drawable.plancha_rowenta,"Plancha Rowenta Soft FX-1","Plancha profesional 7 funciones de planchado 1800W",90,galeria2);
        int[] galeria3={R.drawable.galeria_portatil1,R.drawable.galeria_portatil2,R.drawable.galeria_portatil3,R.drawable.galeria_portatil4};
        Producto p3=new Producto(4,R.drawable.portatil_acer,"Ordenador Portatil Acer R235","Ordenador Portatil Acer I5, 8GB, SSD240GB",589.90,galeria3);

        listaProduc.add(p);
        listaProduc.add(p1);
        listaProduc.add(p2);
        listaProduc.add(p3);

        adaptador=new AdaptadorProducto(getApplicationContext(),listaProduc);
        listV.setAdapter(adaptador);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),Detalle.class);
                Producto productoAux=(Producto)adapterView.getItemAtPosition(i);
                intent.putExtra("objeto", productoAux);
                finish();
                startActivity(intent);overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);

            }
        });
    }
}
