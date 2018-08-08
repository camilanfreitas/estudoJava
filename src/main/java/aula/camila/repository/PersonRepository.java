package aula.camila.repository;

import aula.camila.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PersonRepository {

    private String sqlDefault = "SELECT ID, NAME , FONE FROM PERSON";

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
        Map<String,Object> param = new HashMap();
        param.put("name", person.getName());
        param.put("fone", person.getFone());
        return insert.executeAndReturnKey(param).longValue();
    }

    public void update(Person person){
        String sql = "UPDATE PERSON SET NAME = :name , FONE = :fone WHERE ID = :id";
        Map<String,Object> param = new HashMap();
        param.put("id"  ,person.getId());
        param.put("name",person.getName());
        param.put("fone",person.getFone());
        jdbc.update(sql,param);
    }

    public void delete(Long id){
        String sql = "DELETE FROM PERSON WHERE ID = :id";
        Map<String,Object> param = new HashMap();
        param.put("id",id);
        jdbc.update(sql,param);
    }

    public List<Person> list(){
        String sql = sqlDefault + " order by name";
        Map<String,Object> param = new HashMap();
        return jdbc.query(sql,param,this::mapRow);
    }

    public List<Person> findByName(String name){
        String sql = sqlDefault + " where upper(name) like :name";
        Map<String,Object> param = new HashMap();
        param.put("name","%" + name.toUpperCase() +"%");
        return jdbc.query(sql,param, this::mapRow);
    }

    public Optional<Person> findById(Long id){
        String sql = sqlDefault + " where id =  :id";
        Map<String,Object> param = new HashMap();
        param.put("id",id);
        try{
            return Optional.of(jdbc.queryForObject(sql,param, this::mapRow));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    private Person mapRow(ResultSet rs, int i) throws SQLException {
        return Person.builder()
                .id          (rs.getLong   ("id"))
                .name        (rs.getString ("name"))
                .fone        (rs.getString("fone"))
                .build();
    }

}