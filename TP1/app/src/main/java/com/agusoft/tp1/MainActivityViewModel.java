package com.agusoft.tp1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {
private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void enviar(String texto){
        if(texto.length()==0){
            Toast.makeText(context, "Porfavor ingresar una palabra para traducir.", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(context,Traducir.class);
            intent.putExtra("texto",texto);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
