package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {
    private final DonationRepository drepo;
    private final InstitutionRepository irepo;
    private final CategoryRepository crepo;

    public DonationController(DonationRepository drepo, InstitutionRepository irepo, CategoryRepository crepo) {
        this.drepo = drepo;
        this.irepo = irepo;
        this.crepo = crepo;
    }

    @ModelAttribute
    void donationAtributes(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("institution", new Institution());
        model.addAttribute("institutions", irepo.findAll());
        model.addAttribute("categories", crepo.findAll());
    }


    @RequestMapping("/form")
    public String donate(){ //Model model nie potrzebny bo przekazane przez ModelAtribute?
        return "form";
    }


}
