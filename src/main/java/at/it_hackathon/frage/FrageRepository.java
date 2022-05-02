package at.it_hackathon.frage;

import at.it_hackathon.szenario.Szenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrageRepository extends JpaRepository<Frage, Long> {

    /*
    @Query( "select f from Frage f where f.szenario.id = :id")
    List<Frage> fragenZuEinemSzenario(@Param("id") long id);

     */
}
