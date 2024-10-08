package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.Donation;

import java.util.Optional;


public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM (quantity) FROM Donation")
    Optional<Integer> findQuantityBag();
}
