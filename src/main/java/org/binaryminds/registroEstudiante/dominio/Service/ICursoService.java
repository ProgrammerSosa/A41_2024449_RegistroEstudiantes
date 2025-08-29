package org.binaryminds.registroEstudiante.dominio.Service;

import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.binaryminds.registroEstudiante.persistence.entity.Estudiante;

import java.util.List;

public interface ICursoService {
    //firmas de metodo
    List<Curso> listarCurso();
    Curso buscarCursoPorId(Integer codigo);
    void guardarCurso(Curso curso);
    void eliminarCurso(Curso curso);

}

