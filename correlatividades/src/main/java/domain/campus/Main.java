package domain.campus;

import java.util.Arrays;

//Pruebas rápidas que hice antes de hacer los tests:
public class Main {
    public static void main(String[] args) {
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);

        Materia basesDeDatos = new Materia("Bases de Datos");
        basesDeDatos.agregarCorrelativa(algoritmos);

        Materia arquitectura = new Materia("Arquitectura");

        Alumno alumno = new Alumno();
        alumno.agregarMateriaAprobada(algoritmos);

        Inscripcion inscripcion = new Inscripcion(Arrays.asList(paradigmas));
        inscripcion.inscribirseAMateria(basesDeDatos);
        inscripcion.inscribirseAMateria(arquitectura);

        System.out.println("Inscripción aprobada? " + inscripcion.aprobada(alumno));
    }
}