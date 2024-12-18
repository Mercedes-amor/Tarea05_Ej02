package mag.ej02;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotNull;

public class FormInfo {
  
@DateTimeFormat(pattern = "yyyy-MM-dd")
@NotNull(message = "La fecha 1 no puede estar vacía")   
private LocalDate fecha1;

@DateTimeFormat(pattern = "yyyy-MM-dd")
@NotNull(message = "La fecha 2 no puede estar vacía")   
private LocalDate fecha2;

//Añadimos el parámetro para saber qué operación realizar y no puede ser nulo
@NotNull(message = "Debe seleccionar una operación")
private String operacion;


//Getters y Setters
public LocalDate getFecha1() {
    return fecha1;
}
public void setFecha1(LocalDate fecha1) {
    this.fecha1 = fecha1;
}
public LocalDate getFecha2() {
    return fecha2;
}
public void setFecha2(LocalDate fecha2) {
    this.fecha2 = fecha2;
}

public String getOperacion() {
    return operacion;
}

public void setOperacion(String operacion) {
    this.operacion = operacion;
}

}
