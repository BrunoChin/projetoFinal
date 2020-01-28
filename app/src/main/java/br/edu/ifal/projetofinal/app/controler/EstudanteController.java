package br.edu.ifal.projetofinal.app.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.projetofinal.app.modelo.Estudante;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioEstudante;

@RestController
@RequestMapping("/estudante")
public class EstudanteController{

    @Autowired
    private RepositorioEstudante repositorioEstudante;

    @GetMapping("/add")
    public ResponseEntity<?> addEstudante(Estudante estudante){
        try {
            repositorioEstudante.save(estudante);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Estudante>> getAllEstudante(){
        Iterable<Estudante> estudantes = repositorioEstudante.findAll();
        if(estudantes != null){
            return new ResponseEntity<Iterable<Estudante>>(estudantes, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Estudante> GetEstudanteById(@PathVariable("id") Long id){
        Optional<Estudante> opcao = repositorioEstudante.findById(id);
        if(opcao.isPresent()){
            Estudante estudante = opcao.get();
            return new ResponseEntity<Estudante>(estudante, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/removeById")
    public ResponseEntity<?> remove(@PathVariable("id") Long id){
        try {
            repositorioEstudante.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateEstudante(@PathVariable("id") Long ig, Estudante estudante){
        try {
            repositorioEstudante.save(estudante);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}
