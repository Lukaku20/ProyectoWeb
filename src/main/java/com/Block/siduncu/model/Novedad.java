/*
 */

package com.Block.siduncu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author siduncuNotebook
 */
@Getter
@Setter
@Entity
public class Novedad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idnota;
    private String titule;
    private String contain;
    
    private boolean state;
    
    private String seccion;

      
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    
    public Novedad() {
    
    }
    
    
}
