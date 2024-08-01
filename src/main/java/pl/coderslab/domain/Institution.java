package pl.coderslab.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="institutions")
public class Institution {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String name;
        private String description;

        public long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}

