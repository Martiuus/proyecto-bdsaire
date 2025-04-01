package pe.edu.idat.proyecto_bdsaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.proyecto_bdsaire.model.ClienteModel;

@Controller
public class CalcController {
        @GetMapping("/calcnota")
        public String formularioNota(Model model){
            model.addAttribute("calcmodel", new ClienteModel());
            model.addAttribute("visualizarprom", false);
            return "calcnota";
        }
        @PostMapping("/calcularnota")
        public String calcuarNota(@ModelAttribute("calcmodel") ClienteModel calcnota, Model model){
//            Double nota2 = calcnota.getNota2()*0.12;
//            Double nota3 = calcnota.getNota3()*0.24;
//            Double notaFin = calcnota.getNotaFin()*0.60;
//            Double nota1 = calcnota.getNota1()*0.04;
//            Double promedio = (nota1 + nota2 + nota3 + notaFin);
//
//            String diagnostico = "", estiloDiagnostico= "alert-danger";
//
//            if (promedio < 13){
//                diagnostico = "Desaprobado";
//            } else {
//                diagnostico = "Aprobado";
//                estiloDiagnostico = "alert-primary";
//            }
//            model.addAttribute("Resultado","Su promedio= " + String.format("%.2f",promedio) +
//                    ", usted se encuentra: "+ diagnostico);
//            model.addAttribute("visualizarprom", true);
//            model.addAttribute("estilodiagnostico", estiloDiagnostico);
//            return "calcnota";
//        }
        return "calcmodel";
        }
}

