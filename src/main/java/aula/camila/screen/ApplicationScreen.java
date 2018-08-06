package aula.camila.screen;

import aula.camila.model.DatabaseHelper;
import aula.camila.model.Person;
import aula.camila.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationScreen {

    @Autowired
    private DatabaseHelper db;

    @Autowired
    private PersonService service;

    public void salvarUsuario(){
        Person p = new Person();
        p.setName("Camila");
        p.setFone("62999999");
        p.setId(service.save(p));
    }


}