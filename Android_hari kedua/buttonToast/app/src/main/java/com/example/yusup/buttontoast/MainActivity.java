package com.example.yusup.buttontoast;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button button_toast;
    Button button_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get id
        button_toast = (Button) findViewById(R.id.btn_toast);
        button_alert = (Button) findViewById(R.id.btn_alert);
        //action klik
        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "belajar andoroid", Toast.LENGTH_LONG).show();
            }
        });
        button_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //deklarasi variable alert
                AlertDialog.Builder var_alert = new AlertDialog.Builder(MainActivity.this);
                var_alert.setMessage("Anda Yakin Ingin Keluar");
                //set message alert
                var_alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });
                var_alert.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }
                }).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_BACK :
                AlertDialog.Builder var_alert = new AlertDialog.Builder(MainActivity.this);
                var_alert.setMessage("Anda Yaking Ingin Keluar");
                //set message alert
                var_alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });
                var_alert.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }
                }).show();

        }

        return super.onKeyDown(keyCode, event) ;
    }
}


