package aula.camila.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private Long id;
    private String name;
    private String fone;
}
