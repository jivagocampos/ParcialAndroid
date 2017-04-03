package com.example.jivago.viagem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jivago.viagem.R;

public class LogiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logi);
    }

    public void Logar(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
