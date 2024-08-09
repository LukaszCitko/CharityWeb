package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import javax.validation.Valid;

@Controller
public class DonationController {
    private final DonationRepository drepo;

    public DonationController(DonationRepository drepo) {
        this.drepo = drepo;
    }

    @PostMapping("/addDonation")
    @ResponseBody
    public String addDonation(@Valid Donation donation){
        drepo.save(donation);
        return "form-confirmation";
    }
}
