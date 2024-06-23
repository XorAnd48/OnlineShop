package onlineshop.menu;

import java.util.ArrayList;
import java.util.Scanner;

import onlineshop.controller.*;
import onlineshop.utility.DataOnlineShop;
import onlineshop.utility.ScreenHelper;

public class MainMenuAdmin {
    private DataOnlineShop masterData = new DataOnlineShop();
    private ArrayList<Produk> dataProduk = masterData.initProduk();
    private ArrayList<Kategori> dataKategori = masterData.initKategori();
    private ArrayList<Pelanggan> dataPelanggan = masterData.initPelanggan();
    private ArrayList<Pembelian> dataPembelian = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Penjual activePenjual;
    private MenuProduk menuProduk;
    private MenuKategori menuKategori;
    private MenuPenjual menuPenjual;
    private MenuPelanggan menuPelanggan;
    private MenuPembelian menuPembelian;

    public MainMenuAdmin(ArrayList<Penjual> dataPetugas, Penjual petugas) {
        this.activePenjual = petugas;
        this.menuProduk = new MenuProduk(dataProduk, masterData);
        this.menuKategori = new MenuKategori(dataKategori);
        this.menuPenjual = new MenuPenjual(dataPetugas);
        this.menuPelanggan = new MenuPelanggan(dataPelanggan);
        this.menuPembelian = new MenuPembelian(dataPembelian, dataProduk, dataPelanggan,
                menuPelanggan, menuProduk, activePenjual);
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                  MAIN MENU                  |");
            System.out.println("+=============================================+");
            System.out.println("|  ONLINE SHOP PEMROGRAMAN BERORIENTASI OBJEK |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Menu Daftar Produk                      |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Menu Kategori Produk                    |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Menu Daftar Pelanggan                   |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Menu Dadtar Penjual                     |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 5 | Menu Pembelian Produk                   |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Logout                                  |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...5) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    menuProduk.tampilMenu();
                    break;
                case 2:
                    menuKategori.tampilMenu();
                    break;
                case 3:
                    menuPelanggan.tampilMenu();
                    break;
                case 4:
                    menuPenjual.tampilMenu();
                    break;
                case 5:
                    menuPembelian.tampilMenu();
                    break;
                case 0:
                    ScreenHelper.clearConsole();
                    System.out.println("+=============================================+");
                    System.out.println("|             KELUAR DARI PROGRAM             |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }
}
