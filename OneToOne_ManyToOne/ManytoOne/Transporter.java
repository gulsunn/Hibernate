package Hibernate_Tekrar.OneToOne_ManyToOne.ManytoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transporter {
    @Id
    @Column(length = 8)
    private String plaka;
    private String marka;
    private int model;

    private String guzergah;

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getModel() {
        return model;
    }

    public String getGuzergah() {
        return guzergah;
    }

    public void setGuzergah(String guzergah) {
        this.guzergah = guzergah;
    }

    public void setModel(int model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Transporter{" +
                "plaka='" + plaka + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
