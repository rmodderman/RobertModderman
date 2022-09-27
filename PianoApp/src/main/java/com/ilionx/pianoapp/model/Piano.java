package com.ilionx.pianoapp.model;

import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Piano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private float price;
    private LocalDate localDateBuilt;

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocalDateBuiltAsString () {
        return this.localDateBuilt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate getLocalDateBuilt() {
        return localDateBuilt;
    }

    public void setLocalDateBuilt(String dateBuilt) {
        this.localDateBuilt = LocalDate
                .parse(dateBuilt, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
