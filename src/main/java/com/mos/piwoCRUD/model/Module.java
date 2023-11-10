package com.mos.piwoCRUD.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Module {
    private final int id;
    private final String qr;
    private final boolean isBroken;

    public Module(@JsonProperty("id") int id,
                  @JsonProperty("qr") String qr,
                  @JsonProperty("flag") boolean isBroken) {
        this.id = id;
        this.qr = qr;
        this.isBroken = isBroken;
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
