package com.samnadya.kumpulanappdasar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamNadya on 15/11/2016.
 */

public class MyAdapter extends BaseAdapter {
    Context c;
    ArrayList<ListObject> objects;

    public MyAdapter(Context context, ArrayList<ListObject> objects){
        super();
        this.c = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ListObject cur_obj = objects.get(i);
        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
//        View
//        ListObject cur_obj = objects.get(position);
//        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
//        View row = inflater.inflate(R.layout.row, parent, false);
        View row = inflater.inflate(R.layout.row, viewGroup, false);
        TextView label = (TextView) row.findViewById(R.id.company);
        label.setText(cur_obj.getCompany());
        TextView sub = (TextView) row.findViewById(R.id.sub);
        sub.setText(cur_obj.getSub());
        ImageView icon = (ImageView) row.findViewById(R.id.image);
        icon.setImageResource(cur_obj.getImage_id());

        return row;
    }


}
