package com.mos.piwoCRUD.model;

import jakarta.persistence.*;

@Entity
@Table(name="modules")
public class Module {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_generator")
    @Column(name = "module_id")
    private  int id;
    @Id
    private  String qr;
    @Column(name = "is_broken")
    private  boolean isBroken;

    public Module(String qr, boolean b) {
        this.qr = this.qr;
        this.isBroken = isBroken;
    }

    public Module() {

    }

    public int getId() {
        return id;
    }

    public String getQr() {
        return qr;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
