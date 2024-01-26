package com.mos.piwoCRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
@Entity
@Table(name ="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    private  long id;
    @Lob
    private  String description;
    @Column(name = "date_reported")
    private  Date dateReported;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "module_qr",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Module module;

    public Ticket() {
        this.description = description;
        this.dateReported = dateReported;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
