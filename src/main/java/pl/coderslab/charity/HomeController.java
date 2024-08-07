package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {

    @Autowired
    InstitutionRepository Irepo;
    @ModelAttribute
    void listOfInstitution (Model model){

        model.addAttribute("listOfInstitutions", Irepo.findAll());
    }

    @RequestMapping("/")
    public String homeAction(Model model){

        return "index";}
       // return "institutionForm";}
    }
