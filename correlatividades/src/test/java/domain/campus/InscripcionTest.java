package domain.campus;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class InscripcionTest {

    @Test
    void testInscripcionAprobada() {
        Materia algoritmos = new Materia("Algoritmos");
        Materia sistemasYOrganizaciones = new Materia("Sistemas y Organizaciones");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);

        Materia analisisDeSistemas = new Materia("Analisis de Sistemas");
        paradigmas.agregarCorrelativa(sistemasYOrganizaciones);

        Materia basesDeDatos = new Materia("Bases de Datos");
        basesDeDatos.agregarCorrelativa(algoritmos);

        Materia disenoDeSistemas = new Materia("Diseño de Sistemas");
        disenoDeSistemas.agregarCorrelativa(analisisDeSistemas);

        Materia arquitectura = new Materia("Arquitectura");

        // Alumno con Algoritmos aprobada:
        Alumno alumno = new Alumno();
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(sistemasYOrganizaciones);
        alumno.agregarMateriaAprobada(analisisDeSistemas);

        // Inscripciones:
        Inscripcion inscripcion = new Inscripcion(Arrays.asList(paradigmas));
        inscripcion.inscribirseAMateria(basesDeDatos);
        inscripcion.inscribirseAMateria(arquitectura);
        inscripcion.inscribirseAMateria(disenoDeSistemas);

        // Verificamos:
        assertTrue(inscripcion.aprobada(alumno), "Inscripcion aprobada");
    }

    @Test
    void testInscripcionRechazada() {
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);

        Materia basesDeDatos = new Materia("Bases de Datos");
        basesDeDatos.agregarCorrelativa(algoritmos);

        // Alumno vacío:
        Alumno alumno = new Alumno();

        // Inscripciones:
        Inscripcion inscripcion = new Inscripcion(Arrays.asList(paradigmas));
        inscripcion.inscribirseAMateria(basesDeDatos);

        // Verificamos:
        assertFalse(inscripcion.aprobada(alumno), "Inscripcion rechazada");
    }
}