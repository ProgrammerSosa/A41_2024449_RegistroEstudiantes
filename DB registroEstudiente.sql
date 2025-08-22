drop database if exists estudiantes_db;
create database estudiantes_db;
use estudiantes_db;

 
 create table Cursos(
 codigo_curso integer auto_increment,
 nombreCurso varchar (32),
 descripcion varchar (64),
 constraint codigo_curso primary key (codigo_curso)
 );
 
 create table estudiantes(
codigo_estudiante integer auto_increment,
    nombre varchar (64),
    apellido varchar (64),
	correo varchar (64),
    codigo_curso integer,
    constraint pk_estudiante primary key (codigo_estudiante),
    constraint fk_estudiantes_Cursos foreign key (codigo_curso)
		references Cursos(codigo_curso) on delete cascade
);