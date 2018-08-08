package aula.camila.screen;

import aula.camila.model.DatabaseHelper;
import aula.camila.model.Person;
import aula.camila.repository.PersonRepository;
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

    @Autowired
    private PersonRepository repository;

    public void listarUsuarios(){
        List<Person> list = repository.list();
        list.forEach(p ->System.out.println(String.format("%d %s %s", p.getId(),p.getName(), p.getFone())));
    }

    public void deletar(){
        service.delete(1L);
        System.out.println("Deletado registro 1");
    }


    public Long salvarUsuario(){
        Person p = Person.builder()
        .name("Ana")
        .fone("55555555").build();
        p.setId(service.save(p));
        return p.getId();
    }

    public void findByName(){
        List<Person> list = repository.findByName("c");
        list.forEach(p ->System.out.println(String.format("%d %s %s", p.getId(),p.getName(), p.getFone())));
    }

    public void findById(){
        try {
            Person p = service.findById(10L);
            System.out.println(String.format("%d %s %s", p.getId(), p.getName(), p.getFone()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void alterar(){
        try {
            Person p = service.findById(1L);
            p.setName("Camilão");
            service.save(p);
            System.out.println(String.format("%d %s %s", p.getId(), p.getName(), p.getFone()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}