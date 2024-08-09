package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.Donation;



public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT COUNT(quantity) FROM Donation")
    int findQuantityBag();
}
