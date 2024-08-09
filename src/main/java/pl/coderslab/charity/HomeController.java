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


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("listOfInstitutionsLimited", irepo.findAll(Pageable.ofSize(4)).getContent());
        model.addAttribute("numberOfDonatedBags", drepo.findQuantityBag());
        model.addAttribute("numberOfDonations", drepo.count());

        return "index";}

       // return "institutionForm";} // przygotowany layoutForm do dodawania instytucji
    }
