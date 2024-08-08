package pl.coderslab.charity;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {


    private final InstitutionRepository irepo;
    private final DonationRepository drepo;

    public HomeController(InstitutionRepository irepo, DonationRepository drepo) {

        this.irepo = irepo;
        this.drepo = drepo;
    }
    public int DonationQuantityBag(){

        List<Donation> donations = drepo.findAll();

        int quantityBag = 0;
        for (Donation donation : donations) {
                 quantityBag+=donation.getQuantity();
        }

    return quantityBag;}
    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("listOfInstitutions", irepo.findAll(Pageable.ofSize(4)).getContent());
        model.addAttribute("numberOfDonatedBags", DonationQuantityBag());
        return "index";}

       // return "institutionForm";}
    }
