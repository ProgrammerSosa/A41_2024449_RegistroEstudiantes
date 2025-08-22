package org.binaryminds.registroEstudiante.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Cursos")
//lombok    genera los setter y getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode  // codigo de autenticacion de la enteidad
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer codigoCurso;
    private String nombreCurso;
    private String descripcion;

}