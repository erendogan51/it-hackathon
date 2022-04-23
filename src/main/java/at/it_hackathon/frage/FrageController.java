package at.it_hackathon.frage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/frage")
public class FrageController {

    private final FrageService frageService;

    @Autowired
    public FrageController(FrageService frageService) {
        this.frageService = frageService;
    }

    @GetMapping("/")
    public List<Frage> getAllFrages(){
        return frageService.getFragen();
    }

    @GetMapping("/{id}")
    public Frage getFrageByID(@PathVariable long id) {
        return frageService.getFrageByID(id);
    }

    @PostMapping("/add")
    public void addFrage(@RequestBody Frage frage) {
        frageService.addFrage(frage);
        //return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public void updateFrage(@RequestBody Frage frage){
        frageService.updateFrage(frage);
    }

    @DeleteMapping("/delete{id}")
    public void deleteFrageByID(@PathVariable long id){
        frageService.deleteFrageByID(id);
    }
    
}
