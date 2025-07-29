package com.joaop.opinions.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String comment;
    private int rate;
    @Column(insertable = false,updatable = false)
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
