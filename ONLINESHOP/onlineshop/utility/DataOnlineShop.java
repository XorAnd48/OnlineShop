package onlineshop.utility;

import java.util.ArrayList;

import onlineshop.controller.*;

public class DataOnlineShop {
    private ArrayList<Kategori> dataKategori = new ArrayList<>();
    private ArrayList<Penjual> dataPenjual = new ArrayList<>();
    private ArrayList<Produk> dataProduk = new ArrayList<>();
    private ArrayList<Pelanggan> dataPelanggan = new ArrayList<>();
    
    public ArrayList<Kategori> initKategori(){
        Kategori tempKategori = new Kategori();
        tempKategori.setKode("KAT01");
        tempKategori.setKategori("PAKAIAN");
        dataKategori.add(tempKategori);

        tempKategori = new Kategori();
        tempKategori.setKode("KAT02");
        tempKategori.setKategori("ELEKTRONIK");
        dataKategori.add(tempKategori);

        return dataKategori;
    }

    public String getNamaKategori(String kodeKategori) {
        for (Kategori kategori : dataKategori) {
            if (kategori.getKode().equals(kodeKategori)) {
                return kategori.getKategori();
            }
        }
        return "Kategori tidak ditemukan";
    }

    public ArrayList<Produk> initProduk(){
        Produk tempProduk = new Produk();
        tempProduk.setKode("PO01");
        tempProduk.setNama("T-Shirt shimmer shimmer");
        tempProduk.setKategori("KAT01");
        tempProduk.setHarga(100000);
        tempProduk.setStok(100);
        dataProduk.add(tempProduk);

        tempProduk = new Produk();
        tempProduk.setKode("PO02");
        tempProduk.setNama("Long Pants");
        tempProduk.setKategori("KAT01");
        tempProduk.setHarga(185000);
        tempProduk.setStok(100);
        dataProduk.add(tempProduk);

        return dataProduk;
    }

    public ArrayList<Penjual> initPenjual(){
        Penjual tempPenjual = new Penjual(
            "Admin",
            "Denpasar",
            "admin@admin.com",
            "0822764149979",
            "admin",
            "admin"
        );
        dataPenjual.add(tempPenjual);

        return dataPenjual;
    }    

    public ArrayList<Pelanggan> initPelanggan(){
        Pelanggan tempPelanggan = new Pelanggan(
            "Wira",
            "Denpasar",
            "wira@gmail.com",
            "0822764149979",
            "wira",
            "1234"
        );
        dataPelanggan.add(tempPelanggan);

        tempPelanggan = new Pelanggan(
            "Yana", 
            "Gianyar",
            "yana@gmail.com", 
            "08112999321",
            "yana", 
            "0000"
            );
        dataPelanggan.add(tempPelanggan);
        return dataPelanggan;
    }
}
