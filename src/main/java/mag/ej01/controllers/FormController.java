package mag.ej01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import mag.ej01.FormInfo;

@Controller
public class FormController {

    // @Autowired(required = true)
    // private CalculosService calculosService;

    @GetMapping("/myForm")
    public String showForm(Model model) {
        model.addAttribute("FormInfo", new FormInfo());
        return "formView";

    }

    @PostMapping("/myForm/submit")
    public String showFormSubmit(@ModelAttribute FormInfo formInfo, Model model) {

        // @ModelAttribute--> Nos garantiza que pasa automaticamente el forInfo a
        // la vista sin necesidad del model

        formInfo.setNombre(formInfo.getNombre().toUpperCase());
        model.addAttribute("FormInfo", formInfo);

        return "formSubmitView";

    }

}
