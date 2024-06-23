package onlineshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import onlineshop.controller.Pelanggan;
import onlineshop.controller.Produk;
import onlineshop.utility.DataOnlineShop;
import onlineshop.utility.ScreenHelper;

public class MainMenuPelanggan {
    private ArrayList<Produk> dataProduk;
    private Pelanggan pelangganAktif;
    private Scanner input;

    public MainMenuPelanggan(ArrayList<Pelanggan> dataPelanggan, Pelanggan pelangganAktif, DataOnlineShop dataShop) {
        this.dataProduk = dataShop.initProduk();
        this.pelangganAktif = pelangganAktif;
        this.input = new Scanner(System.in);
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|              MAIN MENU PELANGGAN            |");
            System.out.println("+=============================================+");
            System.out.println("| Selamat datang, " + pelangganAktif.getNama() + "!");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Lihat Daftar Produk                     |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Beli Produk                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Lihat Daftar Pembelian                  |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Batalkan Pembelian                      |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Keluar                                  |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukkan pilihan Anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilData();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    ScreenHelper.clearConsole();
                    System.out.println("+=============================================+");
                    System.out.println("|             KELUAR DARI PROGRAM             |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang Anda masukkan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }


    public void tampilData() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|          DAFTAR PRODUK YANG TERSEDIA         |");
        System.out.println("+=============================================+");
        for (int i = 0; i < dataProduk.size(); i++) {
            Produk produk = dataProduk.get(i);
            System.out.println("ID: " + i);
            System.out.println("Nama: " + produk.getNama());
            System.out.println("Harga: Rp " + produk.getHarga());
            System.out.println("Stok: " + produk.getStok());
            System.out.println("+---------------------------------------------+");
        }
        System.out.println("Tekan Enter untuk kembali ke menu.");
        input.nextLine();
    }
}
