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


    @ModelAttribute(name = "institutions")
    List<Institution> allInstitutions(){
        List<Institution> institutions = irepo.findAll();
        return institutions; }
    @ModelAttribute(name = "categories")
    List<Category>  allCategories() {
        List<Category> categories = crepo.findAll();
        return categories;}


    @RequestMapping("/form")
    public String donate(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/addDonation")
    public String addDonation(@Valid Donation donation, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            System.out.println("**************************************************************");
            System.out.println("******************************************************************");
            System.out.println(donation);
            System.out.println("****************************************************************");
            System.out.println("*********************************************************************");
            return "form";
        }

        System.out.println("***ok*****ok********ok******ok*********ok*******ok******");
        System.out.println("***ok*****ok********ok******ok*********ok*******ok******");
        System.out.println(donation);
        System.out.println("****ok****ok*******ok******ok*****ok********ok*****ok*****");
        System.out.println("****ok****ok*******ok******ok*****ok********ok*****ok*****");
        //drepo.save(donation);

        return "form-confirmation";
    }

}
