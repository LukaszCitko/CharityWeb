package pl.coderslab.charity;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {
    private final InstitutionRepository irepo;
    private final DonationRepository drepo;
    private final CategoryRepository crepo;

    public HomeController(InstitutionRepository irepo, DonationRepository drepo, CategoryRepository crepo) {
        this.irepo = irepo;
        this.drepo = drepo;
        this.crepo = crepo;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("listOfInstitutionsLimited", irepo.findAll(Pageable.ofSize(4)).getContent());
        model.addAttribute("numberOfDonatedBags", drepo.findQuantityBag().orElse(0));
        model.addAttribute("numberOfDonations", drepo.count());

        return "index";}

       //return "institutionForm";} // przygotowany layoutForm do dodawania instytucji
       //return "CategoryForm";} // przygotowany layoutForm do dodawania Kategorii
    }
