package at.it_hackathon.gesetz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GesetzRepository extends JpaRepository<Gesetz, Long> {
}