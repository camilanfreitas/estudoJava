package aula.camila.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DatabaseHelper {

    @Autowired
    JdbcTemplate jdbc;

    @PostConstruct
    public void construirEstrutura(){
        jdbc.execute("CREATE TABLE IF NOT EXISTS PERSON(ID BIGINT AUTO_INCREMENT, NAME VARCHAR(50) NOT NULL , FONE VARCHAR(15) NOT NULL)");
    }

}