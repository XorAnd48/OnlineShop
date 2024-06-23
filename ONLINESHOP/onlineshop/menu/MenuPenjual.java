package onlineshop.menu;

import java.util.ArrayList;

import onlineshop.controller.Penjual;
import onlineshop.controller.Menu;
import onlineshop.utility.ScreenHelper;

public class MenuPenjual extends Menu {
    private ArrayList<Penjual> data;

    public MenuPenjual(ArrayList<Penjual> data) {
        this.data = data;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+==============================================+");
            System.out.println("|                  MENU PENJUAL               |");
            System.out.println("+==============================================+");
            System.out.println("| 1 | Tampil Daftar Penjual                    |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 2 | Tambah Daftar Penjual                    |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 3 | Edit Daftar Penjual                      |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 4 | Hapus Daftar Penjual                     |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 0 | Kembali                                  |");
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
                    edit();
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

    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|               TAMPIL DATA PENJUAL           |");
            System.out.println("+=============================================+");
            for (Penjual tempPenjual : data) {
                System.out.println("Username      : " + tempPenjual.getUsername());
                System.out.println("Nama Penjual  : " + tempPenjual.getNama());
                System.out.println("Alamat Penjual: " + tempPenjual.getAlamat());
                System.out.println("Email Penjual : " + tempPenjual.getEmail());
                System.out.println("No. HP        : " + tempPenjual.getHp());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Penjual kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String username, nama, alamat, email, hp, password;
        System.out.println("+=============================================+");
        System.out.println("|              TAMBAH DATA PENJUAL            |");
        System.out.println("+=============================================+");

        System.out.print("Username      : ");
        username = input.nextLine();
        System.out.print("Nama Penjual  : ");
        nama = input.nextLine();
        System.out.print("Alamat Penjual: ");
        alamat = input.nextLine();
        System.out.print("Email Penjual : ");
        email = input.nextLine();
        System.out.print("No. HP        : ");
        hp = input.nextLine();
        System.out.print("Password      : ");
        password = input.nextLine();

        Penjual tempPenjual = new Penjual(
                nama, alamat, email, hp, username, password);
        data.add(tempPenjual);
        System.out.println("+=============================================+");
        System.out.println("|             DATA PENJUAL TERSIMPAN          |");
        System.out.println("+=============================================+");
        input.nextLine();
    }

    public void edit() {
        int indexPenjual = pilih();
        if (indexPenjual != -1) {
            Penjual editPenjual = data.get(indexPenjual);
            System.out.println("+=============================================+");
            System.out.println("|               EDIT DATA PENJUAL             |");
            System.out.println("+=============================================+");
            System.out.print("Username      : ");
            editPenjual.setUsername(input.nextLine());
            System.out.print("Nama Penjual  : ");
            editPenjual.setNama(input.nextLine());
            System.out.print("Alamat Penjual: ");
            editPenjual.setAlamat(input.nextLine());
            System.out.print("Email Penjual : ");
            editPenjual.setEmail(input.nextLine());
            System.out.print("No. HP        : ");
            editPenjual.setHp(input.nextLine());
            System.out.print("Password      : ");
            editPenjual.setPassword(input.nextLine());
            data.set(indexPenjual, editPenjual);
            System.out.println("+=============================================+");
            System.out.println("|             DATA PENJUAL TERSIMPAN          |");
            System.out.println("+=============================================+");
            input.nextLine();
            input.nextLine();
        }
    }

    public void hapus() {
        int indexPenjual = pilih();
        if (indexPenjual != -1) {
            data.remove(indexPenjual);
            System.out.println("+=============================================+");
            System.out.println("|              DATA PENJUAL DIHAPUS           |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public int pilih() {
        ScreenHelper.clearConsole();
        String username = "";
        int penjualDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                 PILIH PENJUAL               |");
                System.out.println("+=============================================+");
                for (Penjual tempPenjual : data) {
                    System.out.println("Username      : " + tempPenjual.getUsername());
                    System.out.println("Nama Penjual  : " + tempPenjual.getNama());
                    System.out.println("Alamat Penjual: " + tempPenjual.getAlamat());
                    System.out.println("Email Penjual : " + tempPenjual.getEmail());
                    System.out.println("No. HP        : " + tempPenjual.getHp());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih username Penjual : ");
                username = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getUsername().equals(username)) {
                        penjualDipilih = i;
                        break;
                    }
                }
            } while (penjualDipilih == -1);
        } else {
            System.out.println("Data Penjual kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return penjualDipilih;
    }
}
