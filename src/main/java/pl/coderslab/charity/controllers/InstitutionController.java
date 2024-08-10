package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;


@Controller
public class InstitutionController {


    private final InstitutionRepository irepo;

    public InstitutionController(InstitutionRepository irepo) {
        this.irepo = irepo;
    }

    @PostMapping(value = "/institution/add")
    @ResponseBody
    public String addInstitution(@Valid Institution institution) {

        irepo.save(institution);
        return "Id dodanej instytucji to:" + institution.getId();
    }
}
