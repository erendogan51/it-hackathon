package at.it_hackathon.gesetz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GesetzServiceTest {

    @Mock
    GesetzRepository gesetzRepository;
    GesetzService gesetzService;
    Gesetz gesetz;

    @BeforeEach
    void setUp() {
        gesetzService = new GesetzService(gesetzRepository);
        gesetz = new Gesetz();
    }

    @Test
    void getGesetze() {
        gesetzRepository.findAll();
        verify(gesetzRepository).findAll();
    }

    @Test
    void getGesetzByID() {
        gesetzRepository.findById(gesetz.getId());
        verify(gesetzRepository).findById(gesetz.getId());
    }

    @Test
    void addGesetz() {
        gesetzService.addGesetz(gesetz);
        ArgumentCaptor<Gesetz> gesetzArgumentCaptor = ArgumentCaptor.forClass(Gesetz.class);
        verify(gesetzRepository).save(gesetzArgumentCaptor.capture());
        Gesetz gesetzValue = gesetzArgumentCaptor.getValue();

        assertThat(gesetzValue).isEqualTo(gesetz);
    }

    @Test
    void updateGesetz() {
    }

    @Test
    void deleteGesetz() {
        gesetzRepository.delete(gesetz);
        verify(gesetzRepository).delete(gesetz);
    }

    @Test
    void deleteGesetzByID() {
        gesetzRepository.deleteById(gesetz.getId());
        verify(gesetzRepository).deleteById(gesetz.getId());
    }
}