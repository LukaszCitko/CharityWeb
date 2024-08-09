package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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



    public String Donate(Model model){
        model.addAttribute("listOfAllInstitutions", irepo.findAll());
        model.addAttribute("listOfAllCategories", crepo.findAll());

        return "form";
    }

    @PostMapping("/addDonation")
    @ResponseBody
    public String addDonation(@Valid Donation donation){
        drepo.save(donation);
        return "form-confirmation";
    }
}
