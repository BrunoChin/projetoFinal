package br.edu.ifal.projetofinal.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.projetofinal.app.modelo.Administrador;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioAdminstrador;

@RestController
@RequestMapping("/Administrador")
public class AdminstradorController{

    @Autowired
    RepositorioAdminstrador repositorioAdminstrador;

    @PostMapping("/add")
    public Administrador add(@RequestBody Administrador administrador){
        try {
            return repositorioAdminstrador.save(administrador);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getAll")
    public List<Administrador> getAll(){
        try {
            return repositorioAdminstrador.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/getById/{id}")
    public Administrador getById(@PathVariable("id") Long id){
        try {
            return repositorioAdminstrador.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        try {
            repositorioAdminstrador.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/update")
    public Administrador update(@RequestBody Administrador professorNewInformation){
        try {
            if(repositorioAdminstrador.findById(professorNewInformation.getId()).isPresent())
                return repositorioAdminstrador.save(professorNewInformation);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}