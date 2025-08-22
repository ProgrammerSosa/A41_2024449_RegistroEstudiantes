package org.binaryminds.registroEstudiante;

import org.binaryminds.registroEstudiante.dominio.Service.ICursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistroEstudianteApplication implements CommandLineRunner {

	public static void main(String[] args) {


    // Inyección de dependencias
  @Autowired
    private ICursoService cursoServiceService ;



    // Crear nuestro Objeto (herramienta) para interactuar con la consola
    private static final Logger logger = LoggerFactory.getLogger(RegistroEstudianteApplication.class);



    // Crear un Objeto String para saltos de línea porque no los maneja el Logger
    String sl = System.lineSeparator(); // Salto de línea



    public static void main(String[] args) {
        logger.info("AQUÍ INICIA NUESTRA APLICACIÓN");
        SpringApplication.run(registroEstudianteCursoApp.class, args);
        logger.info("AQUÍ TERMINÓ LA APLICACIÓN");
    }

    }

    @Override
    public void run(String... args) throws Exception {
        registroEstudianteCursoApp();

    }


}
