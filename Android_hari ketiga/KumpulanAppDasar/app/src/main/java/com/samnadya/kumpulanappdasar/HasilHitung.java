package com.samnadya.kumpulanappdasar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilHitung extends AppCompatActivity {

    TextView tvTarimaHasil,tvA, tvT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_hitung);

        tvTarimaHasil = (TextView) findViewById(R.id.tvTerimaHasil);
        tvA = (TextView) findViewById(R.id.tvUAlas);
        tvT = (TextView) findViewById(R.id.tvUTinggi);



        String alas = getIntent().getStringExtra("nilaiAlas");
        String tinggi = getIntent().getStringExtra("nilaiTinggi");
        String hh = getIntent().getStringExtra("hsl");

        tvTarimaHasil.setText(hh);
        tvA.setText("Nilai Alas = " + alas);
        tvT.setText("Nilai Tinggi = " +tinggi);


    }
}
