package domain.campus;

import java.util.List;
import java.util.ArrayList;

public class Inscripcion {
    private List<Materia> listaDeMaterias;

    public Inscripcion(List<Materia> listaDeMaterias) {
        this.listaDeMaterias = new ArrayList<>(listaDeMaterias);
    }

    public void inscribirseAMateria(Materia materia) {
        listaDeMaterias.add(materia);
    }

    public boolean aprobada(Alumno alumno){
        return listaDeMaterias.stream().allMatch(alumno::verificarCorrelativas);
    }
}
