package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


    public class MyDatabase extends SQLiteOpenHelper {
        private static int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "db_productcosmetic";
        private static final String tb_TV = "tb_TV";
        private static final String tb_kos_id = "id";
        private static final String tb_kos_nama = "nama";
        private static final String tb_kos_harga = "akun";
        private static final String tb_barang_stok = "stok";

        private static final String CREATE_TABLE_TV = "CREATE TABLE " +
                tb_TV + "("
                + tb_kos_id + " INTEGER PRIMARY KEY ,"
                + tb_kos_nama + " TEXT,"
                + tb_kos_harga + " TEXT, "
                + tb_barang_stok + " TEXT" + ")";

        public MyDatabase (Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_TV);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
        public void CreateTV (TV mdNotif) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(tb_kos_id, mdNotif.get_id());
            values.put(tb_kos_nama, mdNotif.get_nama());
            values.put(tb_kos_harga, mdNotif.get_harga());
            values.put(tb_barang_stok, mdNotif.get_stok());
            db.insert(tb_TV, null, values);
            db.close();
        }
        public List<TV> ReadTV() {
            List<TV> judulModelList = new ArrayList<TV>();
            String selectQuery = "SELECT * FROM " + tb_TV;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    TV mdKontak = new TV();
                    mdKontak.set_id(cursor.getString(0));
                    mdKontak.set_nama(cursor.getString(1));
                    mdKontak.set_harga(cursor.getString(2));
                    mdKontak.set_stok(cursor.getString(3));
                    judulModelList.add(mdKontak);
                } while (cursor.moveToNext());
            }
            db.close();
            return judulModelList;
        }
        public int UpdateTV (TV mdNotif) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(tb_kos_nama, mdNotif.get_nama());
            values.put(tb_kos_harga, mdNotif.get_harga());
            values.put(tb_barang_stok, mdNotif.get_stok());
            return db.update(tb_TV, values, tb_kos_id + " = ?",
                    new String[] { String.valueOf(mdNotif.get_id())});
        }
        public void DeleteTV (TV mdNotif) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(tb_TV, tb_kos_id+ " = ?",
                    new String[]{String.valueOf(mdNotif.get_id())});
            db.close();
        }
    }
