package aula.camila.service;

import aula.camila.model.Person;
import aula.camila.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void delete(Long id){

    }

    public Person findById(Long id){
        return null;
    }

}