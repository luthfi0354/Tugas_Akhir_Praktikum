package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainCreate extends AppCompatActivity {
        private MyDatabase db;
        private EditText Enama, Eharga, Estok;
        private String Snama, Sharga, Sstok;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_create);

            db = new MyDatabase(this);
            Enama = (EditText) findViewById(R.id.create_nama);
            Eharga = (EditText) findViewById(R.id.create_harga);
            Estok = (EditText) findViewById(R.id.create_stok);

            Button btnCreate = (Button) findViewById(R.id.create_btn);
            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Snama = String.valueOf(Enama.getText());
                    Sharga = String.valueOf(Eharga.getText());
                    Sstok = String.valueOf(Estok.getText());

                    if (Snama.equals("")){
                        Enama.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi nama produk",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sharga.equals("")){
                        Eharga.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi harga",
                                Toast.LENGTH_SHORT).show();
                    } else if (Sstok.equals("")){
                        Estok.requestFocus();
                        Toast.makeText(MainCreate.this, "Silahkan isi Stok barang", Toast.LENGTH_SHORT).show();
                    } else {
                        Enama.setText("");
                        Eharga.setText("");
                        Estok.setText("");
                        Toast.makeText(MainCreate.this, "Data telah ditambah",
                                Toast.LENGTH_SHORT).show();
                        db.CreateTV(new TV(null, Snama,Sharga, Sstok));
                        Intent a = new Intent(MainCreate.this, MainActivity.class);
                        startActivity(a);
                    }
                }
            });
        }
    }
