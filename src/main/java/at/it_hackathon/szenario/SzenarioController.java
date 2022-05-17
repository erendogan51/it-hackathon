package at.it_hackathon.szenario;

import at.it_hackathon.frage.Frage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/szenario")
public class SzenarioController {

    private final SzenarioService szenarioService;

    @Autowired
    public SzenarioController(SzenarioService szenarioService) {
        this.szenarioService = szenarioService;
    }

    @GetMapping("/")
    public List<Szenario> getAllSzenarios(){
        return szenarioService.getSzenarios();
    }

    @GetMapping("/{id}")
    public Szenario getSzenarioByID(@PathVariable long id) {
        return szenarioService.getSzenarioByID(id);
    }

    @PostMapping("/add")
    public void addSzenario(@RequestBody Szenario szenario) {
        szenarioService.addSzenario(szenario);
    }

    @PostMapping("/addwithfrage")
    public void addSzenarioWithFrage(@RequestBody List<Szenario> szenario) {
        szenarioService.addSzenarienWithFrage(szenario);
    }


    @PutMapping("/update")
    public void updateSzenario(@RequestBody Szenario szenario){
        szenarioService.updateSzenario(szenario);
    }

    @DeleteMapping("/delete{id}")
    public void deleteSzenarioByID(@PathVariable long id){
        szenarioService.deleteSzenarioByID(id);
    }


}
