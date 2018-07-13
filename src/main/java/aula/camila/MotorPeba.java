package aula.camila;

import org.springframework.stereotype.Component;

@Component
public class MotorPeba implements Motor {

    public String potencia(){
        return "Potência Peba";
    }

}