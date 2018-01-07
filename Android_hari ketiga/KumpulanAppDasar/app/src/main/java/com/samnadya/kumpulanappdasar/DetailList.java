package com.samnadya.kumpulanappdasar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailList extends AppCompatActivity {

    TextView tvListDetailJudul;
    ImageView imListDetailJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
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

        tvListDetailJudul = (TextView) findViewById(R.id.tvJudulDetail);
        imListDetailJudul = (ImageView) findViewById(R.id.imDetailBuah);

        Bundle bundle = getIntent().getExtras();
        Integer ggbr = bundle.getInt("gambar",0);
        String jjdulu = bundle.getString("judul");

        tvListDetailJudul.setText(jjdulu);
        imListDetailJudul.setImageResource(ggbr);
    }

}
