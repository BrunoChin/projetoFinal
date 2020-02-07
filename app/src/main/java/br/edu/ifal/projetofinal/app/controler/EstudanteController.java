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

    @PostMapping("/add")
    public Estudante addEstudante(Estudante estudante){
        try {
            return repositorioEstudante.save(estudante);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Estudante> getAllEstudante(){
        
        try {
            return repositorioEstudante.findAll();
        } catch (Exception e) {
           return null
        }
    }

    @GetMapping("/getById/{id}")
    public Estudante GetEstudanteById(@PathVariable("id") Long id){
        try {
            return repositorioEstudante.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/removeById/{id}")
    public Estudante remove(@PathVariable("id") Long id){
        try {
            return repositorioEstudante.deleteById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/update")
    public Estudante updateEstudante(@PathVariable("id") Long ig, Estudante estudante){
        try {
            return repositorioEstudante.save(estudante);
        } catch (Exception e) {
            return null;
        }
    }
}
