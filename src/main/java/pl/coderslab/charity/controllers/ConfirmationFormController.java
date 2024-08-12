package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.domain.Donation;

import javax.validation.Valid;

@Controller
public class ConfirmationFormController {
    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
        System.out.println(donation);
        //drepo.save(donation);
        }

        return "form-confirmation";
    }
}
