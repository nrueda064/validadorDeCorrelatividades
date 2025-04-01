package domain.campus;

import java.util.List;
import java.util.ArrayList;

public class Alumno {
    private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriaAprobada(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public boolean verificarCorrelativas(Materia materia){
        List<String> nombresCorrelativas = materia.getNombresCorrelativas();

        return nombresCorrelativas.isEmpty() || nombresCorrelativas.stream()
                .allMatch(nombre -> materiasAprobadas.stream()
                        .anyMatch(m -> m.getNombre().equals(nombre)));
    }
}
