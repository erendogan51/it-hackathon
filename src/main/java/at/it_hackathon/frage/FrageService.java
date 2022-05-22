package at.it_hackathon.frage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FrageService {

    private final FrageRepository frageRepository;

    @Autowired
    public FrageService(FrageRepository frageRepository) {
        this.frageRepository = frageRepository;
    }

    public List<Frage> getFragen() {
        if (frageRepository.findAll().isEmpty()) throw new IllegalStateException("No Fragen found");
        return frageRepository.findAll();
    }

    public Frage getFrageByID(long id) {
        if (frageRepository.findById(id).isEmpty()) throw new IllegalStateException("No Fragen found");
        return frageRepository.findById(id).get();
    }

    public void addFrage(Frage frage) {
        if (frageRepository.existsById(frage.getId()))
            throw new IllegalStateException("Frage with id: " + frage.getId() + " already exists");
        frageRepository.save(frage);
    }

    public void addFrage(Set<Frage> fragen) {
        for (Frage frage:fragen){
            if (frageRepository.existsById(frage.getId()))
                throw new IllegalStateException("Frage with id: " + frage.getId() + " already exists");
        }
        frageRepository.saveAll(fragen);
    }

    public void updateFrage(Frage frage) {
        Frage frageToBeUpdated;
        if (!frageRepository.findById(frage.getId()).isPresent())
            throw new IllegalStateException("Frage with id: " + frage.getId() + " doesnt exist");
        long id = frage.getId();
        frageToBeUpdated = frage;
        frageToBeUpdated.setId(id);
        frageRepository.save(frageToBeUpdated);
    }

    public void deleteFrage(Frage frage) {
        if (!frageRepository.existsById(frage.getId()))
            throw new IllegalStateException("Frage with id: " + frage.getId() + " doesnt exist");
        frageRepository.delete(frage);
    }


    public void deleteFrageByID(long id) {
        if (!frageRepository.existsById(id))
            throw new IllegalStateException("Frage with id: " + id + " doesnt exist");
        //frageRepository.findById(id).get().setSzenario(null);
        frageRepository.deleteById(id);
    }

}
