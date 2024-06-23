import java.util.ArrayList;
import java.util.Scanner;

import onlineshop.controller.Penjual;
import onlineshop.controller.Pelanggan;
import onlineshop.menu.MainMenuAdmin;
import onlineshop.menu.MainMenuPelanggan;
import onlineshop.utility.DataOnlineShop;
import onlineshop.utility.ScreenHelper;

public class OnlineShop {
    private static Scanner input = new Scanner(System.in);
    private static DataOnlineShop masterData = new DataOnlineShop();
    private static ArrayList<Penjual> dataPenjual;
    private static ArrayList<Pelanggan> dataPelanggan;
    private static Penjual activePenjual;
    private static Pelanggan activePelanggan;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        dataPenjual = masterData.initPenjual();
        dataPelanggan = masterData.initPelanggan();

        while (isRunning) {
            showMenu();
        }
    }

    private static void showMenu() {
        while (activePenjual == null && activePelanggan == null) {
            loginMenu();
        }

        if (activePenjual != null) {
            MainMenuAdmin menuOnlineShop = new MainMenuAdmin(dataPenjual, activePenjual);
            menuOnlineShop.tampilMenu();
            activePenjual = null;
        } else if (activePelanggan != null) {
            MainMenuPelanggan menuOnlineShop =new MainMenuPelanggan(dataPelanggan, activePelanggan, masterData);
            menuOnlineShop.tampilMenu();
            activePelanggan = null;
        }

        System.out.print("Apakah anda ingin menutup program ini? (y | t) : ");
        String jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("y")) {
            isRunning = false;
            System.out.print("Terima kasih telah menggunakan program ini :)");
        }
    }

    private static void loginMenu() {
        ScreenHelper.clearConsole();
        String username, password;
        System.out.println("+=============================================+");
        System.out.println("|                LOGIN ONLINE SHOP            |");
        System.out.println("+=============================================+");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();

        for (Penjual temp : dataPenjual) {
            if (temp.login(username, password)) {
                activePenjual = temp;
                return;
            }
        }

        for (Pelanggan temp : dataPelanggan) {
            if (temp.login(username, password)) {
                activePelanggan = temp;
                return;
            }
        }

        System.out.println("Login gagal! Username atau password salah.");
    }
}
