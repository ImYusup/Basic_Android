package com.example.yusup.yusupberita;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Sinkroniasi widget to variable
    AQuery aq;
    ListView lv;
    ArrayList<model_berita> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sinkroniasi ID & others aktivitas
        aq = new AQuery(MainActivity.this);
        lv = (ListView) findViewById(R.id.list_view1);

        data = new ArrayList<>();

        //deklarasi method baru untuk get data
        getDataBerita();
    }

    private void getDataBerita() {
        String url = "http://192.168.95.240/AndroidBerita/get_berita.php";


        //set progress dialog nunggu respon server & membuat variable terlebih dahulu
        ProgressDialog proges = new ProgressDialog(MainActivity.this);
        //set message progress dialog
        proges.setMessage("Woi Ambil data ya???");
        //set tidak bisa cancel
        proges.setCancelable(false);


        //include url to server use quesry

        aq.progress(proges).
                ajax(url, String.class, new AjaxCallback<String>() {

                    //get method respond server

                    @Override
                    public void callback(String url, String object, AjaxStatus status) {
                        //super.callback(url, object, status);

                        if (object != null) {
                            //get jsson object
                            try {
                                JSONObject var_json = new JSONObject(object);
                                ///get jsson object di dalam jsonobject
                                String pesan = var_json.getString("pesan");
                                String sukses = var_json.getString("sukses");
                                //convert dari string ke integer
                                if (Integer.parseInt(sukses) == 1) {
                                    //get jsonarray from jsonobobject
                                    JSONArray var_jray = var_json.getJSONArray("berita");
                                    for (int a = 0; a < var_jray.length(); a++) {

                                        //get json object from json array
                                        JSONObject var_c = var_jray.getJSONObject(a);
                                        {

                                            //set array to model
                                            model_berita b = new model_berita();
                                            b.setId_berita(var_c.getString("id"));
                                            b.setJudul_berita(var_c.getString("judul"));
                                            b.setGambar_berita(var_c.getString("gambar"));

                                            //include data array
                                            data.add(b);

                                            setKeListview(data);

                                        }
                                    }
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Data Tidak Ada!!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }


//                    private void setKeListview(ArrayList<model_berita> data) {
//                        //untuk buat class baru arrayadapter
//                        CustomAdapter adapter = new CustomAdapter(this,data);
//                        lv.setAdapter(adapter);
//                    }
                });
    }

    private void setKeListview(ArrayList<model_berita> data) {
        CustomAdapter adapter = new CustomAdapter(this, data);
        lv.setAdapter(adapter);
    }

    private class CustomAdapter extends BaseAdapter {
        ArrayList<model_berita> data;
        Activity c;

        public CustomAdapter(MainActivity mainActivity, ArrayList<model_berita> data) {
            this.data = data;
            c = mainActivity;

        }

        //jumlah row listview
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater var_inflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            View v = var_inflater.inflate(R.layout.list_item, null);
            final ImageView img = (ImageView) v.findViewById(R.id.image_view);
            TextView txt = (TextView) v.findViewById(R.id.list_view);
            model_berita c = data.get(i);
            txt.setText(c.getJudul_berita());

            //menambhkan gridle
            //menambahkan glide berbentuk kotak
//            Glide.with(MainActivity.this).load("http://192.168.95.240/AndroidBerita/foto_berita/"
//            +c.getGambar_berita()).into(img);

            //menambahkan glide sesudah cycyle
            Glide.with(MainActivity.this).load("http://192.168.95.240/AndroidBerita/foto_berita/"
                    + c.getGambar_berita()).asBitmap().centerCrop().into(new BitmapImageViewTarget(img)

            {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable rounded =
                            RoundedBitmapDrawableFactory.create(MainActivity.this.getResources(), resource);

                    rounded.setCircular(true);
                    img.setImageDrawable(rounded);

                    //super.setResource(resource);
                }
            });
            return v;
        }
    }
}