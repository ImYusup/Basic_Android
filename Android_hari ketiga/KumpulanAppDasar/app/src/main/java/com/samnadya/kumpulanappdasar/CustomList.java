package com.samnadya.kumpulanappdasar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustomList extends AppCompatActivity {

    ListView lvCustom;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvCustom = (ListView) findViewById(R.id.lvCustomOuy);
        CustomListAdapter adapter = new CustomListAdapter(this, nama_buah, image_buah);
        lvCustom.setAdapter(adapter);

        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ih = new Intent(getApplicationContext(), DetailList.class);
                ih.putExtra("gambar", image_buah[i]);
                ih.putExtra("judul", nama_buah[i]);
                startActivity(ih);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
