package com.mos.piwoCRUD.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Module {
    @GeneratedValue
    private  int id;
    @Id
    private  String qr;
    private  boolean isBroken;

    public Module(@JsonProperty("id") int id,
                  @JsonProperty("qr") String qr,
                  @JsonProperty("flag") boolean isBroken) {
        this.id = id;
        this.qr = qr;
        this.isBroken = isBroken;
    }

    public Module() {
        super();
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
}
