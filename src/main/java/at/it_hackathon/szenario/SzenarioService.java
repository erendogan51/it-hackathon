package at.it_hackathon.szenario;

import at.it_hackathon.frage.FrageRepository;
import at.it_hackathon.frage.FrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SzenarioService {

    private final SzenarioRepository szenarioRepository;
    private final FrageService frageService;

    @Autowired
    public SzenarioService(SzenarioRepository szenarioRepository, FrageService frageService) {
        this.frageService = frageService;
        this.szenarioRepository = szenarioRepository;
    }

    public List<Szenario> getSzenarios() {
        if (szenarioRepository.findAll().isEmpty()) throw new IllegalStateException("No Szenario found");
        return szenarioRepository.findAll();
    }

    public Szenario getSzenarioByID(long id) {
        if (szenarioRepository.findById(id).isEmpty()) throw new IllegalStateException("No Szenario found");
        return szenarioRepository.findById(id).get();
    }

    public void addSzenario(Szenario szenario) {
        if (szenarioRepository.existsById(szenario.getId()))
            throw new IllegalStateException("Szenario with id: " + szenario.getId() + " already exists");
        szenarioRepository.save(szenario);
    }

    public void addSzenarienWithFrage(List<Szenario> szenarien) {
        for (Szenario szenario: szenarien) {
            if (szenarioRepository.existsById(szenario.getId())) throw new IllegalStateException("Szenario with id: " + szenario.getId() + " already exists");
            frageService.addFrage(szenario.getFragen());
            szenarioRepository.save(szenario);
        }
    }

    public void addFrageToSzenario(long frageID) {
    }

    public void updateSzenario(Szenario szenario) {
        Szenario szenarioToBeUpdated;
        if (szenarioRepository.findById(szenario.getId()).isEmpty())
            throw new IllegalStateException("Szenario with id: " + szenario.getId() + " doesnt exist");
        long id = szenario.getId();
        szenarioToBeUpdated = szenario;
        szenarioToBeUpdated.setId(id);
        szenarioRepository.save(szenarioToBeUpdated);
    }

    public void deleteSzenario(Szenario szenario) {
        if (!szenarioRepository.existsById(szenario.getId()))
            throw new IllegalStateException("Szenario with id: " + szenario.getId() + " doesnt exist");
        szenarioRepository.delete(szenario);
    }

    public void deleteSzenarioByID(long id) {
        if (!szenarioRepository.existsById(id))
            throw new IllegalStateException("Szenario with id: " + id + " doesnt exist");
        szenarioRepository.deleteById(id);
    }


}
