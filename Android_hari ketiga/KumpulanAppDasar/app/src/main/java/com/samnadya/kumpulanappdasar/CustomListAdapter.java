package com.samnadya.kumpulanappdasar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SamNadya on 16/11/2016.
 */


//adapter ini digunakan untk menentukan tampilan isi listview dengan mendapatkan isi dan jumlah dari array
public class CustomListAdapter extends BaseAdapter {

    Activity activity;
    String judula[];
    Integer gambara[];

    //fungsi ketika dijalankan maka akan mendapatkan data, dengan memanggil fungsi CustomListAdapter
    //adapter ini hanya milik customlist
    public CustomListAdapter(CustomList activity, String[] judula, Integer[] gambara) {
        this.activity = activity;
        this.judula = judula;
        this.gambara = gambara;
    }

    //fungsinya untuk mengembalikan jumlah data
    @Override
    public int getCount() {
        return judula.length;
    }

    //
    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsinya untuk menampilkan data per posisi array
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //untuk meng-custom isi listview dan gambar yabg di buat di listitem.xml
        //dan menghubungkan layout inflater ke dalam adapter
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.listitem, null);
        TextView textView = (TextView) view1.findViewById(R.id.tvJudul);
        ImageView img = (ImageView) view1.findViewById(R.id.ivGambar);
        textView.setText(judula[i]);
        img.setImageResource(gambara[i]);
        return view1;


    }
}
