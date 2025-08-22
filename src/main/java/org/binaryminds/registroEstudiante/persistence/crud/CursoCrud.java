package org.binaryminds.registroEstudiante.persistence.crud;

import org.binaryminds.registroEstudiante.persistence.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoCrud extends JpaRepository <Curso, Integer> {
    
}
