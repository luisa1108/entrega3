package com.tamayo.entrega3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity{
    String nombre, telefono, biografia;
    int imagen;
    CircleImageView foto;
    TextView textoNombre, textotelefono, textoBiografia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textoNombre = findViewById(R.id.nombre);
        textotelefono = findViewById(R.id.telefono);
        textoBiografia = findViewById(R.id.biografia);
        foto = findViewById(R.id.fotoPerfilUsuario);

        Intent recibir = this.getIntent();
        if(recibir != null){
            nombre = recibir.getStringExtra("Nombre: ");
            telefono = recibir.getStringExtra("Teléfono: ");
            imagen = recibir.getIntExtra("Foto de Perfil: ", R.drawable.duki);
            biografia = recibir.getStringExtra("Biografia: ");

            textoNombre.setText(nombre);
            textotelefono.setText(telefono);
            textoBiografia.setText(biografia);
            foto.setImageResource(imagen);
        }
    }
}
