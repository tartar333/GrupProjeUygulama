package GrupProjeUygulama01.Repositories;

import GrupProjeUygulama01.Repositories.entities.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UrunSecimSistemi {
    static Scanner sc = new Scanner(System.in);
    static DatabaseManager<Kiyafet> db = new DatabaseManager();

    public static void main(String[] args) {

       demoVeriOlustur();
       welcomeMenu();



    }

    public static void demoVeriOlustur(){
        ArrayList<Kiyafet> kiyafetList = db.urunList;
        for(int i =0;i<50;i++){
            Random random = new Random();
            ERenk[] renkArr = ERenk.values();
            ESize[] sizeArr = ESize.values();
            EGender[] genderArr = EGender.values();
            ETur[] turArr = ETur.values();

            Kiyafet kiyafet = new Kiyafet("kiyafet", random.nextDouble(400,1000));
            kiyafet.setRenk(renkArr[random.nextInt(3)]);
            kiyafet.setSize(sizeArr[random.nextInt(3)]);
            kiyafet.setGender(genderArr[random.nextInt(3)]);
            kiyafet.setTur(turArr[random.nextInt(4)]);
            kiyafet.setAdet(random.nextInt(1,21));
            db.save(kiyafet);

        }
        System.out.println(kiyafetList);

    }






    public static void welcomeMenu() {
        while (true) {
            System.out.println("1- Ürün listele");
            System.out.println("2- Sepete ürün ekle");
            System.out.println("3- Sepeti görüntüle");
            System.out.println("0- Çıkış yap");


        System.out.print("Seciminiz: ");
        int secim = sc.nextInt();
        sc.nextLine();

            switch (secim) {
                case 0:
                    System.out.println("Çıkış yapıyorsunuz.");
                    sc.close();
                    return;
                case 1:{
                   db.getAll();

                }
            }
        }
    }

    public static void sizeSec(Kiyafet kiyafet) {
        while (true) {
            System.out.println("Urun icin size seciniz");
            System.out.println("1- Small");
            System.out.println("2- Medium");
            System.out.println("3- Large");
            System.out.print("Seciminiz: ");
            int secim = sc.nextInt();
            sc.nextLine();

        }

    }

}