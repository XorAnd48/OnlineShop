package onlineshop.menu;

import java.util.ArrayList;
import java.util.Map;

import onlineshop.controller.Penjual;
import onlineshop.controller.Menu;
import onlineshop.controller.Pelanggan;
import onlineshop.controller.Pembelian;
import onlineshop.controller.Produk;
import onlineshop.utility.ScreenHelper;

public class MenuPembelian extends Menu {
    private ArrayList<Pembelian> data;
    private ArrayList<Pelanggan> dataPelanggan;
    private ArrayList<Produk> dataProduk;
    private MenuPelanggan menuPelanggan;
    private Penjual penjualAktif;

    public MenuPembelian(
            ArrayList<Pembelian> data,
            ArrayList<Produk> dataProduk,
            ArrayList<Pelanggan> dataPelanggan,
            MenuPelanggan mPelanggan,
            MenuProduk mProduk,
            Penjual penjual) {
        this.data = data;
        this.dataProduk = dataProduk;
        this.dataPelanggan = dataPelanggan;
        this.menuPelanggan = mPelanggan;
        this.penjualAktif = penjual;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                DATA PEMBELIAN PRODUK        |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Daftar Pembelian                 |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Daftar Pembelian                 |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Detail Daftar Pembelian                 |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Daftar Pembelian                  |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Kembali                                 |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tampilData();
                    break;
                case 2:
                    tambah();
                    break;
                case 3:
                    detail();
                    break;
                case 4:
                    hapus();
                    break;
                case 0:
                    System.out.println("+=============================================+");
                    System.out.println("|            KEMBALI KE MENU UTAMA            |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }

    @Override
    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|              TAMPIL DATA PEMBELIAN          |");
            System.out.println("+=============================================+");
            for (Pembelian tempPembelian : data) {
                System.out.println("ID Pembelian       : " + tempPembelian.getIdPembelian());
                System.out.println("Nama Pembeli       : " + tempPembelian.getPembeli().getNama());
                System.out.println("Penjual            : " + tempPembelian.getPenjualPembelian().getNama());
                System.out.println("Tanggal Pembelian  : " + tempPembelian.getTanggalPembelian());
                System.out.println("Total Harga        : Rp " + tempPembelian.getTotalHarga());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Pembelian kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA PEMBELIAN           |");
        System.out.println("+=============================================+");
        
        System.out.println("Silahkan pilih customer yang akan membeli!");
        int indexPelanggan = menuPelanggan.pilih();
        Pelanggan pembeli = dataPelanggan.get(indexPelanggan);
        
        Pembelian tempPembelian = new Pembelian(pembeli, penjualAktif);
        
        boolean tambahProdukLagi = true;
        boolean pembelianBerhasil = true;
        while (tambahProdukLagi && pembelianBerhasil) {
            System.out.println("Daftar Produk yang Tersedia:");
            for (int i = 0; i < dataProduk.size(); i++) {
                Produk produk = dataProduk.get(i);
                System.out.println(i + ". " + produk.getNama() + " - Rp " + produk.getHarga() + " - Stok: " + produk.getStok());
            }
        
            System.out.print("Masukkan indeks Produk yang ingin dibeli: ");
            int indexProduk = input.nextInt();
            input.nextLine();
            if (indexProduk >= 0 && indexProduk < dataProduk.size()) {
                Produk produkDipilih = dataProduk.get(indexProduk);
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = input.nextInt();
                input.nextLine();
                if (jumlah <= produkDipilih.getStok()) {
                    tempPembelian.tambahProduk(produkDipilih, jumlah);
                    produkDipilih.beli(jumlah);
                    System.out.print("Apa ingin menambahkan produk yang lain (y/t)? ");
                    String pilihan = input.nextLine();
                    if (!pilihan.equalsIgnoreCase("y")) {
                        tambahProdukLagi = false;
                    }
                } else {
                    System.out.println("Stok Produk tidak mencukupi.");
                    System.out.print("Apakah Anda ingin mengulangi proses pembelian (y/t)? ");
                    String pilihan = input.nextLine();
                    if (!pilihan.equalsIgnoreCase("y")) {
                        pembelianBerhasil = false;
                    }
                }
            } else {
                System.out.println("Indeks Produk tidak valid.");
                System.out.print("Apakah Anda ingin mengulangi proses pembelian (y/t)? ");
                String pilihan = input.nextLine();
                if (!pilihan.equalsIgnoreCase("y")) {
                    pembelianBerhasil = false;
                }
            }
        }
        
        if (pembelianBerhasil) {
            double totalHarga = tempPembelian.getTotalHarga();
            System.out.println("+=============================================+");
            System.out.println("|        TOTAL HARGA PEMBELIAN: Rp " + totalHarga + "       |");
            System.out.println("+=============================================+");
            System.out.print("Tekan Enter untuk menyelesaikan pembelian atau ketik 'batalkan' untuk membatalkan...");
            String konfirmasi = input.nextLine();
            if (konfirmasi.equalsIgnoreCase("batalkan")) {
                System.out.println("Pembelian dibatalkan.");
            } else {
                data.add(tempPembelian);
                System.out.println("+=============================================+");
                System.out.println("|            DATA PEMBELIAN TERSIMPAN         |");
                System.out.println("+=============================================+");
            }
        } else {
                System.out.println("+=============================================+");
                System.out.println("|             PEMBELIAN DIBATALKAN            |");
                System.out.println("+=============================================+");
                }
        input.nextLine();
    }
    
    

    @Override
    public void hapus() {
        int indexPembelian = pilih();
        if (indexPembelian != -1) {
            Pembelian pembelian = data.get(indexPembelian);
            kembalikanStokProduk(pembelian); 
            data.remove(indexPembelian);
            System.out.println("+=============================================+");
            System.out.println("|             DATA PEMBELIAN DIHAPUS          |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    private void kembalikanStokProduk(Pembelian pembelian) {
        Map<Produk, Integer> daftarProduk = pembelian.getDaftarProduk();
        for (Produk produk : daftarProduk.keySet()) {
            int jumlahDibeli = daftarProduk.get(produk);
            produk.tambahStok(jumlahDibeli);
        }
    }

    @Override
    public int pilih() {
        ScreenHelper.clearConsole();
        int pembelianDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                PILIH PEMBELIAN              |");
                System.out.println("+=============================================+");
                for (int index = 0; index < data.size(); index++) {
                    Pembelian tempPembelian = data.get(index);
                    System.out.println("INDEX               : " + index);
                    System.out.println("ID Pembelian        : " + tempPembelian.getIdPembelian());
                    System.out.println("Nama Pembeli        : " + tempPembelian.getPembeli().getNama());
                    System.out.println("Penjual             : " + tempPembelian.getPenjualPembelian().getNama());
                    System.out.println("Tanggal Pembelian   : " + tempPembelian.getTanggalPembelian());
                    System.out.println("Total Harga         : Rp " + tempPembelian.getTotalHarga());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih INDEX Pembelian : ");
                pembelianDipilih = input.nextInt();
                input.nextLine();
            } while (pembelianDipilih == -1);
        } else {
            System.out.println("Data Pembelian kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return pembelianDipilih;
    }

    public void detail() {
        int indexPembelian = pilih();
        if (indexPembelian != -1) {
            Pembelian pembelian = data.get(indexPembelian);
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|              DETAIL PEMBELIAN               |");
            System.out.println("+=============================================+");
            System.out.println("ID Pembelian       : " + pembelian.getIdPembelian());
            System.out.println("Nama Pembeli       : " + pembelian.getPembeli().getNama());
            System.out.println("Penjual            : " + pembelian.getPenjualPembelian().getNama());
            System.out.println("Tanggal Pembelian  : " + pembelian.getTanggalPembelian());
            System.out.println("Total Harga        : Rp " + pembelian.getTotalHarga());
            System.out.println("+=============================================+");
            System.out.println("Detail Produk yang Dibeli:");
            for (Produk produk : pembelian.getDaftarProduk().keySet()) {
                int jumlah = pembelian.getDaftarProduk().get(produk);
                System.out.println("- " + produk.getNama() + " x " + jumlah + " = Rp " + (produk.getHarga() * jumlah));
            }
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }
}