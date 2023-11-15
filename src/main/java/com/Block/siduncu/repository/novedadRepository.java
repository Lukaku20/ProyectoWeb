/*

 */
package com.Block.siduncu.repository;

import com.Block.siduncu.model.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author siduncuNotebook
 */

@Repository
public interface novedadRepository extends JpaRepository<Novedad, Long>{
    
}
