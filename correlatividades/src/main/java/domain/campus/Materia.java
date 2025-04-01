package domain.campus;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Getter
public class Materia {
    private List<Materia> correlativas;
    private String nombre;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public List<String> getNombresCorrelativas() {
        return correlativas.stream()
                .map(Materia::getNombre)
                .collect(Collectors.toList());
    }
}
