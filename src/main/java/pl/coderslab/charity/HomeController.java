package pl.coderslab.charity;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {


    private final InstitutionRepository irepo;

    public HomeController(InstitutionRepository irepo) {

        this.irepo = irepo;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("listOfInstitutions", irepo.findAll(Pageable.ofSize(4)).getContent());
        return "index";}

       // return "institutionForm";}
    }
