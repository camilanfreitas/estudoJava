package aula.camila.service;

import aula.camila.model.Person;
import aula.camila.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public Long save(Person person){
        if(person.getId() == null){
            return repository.insert(person);
        }else{
            repository.update(person);
            return person.getId();
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    public Person findById(Long id){
        Optional<Person> p = repository.findById(id);
        p.orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        //p.orElse(Person.builder().id(1L).name("Teste").fone("xpto").build());
//        return p.orElseGet(() -> {
//            //metod busca nan receita
//            return Person.builder().id(1L).name("Teste").fone("xpto").build();
//        });
        return p.get();
    }

}