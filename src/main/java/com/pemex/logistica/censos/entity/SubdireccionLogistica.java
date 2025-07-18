package com.pemex.logistica.censos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class SubdireccionLogistica extends Subdireccion {

    public SubdireccionLogistica() {
        // Default constructor
    }

    // Additional fields and methods specific to SubdireccionLogistica can be added
    // here
    // For example, if there are specific attributes or behaviors for the logistics
    // subdirection,
    // they can be defined in this class.

    // Example field (uncomment and modify as needed):
    // @Column(name = "logistics_specific_field")
    // private String logisticsSpecificField;

    @OneToMany(mappedBy = "subdireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Gerencia> gerencias;

}
