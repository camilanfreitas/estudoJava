package aula.camila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Carro {

    private String nome;

    @Autowired
    private Motor motor;

    public Carro(){

    }

    public void acelerar(){
        System.out.println(motor.potencia());
    }

    public Carro(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}