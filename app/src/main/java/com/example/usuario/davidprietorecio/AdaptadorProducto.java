package com.example.usuario.davidprietorecio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usuario on 12/12/2017.
 */

public class AdaptadorProducto extends BaseAdapter{

    Context context;
    List<Producto> listaProducto;

    public AdaptadorProducto(Context context, List<Producto> listaProdcto) {
        this.context = context;
        this.listaProducto = listaProdcto;
    }

    @Override
    public int getCount() {
        return listaProducto.size();
    }

    @Override
    public Object getItem(int i) {
        return listaProducto.get(i);
    }

    @Override
    public long getItemId(int i) {
        Producto p=(Producto)getItem(i);
        long result = p.getIdProductto();
        return result;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Declaraciones
        View vista=view;
        ImageView im;
        TextView tvTit,tvDes,tvPrecio;

        //Dar valor
        LayoutInflater lf=LayoutInflater.from(context);
        vista=lf.inflate(R.layout.itemproducto,null);

        //Buscar en el layout
        tvTit=(TextView)vista.findViewById(R.id.tvTitulo);
        tvDes=(TextView)vista.findViewById(R.id.tvDescripcion);
        tvPrecio=(TextView)vista.findViewById(R.id.tvPrecio);
        im=(ImageView)vista.findViewById(R.id.ivImagen);

        tvTit.setText(listaProducto.get(i).getNombreProducto().toString());
        tvDes.setText(listaProducto.get(i).getDescripcion().toString());
        tvPrecio.setText(String.valueOf(listaProducto.get(i).getPrecio()));
        im.setImageResource(listaProducto.get(i).getImagen());

        return vista;
    }
}
