package elektrik.santral.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "santral")
public class Titles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long santralId;
    private String kaynakAdi;
    private String kurulusAdi;
    private String saatAdi;
    private Long saatId;
    private Double uretim;
    private Boolean yekdem;
    private String etsoKodu;
    private Date tarih;


    public String getEtsoKodu() {
        return etsoKodu;
    }

    public void setEtsoKodu(String etsoKodu) {
        this.etsoKodu = etsoKodu;
    }

    public String getKaynakAdi() {
        return kaynakAdi;
    }

    public void setKaynakAdi(String kaynakAdi) {
        this.kaynakAdi = kaynakAdi;
    }

    public String getKurulusAdi() {
        return kurulusAdi;
    }

    public void setKurulusAdi(String kurulusAdi) {
        this.kurulusAdi = kurulusAdi;
    }

    public String getSaatAdi() {
        return saatAdi;
    }

    public void setSaatAdi(String saatAdi) {
        this.saatAdi = saatAdi;
    }

    public Long getSaatId() {
        return saatId;
    }

    public void setSaatId(Long saatId) {
        this.saatId = saatId;
    }

    public Long getSantralId() {
        return santralId;
    }

    public void setSantralId(Long santralId) {
        this.santralId = santralId;
    }

    public Double getUretim() {
        return uretim;
    }

    public void setUretim(Double uretim) {
        this.uretim = uretim;
    }

    public boolean isYekdem() {
        return yekdem;
    }

    public void setYekdem(boolean yekdem) {
        this.yekdem = yekdem;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
