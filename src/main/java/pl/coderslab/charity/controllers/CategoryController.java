package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.repository.CategoryRepository;

@Controller

public class CategoryController {

    private final   CategoryRepository crepo;
    public CategoryController(CategoryRepository crepo) {
        this.crepo = crepo;
    }

    @ResponseBody
    @PostMapping("/category/add")
    public String addCategories(Category category){
        crepo.save(category);
        return "done, id: " + category.getId() ;
    }
}
