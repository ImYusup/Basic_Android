package com.samnadya.kumpulanappdasar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerBaseAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_base_adapter);
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

        String[] strings = { "CoderzHeaven", "Google", "Microsoft", "Apple",
                "Yahoo", "Samsung" };
        ArrayList<ListObject> objects = new ArrayList<ListObject>();
        for (int k = 0; k < strings.length; k++) {
            ListObject obj = new ListObject();
            obj.setAll(R.drawable.strawberrya, strings[k], "Sub title");
            objects.add(obj);
        }

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(new MyAdapter(this, objects));
    }

}
