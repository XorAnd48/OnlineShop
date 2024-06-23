package onlineshop.menu;

import java.util.ArrayList;

import onlineshop.controller.Menu;
import onlineshop.controller.Pelanggan;
import onlineshop.utility.ScreenHelper;

public class MenuPelanggan extends Menu {
    private ArrayList<Pelanggan> data;

    public MenuPelanggan(ArrayList<Pelanggan> data) {
        this.data = data;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                 DATA PELANGGAN              |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Daftar Pelanggan                 |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Daftar Pelanggan                 |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit Daftar Pelanggan                   |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Daftar Pelanggan                  |");
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
            System.out.println("|              TAMPIL DATA PELANGGAN          |");
            System.out.println("+=============================================+");
            for (Pelanggan tempPelanggan : data) {
                System.out.println("Nama Pelanggan  : " + tempPelanggan.getNama());
                System.out.println("Alamat Pelanggan: " + tempPelanggan.getAlamat());
                System.out.println("Email Pelanggan : " + tempPelanggan.getEmail());
                System.out.println("No. HP          : " + tempPelanggan.getHp());
                System.out.println("Username        : " + tempPelanggan.getUsername());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Pelanggan kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String nama, alamat, email, hp, username, password;
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA PELANGGAN           |");
        System.out.println("+=============================================+");

        System.out.print("Nama Pelanggan  : ");
        nama = input.nextLine();
        System.out.print("Alamat Pelanggan: ");
        alamat = input.nextLine();
        System.out.print("Email Pelanggan : ");
        email = input.nextLine();
        System.out.print("No. HP          : ");
        hp = input.nextLine();
        System.out.print("Username        : ");
        username = input.nextLine();
        System.out.print("Password        : ");
        password = input.nextLine();

        Pelanggan tempPelanggan = new Pelanggan(
            nama, alamat, email, hp, username, password);
        data.add(tempPelanggan);
        System.out.println("+=============================================+");
        System.out.println("|            DATA PELANGGAN TERSIMPAN         |");
        System.out.println("+=============================================+");
        input.nextLine();
    }

    public void edit() {
        int indexPelanggan = pilih();
        if (indexPelanggan != -1) {
            Pelanggan editPelanggan = data.get(indexPelanggan);
            System.out.println("+=============================================+");
            System.out.println("|              EDIT DATA PELANGGAN            |");
            System.out.println("+=============================================+");
            System.out.print("Nama Pelanggan  : ");
            editPelanggan.setNama(input.nextLine());
            System.out.print("Alamat Pelanggan: ");
            editPelanggan.setAlamat(input.nextLine());
            System.out.print("Email Pelanggan : ");
            editPelanggan.setEmail(input.nextLine());
            System.out.print("No. HP          : ");
            editPelanggan.setHp(input.nextLine());
            System.out.print("Username        : ");
            editPelanggan.setUsername(input.nextLine());
            System.out.print("Password        : ");
            editPelanggan.setPassword(input.nextLine());
            data.set(indexPelanggan, editPelanggan);
            System.out.println("+=============================================+");
            System.out.println("|            DATA PELANGGAN TERSIMPAN         |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public void hapus() {
        int indexPelanggan = pilih();
        if (indexPelanggan != -1) {
            data.remove(indexPelanggan);
            System.out.println("+=============================================+");
            System.out.println("|             DATA PELANGGAN DIHAPUS          |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public int pilih() {
        ScreenHelper.clearConsole();
        int pelangganDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                PILIH PELANGGAN              |");
                System.out.println("+=============================================+");
                for (int index = 0; index < data.size(); index++) {
                    Pelanggan tempPelanggan = data.get(index);
                    System.out.println("Index           : " + index);
                    System.out.println("Nama Pelanggan  : " + tempPelanggan.getNama());
                    System.out.println("Alamat Pelanggan: " + tempPelanggan.getAlamat());
                    System.out.println("Email Pelanggan : " + tempPelanggan.getEmail());
                    System.out.println("No. HP          : " + tempPelanggan.getHp());
                    System.out.println("Username        : " + tempPelanggan.getUsername());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih index Pelanggan : ");
                pelangganDipilih = input.nextInt();
                input.nextLine();

            } while (pelangganDipilih == -1);
        } else {
            System.out.println("Data Pelanggan kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return pelangganDipilih;
    }
}
