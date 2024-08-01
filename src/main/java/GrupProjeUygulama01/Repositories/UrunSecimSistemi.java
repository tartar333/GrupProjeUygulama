package GrupProjeUygulama01.Repositories;

import GrupProjeUygulama01.Repositories.entities.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UrunSecimSistemi {
    
    static Scanner sc = new Scanner(System.in);
    static DatabaseManager<Kiyafet> db = new DatabaseManager<>();
    
    public static void main(String[] args) {
        demoVeriOlustur();
        welcomeMenu();
    }
    
    public static void demoVeriOlustur() {
        List<Kiyafet> kiyafetList = db.getAll();  // List kullanımı
        String[] adlar = {"Tişört", "Pantolon", "Ayakkabı"};
        for (String ad : adlar) {
            for (int i = 0; i < 15; i++) {
                Random random = new Random();
                ERenk[] renkArr = ERenk.values();
                ESize[] sizeArr = ESize.values();
                EGender[] genderArr = EGender.values();
                ETur[] turArr = ETur.values();
                
                Kiyafet kiyafet = new Kiyafet(ad, random.nextDouble(400, 1000));
                kiyafet.setRenk(renkArr[random.nextInt(renkArr.length)]);
                kiyafet.setSize(sizeArr[random.nextInt(sizeArr.length)]);
                kiyafet.setGender(genderArr[random.nextInt(genderArr.length)]);
                kiyafet.setTur(turArr[random.nextInt(turArr.length)]);
                kiyafet.setAdet(random.nextInt(1, 21));
                db.save(kiyafet);
            }
        }
        System.out.println("Demo veriler oluşturuldu.");
        kiyafetList.forEach(System.out::println);
    }
    
    public static void welcomeMenu() {
        Sepet sepet = new Sepet();
        while (true) {
            System.out.println("1 - Ürün listele");
            System.out.println("2 - Sepete ürün ekle");
            System.out.println("3 - Sepeti görüntüle");
            System.out.println("4 - Sepeti boşalt");
            System.out.println("0 - Çıkış yap");
            
            System.out.print("Seçiminiz: ");
            int secim = sc.nextInt();
            sc.nextLine();
            
            switch (secim) {
                case 0:
                    System.out.println("Çıkış yapıyorsunuz.");
                    sc.close();
                    return;
                case 1:
                    listProducts();
                    break;
                case 2:
                    urunSec(sepet);
                    break;
                case 3:
                    sepetiGoster(sepet);
                    break;
                case 4:
                    sepet.bosalt();
                    System.out.println("Sepet boşaltıldı.");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
    
    public static void listProducts() {
        db.getAll().forEach(System.out::println);
    }
    
    public static void urunSec(Sepet sepet) {
        while (true) {
            System.out.print("Almak istediğiniz ürün için ID giriniz: ");
            int secim = sc.nextInt();
            Urun urun = db.findByID(secim);
            if (urun == null) {
                System.out.println("Girdiğiniz ID'de kayıtlı ürün bulunmamaktadır.");
                return;
            }
            urunSecenekleri(urun, sepet);
            return;
        }
    }
    
    public static void urunSecenekleri(Urun urun, Sepet sepet) {
        System.out.println("1 - Sepete ekle");
        System.out.println("2 - Ürün detaylarını göster");
        System.out.println("0 - Ana menüye geri dön");
        System.out.print("Seçiminiz: ");
        int secim = sc.nextInt();
        switch (secim) {
            case 0:
                System.out.println("Ana menüye dönüyorsunuz.");
                break;
            case 1:
                sepeteEkle(urun, sepet);
                break;
            case 2:
                System.out.println(urun.toStringDetailed());
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
        }
    }
    
    public static void sepeteEkle(Urun urun, Sepet sepet) {
        System.out.println("Bu üründen " + urun.getAdet() + " adet bulunmaktadır.");
        System.out.print("Kaç adet almak istersiniz? ");
        int adet = sc.nextInt();
        if (adetCheck(urun, adet)) {
            Urun sepetUrun = new Urun(urun, adet);
            sepet.setToplamFiyat(sepet.getToplamFiyat() + urun.getFiyat() * adet);
            urun.setAdet(urun.getAdet() - adet);
            if (urun.getAdet() == 0) {
                db.getUrunList().remove(urun);
            }
            sepet.getUrunArrayList().add(sepetUrun);
            System.out.println("Ürün sepete eklenmiştir.");
        } else {
            System.out.println("Bu üründen yeterli sayıda stoğumuz bulunmamaktadır.");
        }
    }
    
    public static boolean adetCheck(Urun urun, int adet) {
        return urun.getAdet() >= adet;
    }
    
    public static void sepetiGoster(Sepet sepet) {
        System.out.println("Sepetinizin özeti: " + sepet);
        for (Urun urun : sepet.getUrunArrayList()) {
            System.out.println(urun.getUrunAd() + " -- " + urun.getAdet() + " x " + urun.getFiyat() + " = " + (urun.getAdet() * urun.getFiyat()));
        }
    }
}