package com.mos.piwoCRUD.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Ticket {
    private final int id;
    private final String description;
    private final Date dateReported;

    public Ticket(@JsonProperty("id") int id,
                  @JsonProperty("description") String description,
                  @JsonProperty("date") Date dateReported) {
        this.id = id;
        this.description = description;
        this.dateReported = dateReported;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateReported() {
        return dateReported;
    }
}
