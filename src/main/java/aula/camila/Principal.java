package aula.camila;

import aula.camila.screen.ApplicationScreen;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ApplicationScreen app = (ApplicationScreen)context.getBean("applicationScreen");
        //System.out.println(app.salvarUsuario());
        //app.listarUsuarios();
        app.findByName();
    }

}