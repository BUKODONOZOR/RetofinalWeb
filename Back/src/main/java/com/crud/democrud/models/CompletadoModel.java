package com.crud.democrud.models;

import javax.persistence.*;


@Entity
@Table(name = "completado")
public class CompletadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Boolean completado;

    @OneToOne()
    private TareaModel usuario; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public CompletadoModel(Boolean completado) {
        this.completado = completado;

    }

    public CompletadoModel() {

    }



}