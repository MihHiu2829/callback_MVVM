package com.example.mvvm_callback.View.ACT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvm_callback.R;
import com.example.mvvm_callback.ViewModel.m001VM;
import com.example.mvvm_callback.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
        private ActivityMainBinding binding ;
        private m001VM m001VM ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
               m001VM = new ViewModelProvider(this).get(com.example.mvvm_callback.ViewModel.m001VM.class) ;
        m001VM.setCallBack(i -> runOnUiThread(() -> {
                  binding.progressTime.setProgress(i);
                  binding.tvCountDown.setText(String.format("%s",i));
              }));
        binding.progressTime.setMax(10);
        binding.btStart.setOnClickListener(v -> startCounting());
    }

    private void startCounting() {
        m001VM.startCountDown();
    }
}