package com.example.jivago.viagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private AutoCompleteTextView Destino;
    private Button button;
    private RadioButton Lazer;
    private RadioButton Negocios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Destino = (AutoCompleteTextView) findViewById(R.id.Destino);
        this.button = (Button) findViewById(R.id.button);
        this.Lazer = (RadioButton) findViewById(R.id.Lazer);
        this.Negocios = (RadioButton) findViewById(R.id.Negocios);

        button.setOnClickListener(this);

    }
    public void clickButton(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.Negocios:
                if (checked)

                    break;
            case R.id.Lazer:
                if (checked)

                    break;
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FotoActivity.class);

        startActivity(intent);
    }
}

