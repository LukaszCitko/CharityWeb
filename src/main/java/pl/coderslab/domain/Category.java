package pl.coderslab.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }



}
