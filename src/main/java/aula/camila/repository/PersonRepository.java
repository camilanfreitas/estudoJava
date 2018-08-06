package aula.camila.repository;

import aula.camila.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    private SimpleJdbcInsert insert;

    @Autowired
    public void setJdbc(DataSource dataSource){
        insert = new SimpleJdbcInsert(dataSource)
                .withTableName("Person")
                .usingColumns("name","fone")
                .usingGeneratedKeyColumns("id");
    }

    public Long insert(Person person){
        Map param = new HashMap();
        param.put("name", person.getName());
        param.put("fone", person.getFone());
        return insert.executeAndReturnKey(param).longValue();
    }

    public void update(Person person){

    }

    public Person findById(Long id){
        return null;
    }

}