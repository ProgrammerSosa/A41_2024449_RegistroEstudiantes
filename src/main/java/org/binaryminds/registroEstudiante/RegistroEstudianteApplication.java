package org.binaryminds.registroEstudiante;

import org.binaryminds.registroEstudiante.dominio.Service.ICursoService;
import org.binaryminds.registroEstudiante.dominio.Service.IEstudianteService;
import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.binaryminds.registroEstudiante.persistence.entity.Estudiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;
//@SpringBootApplication
public class RegistroEstudianteApplication  implements CommandLineRunner {

@Autowired
private ICursoService cursoService;

@Autowired
private IEstudianteService estudianteService;

private static final Logger logger = LoggerFactory.getLogger(RegistroEstudianteApplication.class);

String sl = System.lineSeparator();

    public static void main(String[] args) {
        logger.info("aqui inicia la aplicacion");
        SpringApplication.run(RegistroEstudianteApplication.class, args);
        logger.info("AQUI TERMINO LA APLICACION");
    }

    @Override
    public void run(String... args) throws Exception {
        RegistroEstudianteApp();
    }

    private void RegistroEstudianteApp() {
        logger.info("+++++++++APLICACIÓN DE REGISTRO DE CLIENTES+++++++++");
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir) {
            var opcion = mostrarMenu(consola);
            salir = ejecutarOpciones(consola, opcion);
            logger.info(sl);
        }
    }

    private int mostrarMenu(Scanner consola) {
        logger.info("""
             \n***Aplicación***
             1. Listar todos los curso.
             2. Buscar curso por código.
             3. Agregar nuevo curso.
             4. Modificar curso.
             5. Eliminar curso.
             6. Listar todos los estudiantes.
             7. Buscar curso por estudiante.
             8. Agregar nuevo estudiante.
             9. Modificar estudiante.
             10. Eliminar estudiante.
             11. Salir.
             Elije una opción: \s""");
        var opcion = Integer.parseInt(consola.nextLine());
        return opcion;
    }

    private boolean ejecutarOpciones(Scanner consola, int opcion) {
        var salir = false;
        switch (opcion) {
            case 1 -> {
                logger.info("***Listado de todos los curso***"+sl);
                List<Curso> cursos = cursoService.listarCurso();
                cursos.forEach(curso -> logger.info(curso.toString()+sl));
            }
            case 2 -> {
                logger.info(sl+"***Buscar Curso por su código***"+sl);
                logger.info("Ingrese el id: ");
                var codigo = Integer.parseInt(consola.nextLine());
                Curso curso = cursoService.buscarCursoPorId(codigo);
                if (curso != null){
                    logger.info("Curso encontrado: "+sl +curso +sl);
                }else {
                    logger.info("Curso NO encontrado: "+sl +curso +sl);
                }
            }
            case 3 -> {
                logger.info(sl+"***Agregar nuevo Curso***"+sl);
                logger.info("Ingrese el nombre: ");
                var nombre = consola.nextLine();
                logger.info("Ingrese el descripcion: ");
                var descripcion = consola.nextLine();

                var curso = new Curso();
                curso.setNombre_curso(nombre);
                curso.setDescripcion(descripcion);
                cursoService.guardarCurso(curso);
                logger.info("curso agregado: "+sl +curso +sl);
            }
            case 4 -> {
                logger.info("***Modificar curso***"+sl);
                logger.info("Ingrese el codigo del curso a editar: ");
                var codigo = Integer.parseInt(consola.nextLine());
                var curso = cursoService.buscarCursoPorId(codigo);
                logger.info("curso encontrado: "+sl +curso +sl);
                if (curso != null){
                    logger.info("Ingrese el nombre: ");
                    var nombre = consola.nextLine();
                    logger.info("Ingrese el descripcion: ");
                    var descripcion = consola.nextLine();
                    curso.setNombre_curso(nombre);
                    curso.setDescripcion(descripcion);
                    cursoService.guardarCurso(curso);
                    logger.info("curso modificado: "+sl +curso +sl);
                }else {
                    logger.info("curso NO encontrado "+sl +curso +sl);
                }
            }
            case 5 -> {
                logger.info(sl+"***Eliminar curso***"+sl);
                logger.info("Ingrese el codigo del curso a eliminar: ");
                var codigo = Integer.parseInt(consola.nextLine());
                var curso = cursoService.buscarCursoPorId(codigo);
                if (curso != null) {
                    cursoService.eliminarCurso(curso);
                    logger.info("curso eliminado: "+sl +curso +sl);
                }else {
                    logger.info("curso NO encontrado "+sl +curso +sl);
                }
            }
            case 6 -> {
                logger.info("***Listado de todos los estudiantes***"+sl);
                List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
                estudiantes.forEach(estudiante -> logger.info(estudiante.toString()+sl));
            }
            case 7 -> {
                logger.info(sl+"***Buscar Curso por su estudiantes***"+sl);
                logger.info("Ingrese el id: ");
                var codigo = Integer.parseInt(consola.nextLine());
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null){
                    logger.info("estudiantes encontrado: "+sl +estudiante +sl);
                }else {
                    logger.info("estudiantes NO encontrado: "+sl +estudiante +sl);
                }
            }
            case 8 -> {
                logger.info(sl+"***Agregar nuevo estudiantes***"+sl);
                logger.info("Ingrese el nombre del estuidante: ");
                var nombre = consola.nextLine();
                logger.info("Ingrese el apellido: ");
                var apellido = consola.nextLine();
                logger.info("Ingrese el correo: ");
                var correo = consola.nextLine();
                logger.info("Ingrese el Curso: ");
                var codigo_curso = consola.nextLine();
                var estudiante = new Estudiante();
                estudiante.setCodigo_curso(Integer.valueOf(codigo_curso));
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiante.setCorreo(correo);
                estudianteService.guardarEstudiante(estudiante);
                logger.info("estudiantes agregado: "+sl +estudiante +sl);
            }
            case 9 -> {
                logger.info("***Modificar estudiantes***"+sl);
                logger.info("Ingrese el codigo del estudiantes a editar: ");
                var codigo = Integer.parseInt(consola.nextLine());
                var estudiante = estudianteService.buscarEstudiantePorId(codigo);
                logger.info("estudiantes encontrado: "+sl +estudiante +sl);
                if (estudiante != null){
                    logger.info("Ingrese el nombre: ");
                    var nombre = consola.nextLine();
                    logger.info("Ingrese el apellido: ");
                    var apellido = consola.nextLine();
                    logger.info("Ingrese el correo: ");
                    var correo = consola.nextLine();
                    logger.info("Ingrese el Curso: ");
                    var codigo_curso = consola.nextLine();
                    estudiante.setCodigo_curso(Integer.valueOf(codigo_curso));
                    estudiante.setNombre(nombre);
                    estudiante.setApellido(apellido);
                    estudiante.setCorreo(correo);
                    estudianteService.guardarEstudiante(estudiante);
                    logger.info("curso modificado: "+sl +estudiante +sl);
                }else {
                    logger.info("curso NO encontrado "+sl +estudiante +sl);
                }
            }
            case 10 -> {
                logger.info(sl+"***Eliminar estudiantes***"+sl);
                logger.info("Ingrese el codigo del estudiantes a eliminar: ");
                var codigo = Integer.parseInt(consola.nextLine());
                var estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null) {
                    estudianteService.eliminarEstudiante(estudiante);
                    logger.info("estudiantes eliminado: "+sl +estudiante +sl);
                }else {
                    logger.info("estudiantes NO encontrado "+sl +estudiante +sl);
                }
            }


            case 11 -> {
                logger.info("Hasta pronto. vaquero!"+sl+sl);
                salir = true;
            }
            default -> logger.info("Opción no valida!");
        }
        return false;
    }
}
