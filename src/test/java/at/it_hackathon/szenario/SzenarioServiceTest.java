package at.it_hackathon.szenario;

import at.it_hackathon.enums.Schwierigkeit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SzenarioServiceTest {

    @Mock
    SzenarioRepository szenarioRepository;
    SzenarioService szenarioService;
    Szenario szenario;

    @BeforeEach
    void setUp() {
        szenarioService = new SzenarioService(szenarioRepository);
        szenario = new Szenario();
    }

    @Test
    void getSzenarios() {
        szenarioRepository.findAll();
        verify(szenarioRepository).findAll();
    }

    @Test
    void getSzenarioByID() {
        szenarioRepository.findById(szenario.getId());
        verify(szenarioRepository).findById(szenario.getId());
    }

    @Test
    void canAddSzenario() {
        Szenario szenario = new Szenario("Test", new HashSet<>(), Schwierigkeit.LEICHT);

        szenarioService.addSzenario(szenario);
        ArgumentCaptor<Szenario> szenarioArgumentCaptor = ArgumentCaptor.forClass(Szenario.class);
        verify(szenarioRepository).save(szenarioArgumentCaptor.capture());
        Szenario szenarioValue = szenarioArgumentCaptor.getValue();

        assertThat(szenarioValue).isEqualTo(szenario);

    }

    @Disabled
    @Test
    void updateSzenario() {
        Szenario szenario = Szenario.builder()
                .schwierigkeit(Schwierigkeit.LEICHT)
                .fragen(new HashSet<>())
                .absatz1("")
                .build();
        szenarioRepository.save(szenario);

        szenarioService.updateSzenario(szenario);

        ArgumentCaptor<Szenario> szenarioArgumentCaptor = ArgumentCaptor.forClass(Szenario.class);
        verify(szenarioRepository).save(szenarioArgumentCaptor.capture());
        Szenario szenarioValue = szenarioArgumentCaptor.getValue();

        assertThat(szenarioValue).isEqualTo(szenario);
    }

    @Test
    void deleteSzenario() {
        szenarioRepository.delete(szenario);
        verify(szenarioRepository).delete(szenario);
    }

    @Test
    void deleteSzenarioByID() {
        szenarioRepository.deleteById(szenario.getId());
        verify(szenarioRepository).deleteById(szenario.getId());
    }
}