package aula.camila.repository;

import aula.camila.model.Person;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    //@Autowired
    private NamedParameterJdbcTemplate jdbc;

    public Long insert(Person person){
        return 0L;
    }

    public void update(Person person){

    }

}
