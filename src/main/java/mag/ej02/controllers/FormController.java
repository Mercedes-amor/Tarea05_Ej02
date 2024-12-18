package mag.ej02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import mag.ej02.FormInfo;
import mag.ej02.services.CalculosOperacion;

@Controller
public class FormController {
    @Autowired
    CalculosOperacion calculosOperacion;

    @GetMapping({ "/", "/myForm" })
    public String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "indexView";
    }

    @PostMapping("/myForm/submit")
    public String showFormSubmit(@Valid @ModelAttribute FormInfo formInfo,
            BindingResult bindingResult,
            Model model) {

        // BindingResult debe ir después del objeto a comprobar, forInfo en este caso
        // @ModelAttribute--> Nos garantiza que pasa automaticamente el forInfo a
        // la vista sin necesidad del model

        if (bindingResult.hasErrors()) {
            // Los errores de validación se procesarán automáticamente con `th:errors` en la vista
            return "indexView";
        }

        // Si el usuario seleccionó la opción "Calcular días"
        if (formInfo.getOperacion().equals("dias")) {

            // llamaremos a la función del servicio calcularDias()
            // y almacenamos el resultado en una varible que se mostrará en submitView
            long resultadoDias = calculosOperacion.calcularDias(formInfo.getFecha1(), formInfo.getFecha2());
            model.addAttribute("resultadoDias", resultadoDias);
            return "submitView";
        }

        // Si el usuario seleccionó la opción "Calcular años bisiestos"
        if (formInfo.getOperacion().equals("bisiestos")) {
            int resultadoBisiestos = calculosOperacion.calcularBisiestos(formInfo.getFecha1(), formInfo.getFecha2());
            model.addAttribute("resultadoBisiestos", resultadoBisiestos);
            return "submitView";
        }

        // Si el usuario seleccionó la opción "Calcular años con 1 Enero en Domingo"
        if (formInfo.getOperacion().equals("domingos")) {
            int resultadoDomingos = calculosOperacion.contarDomingos(formInfo.getFecha1(), formInfo.getFecha2());
            model.addAttribute("resultadoDomingos", resultadoDomingos);
            return "submitView";
        }

        return "submitView";
    }
}
