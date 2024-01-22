package med.voll.api.controller;//a package controller e onde controlamos a rota da nossa aplicação = a view em .py

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//aqui fala que essa classe PERTENCE ao controller especificamente ao REST
@RequestMapping("/hello")//essa anotação é responsavel por dar a pagina de acesso
public class HelloController {
    @GetMapping//essa anotação e responsavel por falar qual vai ser a função se e get ou set etc
    public String olaMundo(){

        return "hello,World";
    }
}
