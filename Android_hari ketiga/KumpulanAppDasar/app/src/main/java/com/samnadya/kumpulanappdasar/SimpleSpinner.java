package com.samnadya.kumpulanappdasar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SimpleSpinner extends AppCompatActivity {
    Spinner spPilih;
    TextView tvPilihan;
    String data[] = {"Sumedang", "Jakarta", "Bandung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
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

        spPilih = (Spinner) findViewById(R.id.spPilih);
        tvPilihan = (TextView) findViewById(R.id.tvPilihan);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPilih.setAdapter(adapter);

        spPilih.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvPilihan.setText(data[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvPilihan.setText("");

            }
        });

//        spPilih.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                tvPilihan.setText(data[i]);
//            }
//        });

    }

}
