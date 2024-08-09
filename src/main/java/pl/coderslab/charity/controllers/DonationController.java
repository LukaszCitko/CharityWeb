package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;

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
        model.addAttribute("listOfAllInstitutions", irepo.findAll());
        model.addAttribute("listOfAllCategories", crepo.findAll());
        model.addAttribute("donation", new Donation());
    }

    @RequestMapping("/form")
    public String donate(){ //Model model nie potrzebny bo przekazane przez ModelAtribute?
        return "form";
    }

    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
            drepo.save(donation);
        }

        // przekazac z powrotem instytucje i kategorie  (redirect:)

        return "form-confirmation";
    }
}
