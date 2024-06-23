package onlineshop.controller;

import java.util.Date;
import java.util.HashMap;


public class Pembelian {
    private int idPembelian;
    private Pelanggan pembeli;
    private Penjual penjualPembelian;
    private Date tanggalPembelian;
    private double totalHarga;
    private HashMap<Produk, Integer> daftarProduk; 
    private static int idCounter = 1;

    public Pembelian(Pelanggan pembeli, Penjual penjualPembelian) {
        this.idPembelian = idCounter++;
        this.pembeli = pembeli;
        this.penjualPembelian = penjualPembelian;
        this.tanggalPembelian = new Date();
        this.totalHarga = 0.0;
        this.daftarProduk = new HashMap<>();
    }

    public int getIdPembelian() {
        return idPembelian;
    }

    public Pelanggan getPembeli() {
        return pembeli;
    }

    public Penjual getPenjualPembelian() {
        return penjualPembelian;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        if (daftarProduk.containsKey(produk)) {
            daftarProduk.put(produk, daftarProduk.get(produk) + jumlah);
        } else {
            daftarProduk.put(produk, jumlah);
        }
        totalHarga += produk.getHarga() * jumlah;
    }

    public HashMap<Produk, Integer> getDaftarProduk() {
        return daftarProduk;
    }
    
}
