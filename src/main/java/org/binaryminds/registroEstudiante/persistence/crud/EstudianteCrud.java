package org.binaryminds.registroEstudiante.persistence.crud;

import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.binaryminds.registroEstudiante.persistence.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteCrud extends JpaRepository<Estudiante , Integer> {

}
