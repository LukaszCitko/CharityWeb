package pl.coderslab.charity.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name="donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Min(1)
    private int quantity = 1 ;

    @NotEmpty
    @ManyToMany
    @JoinColumn(name = "category_id")
    private List<Category> categories = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String phone;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;

    @Size(max = 100)
    private String pickUpComment;
}