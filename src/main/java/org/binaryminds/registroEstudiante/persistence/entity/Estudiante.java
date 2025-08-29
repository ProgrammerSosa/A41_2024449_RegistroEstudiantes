package org.binaryminds.registroEstudiante.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

    @Entity(name = "Estudiantes")
//lombok    genera los setter y getter
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode  // codigo de autenticacion de la enteidad
    public class Estudiante {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
       private Integer codigo_estudiante ;
        private  String nombre;
        private String apellido;
        private String correo;
        private Integer codigo_curso;

}
