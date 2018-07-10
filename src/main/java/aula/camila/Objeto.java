package aula.camila;

public class Objeto {

    private String nome;

    public Objeto(){

    }

    public Objeto(String nome){
        this.nome = nome;
    }

    public void cumprimentar(){
        System.out.println("Olá eu sou o " + nome +  " , você quer ser meu amigo?");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}