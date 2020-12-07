package com.example.myapplication;

import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainUpdel extends AppCompatActivity {
        private MyDatabase db;
        private String Sid, Snama, Sharga , Sstok;
        private EditText Enama, Eharga , Estok;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_updel);
            db = new MyDatabase(this);
            Intent i = this.getIntent();
            Sid = i.getStringExtra("Iid");
            Snama = i.getStringExtra("Inama");
            Sharga = i.getStringExtra("Iharga");
            Sstok = i.getStringExtra("Istok");

            Enama = (EditText) findViewById(R.id.updel_nama);
            Eharga = (EditText) findViewById(R.id.updel_harga);
            Estok = (EditText) findViewById(R.id.updel_stok);

            Enama.setText(Snama);
            Eharga.setText(Sharga);
            Estok.setText(Sstok);

            Button btnUpdate = (Button) findViewById(R.id.btn_up);
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snama = String.valueOf(Enama.getText());
                    Sharga = String.valueOf(Eharga.getText());
                    Sstok = String.valueOf(Estok.getText());
                    if (Snama.equals("")){
                        Enama.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi nama produk",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sharga.equals("")){
                        Eharga.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi harga",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sstok.equals("")){
                        Estok.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi stok ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        db.UpdateTV(new TV(Sid, Snama, Sharga, Sstok));
                        Toast.makeText(MainUpdel.this, "Data telah diupdate",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
            Button btnDelete = (Button) findViewById(R.id.btn_del);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.DeleteTV(new TV(Sid, Snama, Sharga, Sstok));
                    Toast.makeText(MainUpdel.this, "Data telah dihapus",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
