package GrupProjeUygulama01.Repositories.entities;

import java.util.ArrayList;

public class Sepet {
    
    private Double toplamFiyat = 0.0;
    private ArrayList<Urun> urunArrayList;
    
    public Sepet() {
        urunArrayList = new ArrayList<>();
    }
    
    public ArrayList<Urun> getUrunArrayList() {
        return urunArrayList;
    }
    
    public Double getToplamFiyat() {
        return toplamFiyat;
    }
    
    public void setToplamFiyat(Double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }
    
    public void bosalt() {
        urunArrayList.clear();
        toplamFiyat = 0.0;
    }
    
    @Override
    public String toString() {
        return "Sepet{" + "toplamFiyat=" + toplamFiyat + '}';
    }
}