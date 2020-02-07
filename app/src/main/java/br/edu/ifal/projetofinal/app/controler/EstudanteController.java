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
import br.edu.ifal.projetofinal.app.repositorios.RepositorioEstudante;

@RestController
@RequestMapping("/estudante")
public class EstudanteController{

    @Autowired
    private RepositorioEstudante repositorioEstudante;

    @PostMapping("/add")
    public Estudante addEstudante(@RequestBody Estudante estudante){
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
           return null;
        }
    }

    @GetMapping("/getById/{id}")
    public Estudante GetEstudanteById(@PathVariable("id") Long id){
        try {
            return repositorioEstudante.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/removeById/{id}")
    public boolean remove(@PathVariable("id") Long id){
        try {
            repositorioEstudante.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/update/{id}")
    public Estudante updateEstudante(@PathVariable("id") Long id,@RequestBody Estudante estudanteNewInformecion){
        try {
            Estudante estudante = repositorioEstudante.findById(id).get();
            if(estudante != null){
                estudante.setNome(estudanteNewInformecion.getNome());
                estudante.setIdade(estudanteNewInformecion.getIdade());;
                return repositorioEstudante.save(estudante);
            }
            else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
