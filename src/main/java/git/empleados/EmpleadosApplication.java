package git.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicacion Spring Boot.
 * @SpringBootApplication activa el escaneo de componentes, la configuracion
 * automatica y el arranque del servidor Tomcat embebido.
 */
@SpringBootApplication
public class EmpleadosApplication {

    // Punto de entrada de la aplicacion
    // Spring Boot levanta el contexto y el servidor con SpringApplication.run()
    public static void main(String[] args) {
        SpringApplication.run(EmpleadosApplication.class, args);
    }

}
