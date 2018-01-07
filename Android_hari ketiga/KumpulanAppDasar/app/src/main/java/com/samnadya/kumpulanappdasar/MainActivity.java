package com.samnadya.kumpulanappdasar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSpinner, btnSpinnerMusic, btnPopMenu, btnWebView, btnListView, btnInputUser, btnViewPager, btnCustomList, btnSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpinnerMusic = (Button) findViewById(R.id.btnSpinnerMusic);
        btnPopMenu = (Button) findViewById(R.id.btnPopMenu);
        btnWebView = (Button) findViewById(R.id.btnWebView);
        btnListView = (Button) findViewById(R.id.btnListView);
        btnInputUser = (Button) findViewById(R.id.btnInputUser);
        btnViewPager = (Button) findViewById(R.id.btnViewPager);
        btnCustomList = (Button) findViewById(R.id.btnCustomList);
        btnSpinner= (Button) findViewById(R.id.btnSpinner);
        btnSpinnerAdapter = (Button) findViewById(R.id.btnSpinnerAdapter);

        btnSpinnerMusic.setOnClickListener(this);
        btnSpinnerAdapter.setOnClickListener(this);
        btnSpinner.setOnClickListener(this);
        btnWebView.setOnClickListener(this);
        btnListView.setOnClickListener(this);
        btnCustomList.setOnClickListener(this);
        btnViewPager.setOnClickListener(this);
        btnInputUser.setOnClickListener(this);
        btnPopMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSpinner) {

            Intent intent = new Intent(MainActivity.this, SimpleSpinner.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Masuk Ke SimpleSpinner dah", Toast.LENGTH_SHORT).show();

        }else if(view == btnSpinnerMusic){
            startActivity(new Intent(getApplicationContext(), SpinnerMusic.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke SimpleSpinner Musik", Toast.LENGTH_SHORT).show();



        }else if(view == btnPopMenu){
            startActivity(new Intent(getApplicationContext(), PopMenu.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke PopMenu", Toast.LENGTH_SHORT).show();

        }else if(view == btnWebView){
            startActivity(new Intent(getApplicationContext(), WebView_atuh.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke Webview", Toast.LENGTH_SHORT).show();

        }else if(view == btnListView){
            startActivity(new Intent(getApplicationContext(), ListView_dah.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke List view", Toast.LENGTH_SHORT).show();

        }else if(view == btnCustomList){
            startActivity(new Intent(getApplicationContext(), CustomList.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke Custom List", Toast.LENGTH_SHORT).show();

        }else if(view == btnInputUser){
            startActivity(new Intent(getApplicationContext(), InputUser.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke Iput user", Toast.LENGTH_SHORT).show();

        }else if(view == btnViewPager){
            startActivity(new Intent(getApplicationContext(), ViewPager_ah.class));
//            Toast.makeText(getApplicationContext(), "Masuk Ke View Pager", Toast.LENGTH_SHORT).show();

        }else if(view == btnSpinnerAdapter){
            startActivity(new Intent(getApplicationContext(), SpinnerBaseAdapter.class));
            Toast.makeText(getApplicationContext(), "Masuk Ke View Pager", Toast.LENGTH_SHORT).show();

        }

    }
}
