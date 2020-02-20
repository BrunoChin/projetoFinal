package br.edu.ifal.projetofinal.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.projetofinal.app.modelo.Estudante;
import br.edu.ifal.projetofinal.app.modelo.Responsavel;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioResponsavel;

@RequestMapping("/Responsavel")
@RestController
public class ResponsavelController {

    @Autowired
    RepositorioResponsavel repositorioResponsavel;

    @PostMapping("/add")
    public Responsavel addResponsavel(@RequestBody Responsavel responsavel){
        try {
            return repositorioResponsavel.save(responsavel);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Responsavel> getAll(){
        try {
            return repositorioResponsavel.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getById/{id}")
    public Responsavel getById(@PathVariable("id") Long id){
        try {
            return repositorioResponsavel.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/delete")
    public boolean delete(@PathVariable("id") long id){
        try {
            repositorioResponsavel.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/update")
    public Responsavel update(@RequestBody Responsavel responsavelNewInformation){
        try {
            return repositorioResponsavel.save(responsavelNewInformation);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/addEstudante/{id}")
    public Responsavel addEstudanteNaLista(@RequestBody Estudante estudante, @PathVariable("id")Long id){
        try {
            Responsavel responsavel = repositorioResponsavel.findById(id).get();
            responsavel.addEstudante(estudante);
            repositorioResponsavel.save(responsavel);
            return responsavel;
        } catch (Exception e) {
            return null;
        }
    }
}