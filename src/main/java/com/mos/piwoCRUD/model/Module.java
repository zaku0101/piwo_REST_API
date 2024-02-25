package com.mos.piwoCRUD.model;

import jakarta.persistence.*;


@Entity
public class Module {

    @Id
    private String qr;

    private  boolean broken;

    public Module(String qr, boolean broken) {
        this.qr = qr;
        this.broken = broken;
    }

    public Module() {

    }


    public String getQr() {
        return qr;
    }

    public boolean isBroken() {
        return broken;
    }



    public void setQr(String qr) {
        this.qr = qr;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }
}
