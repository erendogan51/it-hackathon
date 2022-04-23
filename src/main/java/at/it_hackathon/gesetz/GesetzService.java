package at.it_hackathon.gesetz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GesetzService {
    private final GesetzRepository gesetzRepository;

    @Autowired
    public GesetzService(GesetzRepository gesetzRepository) {
        this.gesetzRepository = gesetzRepository;
    }

    public List<Gesetz> getGesetze() {
        if (gesetzRepository.findAll().isEmpty()) throw new IllegalStateException("No Gesetz found");
        return gesetzRepository.findAll();
    }

    public Gesetz getGesetzByID(long id) {
        if (gesetzRepository.findById(id).isEmpty()) throw new IllegalStateException("No Gesetz found");
        return gesetzRepository.findById(id).get();
    }

    public void addGesetz(Gesetz gesetz) {
        if (gesetzRepository.existsById(gesetz.getId()))
            throw new IllegalStateException("Gesetz with id: " + gesetz.getId() + " already exists");
        gesetzRepository.save(gesetz);
    }

    public void updateGesetz(Gesetz gesetz) {
        Gesetz gesetzToBeUpdated;
        if (!gesetzRepository.findById(gesetz.getId()).isEmpty())
            throw new IllegalStateException("Gesetz with id: " + gesetz.getId() + " doesnt exist");
        long id = gesetz.getId();
        gesetzToBeUpdated = gesetz;
        gesetzToBeUpdated.setId(id);
        gesetzRepository.save(gesetzToBeUpdated);
    }

    public void deleteGesetz(Gesetz gesetz) {
        if (!gesetzRepository.existsById(gesetz.getId()))
            throw new IllegalStateException("Gesetz with id: " + gesetz.getId() + " doesnt exist");
        gesetzRepository.delete(gesetz);
    }

    public void deleteGesetzByID(long id) {
        if (!gesetzRepository.existsById(id))
            throw new IllegalStateException("Gesetz with id: " + id + " doesnt exist");
        gesetzRepository.deleteById(id);
    }

}
