package com.example.usuario.davidprietorecio;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PantallaCarga extends AppCompatActivity {

    private int tiempo,progreso;
    private ProgressBar barraProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        tiempo=3000;
        progreso=0;

        barraProgreso=(ProgressBar)findViewById(R.id.progressBar);
        new Thread(carga).start();

    }

    private Runnable carga = new Runnable() {
        @Override
        public void run() {
            while (progreso < 100) {
                try {

                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }

            Intent mainIntent = new Intent().setClass(PantallaCarga.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

        Handler miHandle = new Handler() {

            public void handleMessage(Message msg) {
                progreso++;
                barraProgreso.setProgress(progreso);
                TextView tv = findViewById(R.id.textProgreso);
                String pro = Integer.toString(progreso);
                tv.setText(pro + "%");
            }
        };

    };

}
