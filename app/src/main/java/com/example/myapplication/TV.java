package com.example.myapplication;

public class TV
{
    private String _id, _nama, _harga, _stok;
    public TV (String id, String nama, String harga, String stok) {
        this._id = id;
        this._nama = nama;
        this._harga = harga;
        this._stok = stok;
    }
    public TV() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
    public String get_stok() {
        return _stok;
    }
    public void set_stok(String _stok) {
        this._stok = _stok;
    }


}
