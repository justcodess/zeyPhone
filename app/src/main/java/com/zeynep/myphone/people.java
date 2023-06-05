package com.zeynep.myphone;

public class people {
    private String ad,soyad,numara,id;



    public people(String ad,String soyad,String numara) {
        this.ad = ad;
        this.soyad= soyad;
        this.numara = numara;

    }

    public people(String numara) {
        this.numara=numara;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }



    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeletable() {
        return true;
    }


    public void setDeletable(boolean b) {
    }
}
