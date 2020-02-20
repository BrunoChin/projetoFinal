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
import br.edu.ifal.projetofinal.app.modelo.Turma;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioTurma;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    RepositorioTurma repositorioTurma;

    @PostMapping("/add")
    public Turma add(@RequestBody Turma turma){
        try {
            return repositorioTurma.save(turma);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Turma> getAll(){
        try {
            return repositorioTurma.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getById/{id}")
    public Turma getByID(@PathVariable("id") Long id){
        try {
            return repositorioTurma.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        try {
            repositorioTurma.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Turma update(@RequestBody Turma turmaNewInformation){
        try {
            if(repositorioTurma.findById(turmaNewInformation.getId()).isPresent())
                return repositorioTurma.save(turmaNewInformation);
            else
                return null;

        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/addEstudante/{id}")
    public Turma addEstudanteNaLista(@RequestBody Estudante estudante, @PathVariable("id")Long id){
        try {
            Turma turma = repositorioTurma.findById(id).get();
            turma.addEstudante(estudante);
            repositorioTurma.save(turma);
            return turma;
        } catch (Exception e) {
            return null;
        }
    }
}