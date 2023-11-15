/*
 
 */
package com.Block.siduncu.controller;

import com.Block.siduncu.model.Usuario;
import com.Block.siduncu.repository.userRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author siduncuNotebook
 */

@Controller
@RequestMapping("/admin")
public class adminController {
    
    @Autowired
    userRepository repoUsuario;
    
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> lista = repoUsuario.findAll();
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
        Usuario user = repoUsuario.findById(id).orElseThrow(RuntimeException::new);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody Usuario user) throws URISyntaxException{
        Usuario salveUser = repoUsuario.save(user);
        return ResponseEntity.created(new URI ("/" + salveUser.getId())).body(salveUser);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        repoUsuario.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
