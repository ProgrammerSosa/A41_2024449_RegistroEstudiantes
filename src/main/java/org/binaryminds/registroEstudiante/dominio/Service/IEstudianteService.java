package org.binaryminds.registroEstudiante.dominio.Service;

import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.binaryminds.registroEstudiante.persistence.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {

    //firmas de metodo
    List<Estudiante> listarEstudiantes();
    Estudiante buscarEstudiantePorId(Integer codigo);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Estudiante estudiante);
}
