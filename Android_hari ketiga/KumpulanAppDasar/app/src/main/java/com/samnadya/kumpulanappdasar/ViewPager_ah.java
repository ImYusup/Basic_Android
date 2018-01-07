package com.samnadya.kumpulanappdasar;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewPager_ah extends AppCompatActivity {
    String[] nama_buah = {"Alpukat","Apel","Ceri","Durian","Jambu Air","Manggis","Stroberi"};

    int[] image_buah = {
            R.drawable.alpukat1,
            R.drawable.apel1,
            R.drawable.ceri1,
            R.drawable.duriani,
            R.drawable.jambuairi,
            R.drawable.manggisi,
            R.drawable.strawberrya
    };

//    TextView tvPager;
//    ImageView ivPager;

    PagerAdapter pagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        tvPager = (TextView) findViewById(R.id.tvPager);
//        ivPager = (ImageView) findViewById(R.id.ivPager);

        viewPager = (ViewPager) findViewById(R.id.viPage);
        pagerAdapter = new PgrData(this, image_buah, nama_buah);
        viewPager.setAdapter(pagerAdapter);


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

    private class PgrData extends PagerAdapter {
        Activity activity;
        String jdlPager[];
        int imgPager[];

        public PgrData(ViewPager_ah viewPager_ah, int[] image_buah, String[] nama_buah) {
            this.activity = viewPager_ah;
            this.imgPager = image_buah;
            this.jdlPager = nama_buah;
        }

        //mengembalikan jumlah list dalam array
        @Override
        public int getCount() {

            return imgPager.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);

            View vv = inflater.inflate(R.layout.custom_viewpager,null);

            TextView textView = (TextView) vv.findViewById(R.id.tvPager);
            ImageView imageView = (ImageView) vv.findViewById(R.id.ivPager);

            textView.setText(jdlPager[position]);
            imageView.setImageResource(imgPager[position]);

            container.addView(vv);
            return vv;
        }

//                @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
//
//            View view1 = inflater.inflate(R.layout.custom_viewpager,container, false);
//
//            TextView textView = (TextView) view1.findViewById(R.id.tvPager);
//            ImageView img = (ImageView) view1.findViewById(R.id.ivPager);
//
//            textView.setText(jdlPager[position]);
//            img.setImageResource(imgPager[position]);
//            //menampilkan data array
//            ((ViewPager)container).addView(view1);
//            container.addView(view1);
//            return view1;
//        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
//            return true;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            ((ViewPager)container).removeView((ScrollView)object);
            container.removeView((View)object);
        }
    }
}
