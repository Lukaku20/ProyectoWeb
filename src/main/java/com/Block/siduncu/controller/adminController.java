/*
 
 */
package com.Block.siduncu.controller;

import com.Block.siduncu.model.Usuario;
import com.Block.siduncu.repository.userRepository;
import com.Block.siduncu.service.notaService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siduncuNotebook
 */

@Controller
@RequestMapping("/admin")
public class adminController {
    
    @Autowired
    notaService servicioNota;
    
    @PostMapping("/crear")
    public String crearNovedad(@RequestParam String titule, @RequestParam String contain, @RequestParam String seccion, ModelMap model){
        try {
            servicioNota.crearNota(titule, contain, seccion);
            model.put("exito", "Se ha guardado con exito");
            return "redirect:../admin";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "formulario";
        }
    }
    
}

