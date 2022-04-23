package at.it_hackathon.szenario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzenarioRepository extends JpaRepository<Szenario, Long> {


}
