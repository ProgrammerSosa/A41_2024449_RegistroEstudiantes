package org.binaryminds.registroEstudiante;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.binaryminds.registroEstudiante.dominio.Service.ICursoService;
import org.binaryminds.registroEstudiante.dominio.Service.IEstudianteService;
import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.binaryminds.registroEstudiante.persistence.entity.Estudiante;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@ViewScoped
public class IndexController {
  @Autowired
   ICursoService CursoService;
  private List<Curso> cursos;
   private Curso cursoSeleccionado;

    @Autowired
    IEstudianteService estudianteService;
    private List<Estudiante> estudiantes;
    private Estudiante estudianteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.estudiantes = this.estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.toString()));

        this.cursos = this.CursoService.listarCurso();
        this.cursos.forEach(curso -> logger.info(curso.toString()));
    }

    public void agregarEstudiante(){

        this.estudianteSeleccionado = new Estudiante();
    }

    public void guardarEstudiante(){
        logger.info("Estudiante a guardar: "+this.estudianteSeleccionado);
        //Agregar (insert)
        if (this.estudianteSeleccionado.getCodigo_estudiante() == null){
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            this.estudiantes.add(estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Estudiante agregado"));
        }

        //Modificar (update)
        else {
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Estudiante actualizado"));
        }

        //Ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalEstudiante').hide()");

        //Actualizar la tabla con un método AJAX
        PrimeFaces.current().ajax().update("formulario-estudiantes:mensaje_emergente",
                "formulario-estudiantes:tabla-estudiantes");

        //Reset del  seleccionado
        this.estudianteSeleccionado = null;
    }

    public void eliminarEstudiante(){
        //Mostrar en consola
        logger.info("estudiantes a eliminar: "+this.estudianteSeleccionado);

        //Llamar a nuestro servicio de eliminación de
        this.estudianteService.eliminarEstudiante(estudianteSeleccionado);

        //Eliminarlo de la lista
        this.estudiantes.remove(estudianteSeleccionado);

        //Limpiar nuestro  seleccionado
        this.estudianteSeleccionado = null;

        //Enviar un mensaje emergente de confirmación
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("estudiantes eliminado"));

        //Actualizar la tabla con AJAX
        PrimeFaces.current().ajax().update("formulario-estudiantes:mensaje_emergente",
                "formulario-estudiantes:tabla-estudiantes");
    }



    // CURSOS

    public void agregarCurso(){

        this.cursoSeleccionado = new Curso();
    }

    public void guardarCurso(){
        logger.info("Curso a guardar: "+this.cursoSeleccionado);
        //Agregar (insert)
        if (this.cursoSeleccionado.getCodigo_curso() == null){
            this.CursoService.guardarCurso(this.cursoSeleccionado);
            this.cursos.add(cursoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso agregado"));
        }

        //Modificar (update)
        else {
            this.CursoService.guardarCurso(this.cursoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso actualizado"));
        }

        //Ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalCurso').hide()");

        //Actualizar la tabla con un método AJAX
        PrimeFaces.current().ajax().update("formulario-cursos:mensaje_emergente",
                "formulario-cursos:tabla-cursos");

        //Reset del  seleccionado
        this.cursoSeleccionado = null;
    }

    public void eliminarCurso(){
        //Mostrar en consola
        logger.info("cursos a eliminar: "+this.cursoSeleccionado);

        //Llamar a nuestro servicio de eliminación de
        this.CursoService.eliminarCurso(cursoSeleccionado);

        //Eliminarlo de la lista
        this.cursos.remove(cursoSeleccionado);

        //Limpiar nuestro  seleccionado
        this.cursoSeleccionado = null;

        //Enviar un mensaje emergente de confirmación
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("cursos eliminado"));

        //Actualizar la tabla con AJAX
        PrimeFaces.current().ajax().update("formulario-                \"formulario-cursos:tabla-cursos\");\n:mensaje_emergente",
                "formulario-cursos:tabla-cursos");
    }

}
