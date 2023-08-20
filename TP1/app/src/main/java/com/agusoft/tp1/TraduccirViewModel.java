package com.agusoft.tp1;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.agusoft.tp1.modelo.Palabra;

import java.util.ArrayList;
import java.util.List;

public class TraduccirViewModel extends AndroidViewModel {
    private List<Palabra> lista = new ArrayList<>();

    private Context context;

    private MutableLiveData<Palabra> traduccion;
    public TraduccirViewModel(@NonNull Application application) {
        super(application);

        this.context= application.getApplicationContext();
        lista.add(new Palabra("gato","cat",R.drawable.gatoo));
        lista.add(new Palabra("perro","dog",R.drawable.perro));
        lista.add(new Palabra("bicicleta","bike",R.drawable.bicicleta));
        lista.add(new Palabra("auto","car",R.drawable.auto));
        lista.add(new Palabra("helado","icecream",R.drawable.helado));
        lista.add(new Palabra("patineta","skateboard",R.drawable.patineta));
        lista.add(new Palabra("caballo","horse",R.drawable.caballo));
        lista.add(new Palabra("rata","rat",R.drawable.rata));
        lista.add(new Palabra("hamster","hamster",R.drawable.hamster));
        lista.add(new Palabra("burro","donkey",R.drawable.burro));
        lista.add(new Palabra("pizza","pizza",R.drawable.pizza));
        lista.add(new Palabra("pelota","ball",R.drawable.pelota));
        lista.add(new Palabra("gaseosa","soda",R.drawable.gaseosa));
        lista.add(new Palabra("vaca","cow",R.drawable.vaca));
        lista.add(new Palabra("heroe","hero",R.drawable.heroe));
        lista.add(new Palabra("celular","cell phone",R.drawable.celular));
        lista.add(new Palabra("casa","home",R.drawable.casa));
    }

    public void comparar(String texto){
        for(Palabra palabra:lista){
            if(palabra.getCastellano().equals(texto)){
                traduccion.setValue(palabra);
            }
        }
    }

    public LiveData<Palabra> getPalabraTraducida(){
        if(traduccion == null){
            traduccion= new MutableLiveData<Palabra>();
        }
        return traduccion;
    }
}
