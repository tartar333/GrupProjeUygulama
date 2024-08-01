package GrupProjeUygulama01.Repositories.entities;



import java.util.ArrayList;

public class Sepet {

    private Double toplamFiyat =0.;
    ArrayList<Urun> urunArrayList;

    public Sepet(){
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

    {

    }
    
    @Override
    public String toString() {
        return "Sepet{" + "toplamFiyat=" + toplamFiyat + '}';
    }
}