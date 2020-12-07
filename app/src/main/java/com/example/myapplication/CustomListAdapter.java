package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

    public class CustomListAdapter extends BaseAdapter {
        private Activity activity;
        private LayoutInflater inflater;
        private List<TV> movieItems;
        public CustomListAdapter(Activity activity, List<TV> movieItems) {
            this.activity = activity;
            this.movieItems = movieItems;
        }
        @Override
        public int getCount() {
            return movieItems.size();
        }
        @Override
        public Object getItem(int location) {
            return movieItems.get(location);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (inflater == null)
                inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null)
                convertView = inflater.inflate(R.layout.custom_list, null);
            TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
            TextView namaakun = (TextView) convertView.findViewById(R.id.text_akun);
            TextView stok = (TextView) convertView.findViewById(R.id.text_stok);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
            TV m = movieItems.get(position);
            nama.setText("Nama Kost : "+ m.get_nama());
            namaakun.setText("Harga Per Kamar : "+ m.get_harga());
            stok.setText("Alamat : "+ m.get_stok());
            return convertView;
        }
    }
