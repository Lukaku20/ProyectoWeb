/*
 
 */
package com.Block.siduncu.repository;

import com.Block.siduncu.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siduncuNotebook
 */

@Repository
public interface userRepository extends JpaRepository<Usuario, Long>{
 
    
    
}
