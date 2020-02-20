package br.edu.ifal.projetofinal.app.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.projetofinal.app.modelo.Professor;
import br.edu.ifal.projetofinal.app.repositorios.RepositorioProfessor;

@RestController
@RequestMapping("/login")
public class LoginController{

    @Autowired
    RepositorioProfessor repositorioProfessor;

    @GetMapping("/professor")
    public Professor validarLogin(@RequestBody Map <String, String> valores){
        try {
            System.out.println(valores);
            Professor professor = repositorioProfessor.findByCpf(valores.get("cpf"));
            if(professor != null){
                if(professor.getSenha().equals(valores.get("senha")))
                    return professor;
                else
                    return null;
            }
            else   
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}