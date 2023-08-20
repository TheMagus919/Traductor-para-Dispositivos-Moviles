package com.agusoft.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.agusoft.tp1.databinding.ActivityTraducirBinding;
import com.agusoft.tp1.modelo.Palabra;

import java.util.Observer;

public class Traducir extends AppCompatActivity {
private TraduccirViewModel tvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTraducirBinding binding = ActivityTraducirBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tvm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccirViewModel.class);
        Intent intent=getIntent();
        String palabra = (String) intent.getStringExtra("texto");
        tvm.getPalabraTraducida().observe(this, new androidx.lifecycle.Observer<Palabra>() {
            @Override
            public void onChanged(Palabra pala) {
                binding.txTraduccion.setText(pala.getIngles());
                binding.img.setImageResource(pala.getFoto());
            }
        });
        tvm.comparar(palabra);
    }
}