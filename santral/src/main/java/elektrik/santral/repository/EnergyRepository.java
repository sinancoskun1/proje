package elektrik.santral.repository;

import elektrik.santral.entity.Titles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnergyRepository extends JpaRepository<Titles, Long> {
    Optional<Titles> findBySantralIdAndSaatAdi(Long santralId, String saatAdi);


}

