package org.binaryminds.registroEstudiante.dominio.Service;

import org.binaryminds.registroEstudiante.persistence.entity.Curso;

import java.util.List;

public interface ICursoService {
    //firmas de metodo
    List<Curso> listarCurso();
    Curso buscarCursoPorId(Integer codigo);
    void guardarCurso(Curso cuso);
    void eliminarCurso(Curso curso);
}
