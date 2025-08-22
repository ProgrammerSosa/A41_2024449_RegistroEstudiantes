package org.binaryminds.registroEstudiante.dominio.Service;

import org.binaryminds.registroEstudiante.persistence.crud.CursoCrud;
import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CursoService implements ICursoService{
    @Autowired
    private CursoCrud crud;

    @Override
    public List<Curso> listarCurso() {
        List <Curso> cursos = crud.findAll();
        return cursos;
    }

    @Override
    public Curso buscarCursoPorId(Integer codigoCurso) {
        Curso cursos = crud.findById(codigoCurso).orElse(null);
        return cursos;
    }

    @Override
    public void guardarCurso(Curso curso) {
        crud.save(curso);
    }

    @Override
    public void eliminarCurso(Curso curso) {
        crud.delete(curso);
    }
}
