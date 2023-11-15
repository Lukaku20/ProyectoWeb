/*

 */
package com.Block.siduncu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author siduncuNotebook
 */

@Getter
@Setter
@Entity
@Table(name = "User")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String direction;
    private int phone;

    //boolean
    private boolean active;

    @OneToMany(mappedBy = "usuario")
    private List<Novedad> novedades;

    public Usuario() {
    }

}
