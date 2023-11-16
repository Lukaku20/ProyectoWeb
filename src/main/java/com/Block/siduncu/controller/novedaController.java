package com.Block.siduncu.controller;

import com.Block.siduncu.model.Novedad;
import com.Block.siduncu.model.Usuario;
import com.Block.siduncu.repository.novedadRepository;
import com.Block.siduncu.repository.userRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author siduncuNotebook
 */
@RestController
@RequestMapping("/")
public class novedaController {

    @Autowired
    novedadRepository notaRepo;
    @Autowired
    userRepository repoUsuario;

    /*crear los métodos CRUD para la entidad
    operaciones CREATE , READ , UPTADE & DELETE

     */
    @GetMapping("/novedades")
    public List<Novedad> getAll() {
        List<Novedad> notas = notaRepo.findAll();
        return notas;
    }

    @GetMapping("/novedades/{id}")
    public Novedad getNovedad(@PathVariable Long id) {
        return notaRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/novedades/{id}")
    public ResponseEntity updateNovedad(@PathVariable Long id, @RequestBody Novedad nota) {
        Novedad currentNota = notaRepo.findById(id).orElseThrow(RuntimeException::new);
        currentNota.setTitule(nota.getTitule());
        currentNota.setContain(nota.getContain());
        currentNota.setSeccion(nota.getSeccion());
        currentNota = notaRepo.save(nota);
        return ResponseEntity.ok(currentNota);
    }

    @DeleteMapping("/novedades/{id}")
    public ResponseEntity deleteNovedad(@PathVariable Long id) {
        notaRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/novedades")
    public ResponseEntity createNovedad(@RequestBody Novedad nota) {
        Novedad newNota = notaRepo.save(nota);
        return ResponseEntity.ok(newNota);
    }

    //intento de metodo que asigne una nota a un usuario y al usuario agrega 
    //a la lista de notas
    @PostMapping("/novedades-user")
    public ResponseEntity createNovedadUser(@RequestBody Novedad nota, @RequestParam Long usuarioId) {
        Usuario usuario = repoUsuario.findById(usuarioId).orElseThrow(RuntimeException::new);
        nota.setUsuario(usuario);
        Novedad newNota = notaRepo.save(nota);
        return ResponseEntity.ok(newNota);
    }

}
