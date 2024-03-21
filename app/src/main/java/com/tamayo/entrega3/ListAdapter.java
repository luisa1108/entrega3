package com.tamayo.entrega3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, NumeroTelefono, Biografias;
    int[] IdImage;
    LayoutInflater inflater;
    public ListAdapter (Context contexto, String[] nombres, String[] numeroTelefono, int[] idImage, String[] biografias){

        this.Contexto = contexto;
        this.Nombres = nombres;
        this.NumeroTelefono = numeroTelefono;
        this.IdImage = idImage;
        this.Biografias = biografias;
        inflater = LayoutInflater.from(Contexto);
    }

    @Override
    public int getCount() {
        return Nombres.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_item,null);
        ImageView fotoPerfil = view.findViewById(R.id.fotoperfil);
        TextView nombreUsuario = view.findViewById(R.id.nombre);
        TextView telUsuario = view.findViewById(R.id.telefono);
        fotoPerfil.setImageResource(IdImage[i]);
        nombreUsuario.setText(Nombres[i]);
        telUsuario.setText(NumeroTelefono[i]);
        return view;
    }
}
