package com.mos.piwoCRUD.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Ticket {
    @GeneratedValue
    @Id
    private  long id;

    private  String description;
    private  Date dateReported;

    public Ticket(@JsonProperty("id") int id,
                  @JsonProperty("description") String description,
                  @JsonProperty("date") Date dateReported) {
        this.id = id;
        this.description = description;
        this.dateReported = dateReported;
    }

    public Ticket() {

    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateReported() {
        return dateReported;
    }
}
