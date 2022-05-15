package at.it_hackathon.frage;

import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.szenario.Szenario;
import at.it_hackathon.szenario.SzenarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FrageRepositoryTest {

    @Autowired
    SzenarioRepository szenarioRepository;

    @Autowired
    FrageRepository frageRepository;

    @BeforeEach
    void setUp() {
    }


//    @Disabled
//    @Test
//    void canFindFragenZuEinemSzenario() {
//        Szenario szenario = new Szenario("Test", new HashSet<>());
//        Frage frage1 = new Frage("Was würdest du tun?", "A", "B", "C",szenario);
//        Frage frage2 = new Frage("Was würdest du tun?", "A", "B", "C",szenario);
//        List<Frage> fragen = new ArrayList<>(List.of(frage1, frage2));
//        szenarioRepository.save(szenario);
//        frageRepository.saveAll(List.of(frage1,frage2));
//        szenario.addFrageToSzenario(frage1);
//        szenarioRepository.save(szenario);
//
//        List<Frage> actual = frageRepository.fragenZuEinemSzenario(szenario.getId());
//        assertEquals(fragen, actual);
//    }
//
//    @Disabled
//    @Test
//    void throwsIfFragenZuEinemSzenarioNotFound() {
//        Szenario szenario = new Szenario("Test",new HashSet<>(), Schwierigkeit.LEICHT);
//        Frage frage1 = new Frage("Was würdest du tun?", "A", "B", "C",szenario);
//        Frage frage2 = new Frage("Was würdest du tun?", "A", "B", "C",szenario);
//        List<Frage> fragen = new ArrayList<>(List.of(frage1, frage2));
//        szenarioRepository.save(szenario);
//        frageRepository.saveAll(List.of(frage1,frage2));
//        szenario.addFrageToSzenario(frage1);
//        szenarioRepository.save(szenario);
//
//        List<Frage> actual = frageRepository.fragenZuEinemSzenario(3131);
//        assertThat(actual).isNotEqualTo(fragen);
//    }
}