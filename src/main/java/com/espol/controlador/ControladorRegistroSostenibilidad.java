package com.espol.controlador;

import com.espol.modelo.RegistroSostenibilidad;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ControladorRegistroSostenibilidad {

    private RegistroSostenibilidad registroDiario;
    public static final Map<String, Integer> ACCIONES_DISPONIBLES = new LinkedHashMap<>();

    static {
        ACCIONES_DISPONIBLES.put("Reciclar papel y cartón", 10);
        ACCIONES_DISPONIBLES.put("Usar transporte público o bicicleta", 15);
        ACCIONES_DISPONIBLES.put("Reducir el consumo de carne", 10);
        ACCIONES_DISPONIBLES.put("Apagar luces y aparatos innecesarios", 5);
        ACCIONES_DISPONIBLES.put("Comprar productos locales y de temporada", 12);
        ACCIONES_DISPONIBLES.put("Evitar plásticos de un solo uso", 20);
    }

    public ControladorRegistroSostenibilidad() {
        this.registroDiario = new RegistroSostenibilidad(LocalDate.now());
    }

    /**
     * Registra una acción sostenible y suma los puntos.
     * @param indiceAccion El índice de la acción seleccionada por el usuario.
     */
    public void registrarAccion(int indiceAccion) {
        if (indiceAccion >= 0 && indiceAccion < ACCIONES_DISPONIBLES.size()) {
            String accion = (String) ACCIONES_DISPONIBLES.keySet().toArray()[indiceAccion];
            int puntos = ACCIONES_DISPONIBLES.get(accion);
            registroDiario.agregarAccion(accion, puntos);
        }
    }

    public Map<String, Integer> getAccionesDisponibles() {
        return ACCIONES_DISPONIBLES;
    }

    public int getPuntosObtenidos() {
        return registroDiario.getPuntosObtenidos();
    }

    public List<String> getAccionesRealizadasHoy() {
        return registroDiario.getAccionesRealizadas();
    }

    public String getMensajePuntuacion() {
        int puntos = getPuntosObtenidos();
        if (puntos >= 50) return "¡Excelente! Eres un campeón de la sostenibilidad.";
        if (puntos >= 25) return "¡Muy bien! Sigue así, cada acción cuenta.";
        if (puntos > 0) return "¡Buen comienzo! Sigue sumando acciones positivas.";
        return "Aún no has registrado acciones hoy. ¡Anímate a empezar!";
    }
}
