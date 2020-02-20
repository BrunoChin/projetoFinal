package br.edu.ifal.projetofinal.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.projetofinal.app.modelo.Professor;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioProfessor;

@RestController
@RequestMapping("/professor")
public class ProfessorController{

    @Autowired
    RepositorioProfessor repositorioProfessor;

    @PostMapping("/add")
    public Professor add(@RequestBody Professor professor){
        try {
            return repositorioProfessor.save(professor);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Professor> getAll(){
        try {
            return repositorioProfessor.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getById/{id}")
    public Professor getById(@PathVariable("id") Long id){
        try {
            return repositorioProfessor.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getByCpf")
    public Professor getByCpf(@RequestBody String cpf){
        try {
            System.out.println(cpf);
            return repositorioProfessor.findByCpf(cpf);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        try {
            repositorioProfessor.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/update")
    public Professor update(@RequestBody Professor professorNewInformation){
        try {
            if(repositorioProfessor.findById(professorNewInformation.getId()).isPresent())
                return repositorioProfessor.save(professorNewInformation);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}