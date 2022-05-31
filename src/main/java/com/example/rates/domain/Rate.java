package com.example.rates.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Rate {

    @Id
    private String code;

    private Float rate;

    @JsonIgnore
}
