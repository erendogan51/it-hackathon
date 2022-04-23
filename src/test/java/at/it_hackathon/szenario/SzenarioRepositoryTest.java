package at.it_hackathon.szenario;

import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.frage.FrageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class SzenarioRepositoryTest {

    @Autowired
    SzenarioRepository szenarioRepository;

    @Autowired
    FrageRepository frageRepository;

    @BeforeEach
    void setUp() {
    }

    @Disabled
    @Test
    public void saveSzenarioTest(){
        Szenario szenario = new Szenario("Test",new HashSet<>(), Schwierigkeit.LEICHT);
        szenarioRepository.save(szenario);
        assertTrue(szenario.getId() > 0);
    }

    @Disabled
    @Test
    public void canGetSzenarioByID(){
        Szenario szenario = new Szenario("Test2",new HashSet<>(), Schwierigkeit.LEICHT);
        szenarioRepository.save(szenario);

        assertEquals(szenario.getId(), szenarioRepository.findById(szenario.getId()).get().getId());

    }

}