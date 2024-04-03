package com.tamayo.entrega3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listaPersona;
    HashMap<String, Integer> visitCountMap = new HashMap<>(); // Contador de visitas
    String selectedItemID;

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
                "13.4 M",
                "8.9 M",
                "6.7 M",
                "7.2 M",
                "3.1 M",
        };

        ListAdapter personas = new ListAdapter(MainActivity.this,nombres,telefonos,fotoPerfil,biografias,visitCountMap);
        listaPersona = (ListView) findViewById(R.id.listaUsuario);
        listaPersona.setAdapter(personas);

        listaPersona.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> Lista, View Vista, int Posicion, long Id){

                // Guarda el ID del ítem seleccionado
                selectedItemID = nombres[Posicion];

                if (selectedItemID != null) {
                    int visitCount = visitCountMap.getOrDefault(selectedItemID, 0);
                    visitCountMap.put(selectedItemID, visitCount + 1);
                }

                // Notifica al adaptador que los datos han cambiado
                personas.notifyDataSetChanged();

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
