package aula.camila.screen;

import aula.camila.model.DatabaseHelper;
import aula.camila.model.Person;
import aula.camila.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationScreen {

    @Autowired
    private DatabaseHelper db;

    @Autowired
    private PersonService service;

    public void listarUsuarios(){
        List<Person> list = service.list();
        list.forEach(p ->System.out.println(String.format("%d %s %s", p.getId(),p.getName(), p.getFone())));
    }


    public Long salvarUsuario(){
        Person p = Person.builder()
        .name("Ana")
        .fone("55555555").build();
        p.setId(service.save(p));
        return p.getId();
    }

    public void findByName(){
        List<Person> list = service.findByName("a");
        list.forEach(p ->System.out.println(String.format("%d %s %s", p.getId(),p.getName(), p.getFone())));
    }


}