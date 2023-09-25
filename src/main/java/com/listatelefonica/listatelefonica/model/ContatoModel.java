package com.listatelefonica.listatelefonica.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "Contatos")
@Getter
@Setter
public class ContatoModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private String nome;
    private char[] telefone = new char[11];
}
