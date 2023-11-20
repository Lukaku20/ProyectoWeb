/*

 */
package com.Block.siduncu.service;

import com.Block.siduncu.exception.MyException;
import com.Block.siduncu.model.Novedad;
import com.Block.siduncu.repository.novedadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author siduncuNotebook
 */

@Service
public class notaService {
    
    @Autowired
    novedadRepository notaRepo;
    
    @Transactional
    public void crearNota(String titule, String contain, String seccion) throws MyException{
        validar(titule, contain, seccion);
        Novedad nueva = new Novedad();
        nueva.setTitule(titule);
        nueva.setContain(contain);
        nueva.setSeccion(seccion);
        nueva.setState(true);
        notaRepo.save(nueva);
        
    }
    
    
    //funcion para validar datos completados
    private void validar(String titule, String contain, String seccion) throws MyException {
        if (titule.isEmpty() || titule == null) {
            throw new MyException("el email no puede ser nulo");
        }
        if (contain.isEmpty() || contain == null) {
            throw new MyException("el nombre no puede estar vacio");
        }
        if (seccion.isEmpty() || seccion == null) {
            throw new MyException("la contraseña debe tener mas de 8 caracteres");
        }
     
    }
}
