package com.tamayo.entrega3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] fotoPerfil = {
                R.drawable.duki,
                R.drawable.lit,
                R.drawable.tiago,
                R.drawable.wos,
                R.drawable.ysy,
        };
        String[] nombres = {
                "Duki",
                "Lit Killah",
                "Tiago PZK",
                "Wos",
                "Ysy A",
        };
        String[] biografias = {
                "La canción más escuchada de Duki es: She Don´t Give a Fo con 478,905,177 de reproduciones",
                "La canción más escuchada de Lit es: Entre nosotros (junto con Tiago) con 455,237,480 de reproduciones",
                "La canción más escuchada de Tiago es: Entre nosotros (junto con Lit) con 455,237,480 de reproduciones" ,
                "La canción más escuchada de Wos es: Canguro con 92millones de reproduciones",
                "La canción más escuchada de Ysy A es: Flechazo en el centro con 60,548,881 de reproduciones",
        };
        String[] telefonos = {
                "13.4 millones de seguidores",
                "8.9 millones de seguidores",
                "6.7 millones de seguidores",
                "7.2 millones de seguidores",
                "3.1 millones de seguidores",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                Intent EnviarInfo = new Intent(MainActivity.this, UserActivity.class)
                        .putExtra("Nombre: ", nombres[Posicion])
                        .putExtra("Teléfono: ", telefonos[Posicion])
                        .putExtra("Foto de Perfil: ", fotoPerfil[Posicion])
                        .putExtra("Biografia: ", biografias[Posicion]);
                startActivity(EnviarInfo);
            }
        });

    }
}