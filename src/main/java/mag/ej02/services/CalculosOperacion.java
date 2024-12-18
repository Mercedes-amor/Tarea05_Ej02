package mag.ej02.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class CalculosOperacion {

    public long calcularDias(LocalDate fecha1, LocalDate fecha2) {

        // Usamos Math.abs para garantizar el resultado positivo, así no interfiere
        // si la fecha1 es posterior a la fecha2

        return Math.abs(ChronoUnit.DAYS.between(fecha1, fecha2));
    }

    public int calcularBisiestos(LocalDate fecha1, LocalDate fecha2) {

        int contadorBisiestos = 0;
        int inicio = 0;
        int fin = 0;

        // Aquí hacemos una comprobación para saber que fecha es anterior para iniciar el bucle
        if (fecha1.isBefore(fecha2)) { // fecha1 es anterior
            inicio = fecha1.getYear();
            fin = fecha2.getYear();
        } else { // fecha2 es anterior
            inicio = fecha2.getYear();
            fin = fecha1.getYear();
        }

        // Calculo de los bisiestos y vamos sumando al contador
        for (int i = inicio; i <= fin; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                contadorBisiestos++;
            }
        }

        return contadorBisiestos;
    }

    public int contarDomingos(LocalDate fecha1, LocalDate fecha2) {
        int contadorDomingos = 0;
        int inicio = 0;
        int fin = 0;

        // Aquí hacemos una comprobación para saber que fecha es anterior para iniciar el bucle
        if (fecha1.isBefore(fecha2)) { // fecha1 es anterior
            inicio = fecha1.getYear();
            fin = fecha2.getYear();
        } else { // fecha2 es anterior
            inicio = fecha2.getYear();
            fin = fecha1.getYear();
        }

        for (int i = inicio; i <= fin; i++) {

            //Creamos la fecha a comprobar a 1 Enero para cada año del bucle
            LocalDate fechaAComprobar = LocalDate.of(i, 1, 1);

            //Comprobamos con .getDayOfWeek().getValue() si el valor es 7, que equivale al Domingo
            //Si es así incrementamos el contador.
            if (fechaAComprobar.getDayOfWeek().getValue() == 7) {
                contadorDomingos++;
            }
        }

        return contadorDomingos;
    }

}
