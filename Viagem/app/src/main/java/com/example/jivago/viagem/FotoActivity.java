package com.example.jivago.viagem;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;

public class FotoActivity extends AppCompatActivity  implements View.OnClickListener{

        private Spinner spinner;
        private Button button2;

        private static final int CAPTURAR_IMAGEM = 1;
        private Uri uri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_foto);
            this.spinner = (Spinner) findViewById(R.id.spinner);
            this.button2 = (Button) findViewById(R.id.button2);

            button2.setOnClickListener(this);

            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

        }

        public void clickButton(View view) {

               if (view.getId() == R.id.spinner) {

                int position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {

                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Hospedagem"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Comida"));
                        break;
                }
                if(intent != null) {
                    startActivity(intent);

                }
            }
            if (view.getId() == R.id.button2) {
                finish();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.camera:
                    camera();
                    break;

                default:
                    break;
            }
            return true;
        }

        public void camera() {
            boolean temCamera = getPackageManager()
                    .hasSystemFeature(PackageManager.FEATURE_CAMERA);
            if(temCamera){

                File diretorio = Environment
                        .getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES);

                String nomeImagem = diretorio.getPath() + "/" +
                        System.currentTimeMillis() +
                        ".jpg";

                uri = Uri.fromFile(new File(nomeImagem));
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                startActivityForResult(intent, CAPTURAR_IMAGEM);

                Intent in2 = new Intent(
                        Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                in2.setData(uri);
                this.sendBroadcast(in2);
            }
        }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}