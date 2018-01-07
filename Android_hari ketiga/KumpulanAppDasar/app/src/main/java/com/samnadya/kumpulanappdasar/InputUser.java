package com.samnadya.kumpulanappdasar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputUser extends AppCompatActivity {

    EditText nilaiAlas, nilaiTinggi;
    TextView hasilHit;
    Button btnHitung, btnHapus, btnPindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nilaiAlas = (EditText) findViewById(R.id.etAlas);
        nilaiTinggi = (EditText) findViewById(R.id.etTinggi);

        btnHapus = (Button) findViewById(R.id.btnHapus);
        btnPindah = (Button) findViewById(R.id.btnPindah);
        btnHitung = (Button) findViewById(R.id.btnHitung);

        hasilHit = (TextView) findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nilaiAlas.getText().toString())){
                    nilaiAlas.setError("Beuh.. eusian nilai alas..");
                    nilaiAlas.setFocusable(true);
                    nilaiAlas.requestFocus();

                } else if (TextUtils.isEmpty(nilaiTinggi.getText().toString())){
                    nilaiTinggi.setError("Beuh.. eusian nilai tinggi jurig..");
                    nilaiTinggi.setFocusable(true);
                    nilaiTinggi.requestFocus();
//                    nilaiTinggi.cur

                } else {
                    double a = Double.parseDouble(nilaiAlas.getText().toString());
                    double t = Double.parseDouble(nilaiTinggi.getText().toString());
                    double hsl = (a*t)/2;
                    hasilHit.setText("Luas Segitiga = " +hsl+ " satuan");
                }
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiTinggi.setText("");
                nilaiAlas.setText("");
                hasilHit.setText("Ayo Hitung Lagi");

            }
        });

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Bundle localBundle = new Bundle();
//                localBundle.putString("hs", hasilHit.getText().toString());
//                Intent pass = new Intent(InputUser.this, HasilHitung.class);
//                pass.putExtras(localBundle);
//                startActivity(pass);

                Intent i = new Intent(InputUser.this, HasilHitung.class);
                i.putExtra("nilaiAlas", nilaiAlas.getText().toString());
                i.putExtra("nilaiTinggi", nilaiTinggi.getText().toString());
                i.putExtra("hsl", hasilHit.getText().toString());
                startActivity(i);

            }
        });


    }

}
