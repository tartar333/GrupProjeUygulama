package GrupProjeUygulama01.Repositories.entities;

public class Kiyafet extends Urun{

    private ETur tur;
    private ERenk renk;
    private ESize size;
    private EGender gender;


    public Kiyafet(String urunAd, Double fiyat) {
        super(urunAd, fiyat);
    }

    public ETur getTur() {
        return tur;
    }

    public void setTur(ETur tur) {
        this.tur = tur;
    }

    public ERenk getRenk() {
        return renk;
    }

    public void setRenk(ERenk renk) {
        this.renk = renk;
    }

    public ESize getSize() {
        return size;
    }

    public void setSize(ESize size) {
        this.size = size;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Kiyafet{" +
                "id=" + getId() +
                ", urunAd='" + getUrunAd() + '\'' +
                ", fiyat=" + getFiyat() +
                '}';
    }


    public String toStringDetailed() {
        return "Kiyafet{" +
                "id=" + getId() +
                ", urunAd='" + getUrunAd() + '\'' +
                ", fiyat=" + getFiyat() +
                ", adet=" + getAdet() +
                ", tur=" + getTur() +
                ", renk=" + getRenk() +
                ", size=" + getSize() +
                ", gender=" + getGender() +
                '}';
    }
}