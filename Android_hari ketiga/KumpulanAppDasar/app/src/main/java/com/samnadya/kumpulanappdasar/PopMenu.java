package com.samnadya.kumpulanappdasar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PopMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    TextView tvMenu;
    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu);
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

        tvMenu = (TextView) findViewById(R.id.tvMenu);
        btnPopUp = (Button) findViewById(R.id.btnPopUp);

        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(PopMenu.this,view);
                menu.setOnMenuItemClickListener(PopMenu.this);
                //inflate menjadikan satu design ke dalam activity
                menu.inflate(R.menu.main_menu);
                menu.show();

            }

        });

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSatu :
                tvMenu.setText("Anda Pilih Menu Satu");
                return true;
            case R.id.menuDua :
                tvMenu.setText("Anda Pilih Menu Dua");
                return true;
            case R.id.menuTiga :
                tvMenu.setText("Anda Pilih Menu Tiga");
                return true;
            case R.id.shareItem :
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Ieu tek anu di bagikeun");
                startActivity(Intent.createChooser(intent, "Bagikeun Ah.."));
        }
        return true;
    }
}
