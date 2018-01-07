package com.samnadya.kumpulanappdasar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerMusic extends AppCompatActivity {

    Spinner spBuah;
    ImageView ivBuah;
    TextView tvBuah;

    MediaPlayer mp;

    String[] nama_buah = {"Alpukat","Apel","Ceri","Durian","Jambu Air","Manggis","Stroberi"};

    Integer[] image_buah = {
            R.drawable.alpukat1,
            R.drawable.apel1,
            R.drawable.ceri1,
            R.drawable.duriani,
            R.drawable.jambuairi,
            R.drawable.manggisi,
            R.drawable.strawberrya
    };

    Integer[] suara_buah = {
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambuair,
            R.raw.manggis,
            R.raw.strawberry,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_music);
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

        ivBuah = (ImageView) findViewById(R.id.imageView);
        tvBuah = (TextView) findViewById(R.id.tvBuah);
        spBuah = (Spinner) findViewById(R.id.spBuah);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nama_buah);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBuah.setAdapter(adapter);

        spBuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                tvBuah.setText(nama_buah[i]);
                ivBuah.setImageResource(image_buah[i]);

                mp = MediaPlayer.create(getApplicationContext(), suara_buah[i]);
                mp.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvBuah.setText("");
//                ivBuah.setImageResource();


            }
        });


    }

}
