package Hibernate_Tekrar.Embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {  // @Embeddable annotation ile Adres Class'ını Embeddable hale getirdik (Bu Class'ı Employee Class'ı içerisinde ve  başka Class lardacda kullanabiliriz Ayrıcabir adres tablosu oluşturmaya gerek kalmaz )
    private String cadde;
    private String sehir;
    private String ulke;

    public String getCadde() {
        return cadde;
    }

    public void setCadde(String cadde) {
        this.cadde = cadde;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "cadde='" + cadde + '\'' +
                ", sehir='" + sehir + '\'' +
                ", ulke='" + ulke + '\'' +
                '}';
    }
}
