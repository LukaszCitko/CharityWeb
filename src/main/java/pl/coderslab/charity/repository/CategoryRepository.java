package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
