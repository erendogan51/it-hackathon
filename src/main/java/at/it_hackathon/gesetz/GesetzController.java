package at.it_hackathon.gesetz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gesetz")
public class GesetzController {

    private final GesetzService gesetzService;

    @Autowired
    public GesetzController(GesetzService gesetzService) {
        this.gesetzService = gesetzService;
    }

    @GetMapping("/")
    public List<Gesetz> getAllGesetze(){
        return gesetzService.getGesetze();
    }

    @GetMapping("/{id}")
    public Gesetz getGesetzByID(@PathVariable long id) {
        return gesetzService.getGesetzByID(id);
    }

    @PostMapping("/add")
    public void addGesetz(@RequestBody Gesetz gesetz) {
        gesetzService.addGesetz(gesetz);
        //return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public void updateGesetz(@RequestBody Gesetz gesetz){
        gesetzService.updateGesetz(gesetz);
    }

    @DeleteMapping("/delete{id}")
    public void deleteGesetzByID(@PathVariable long id){
        gesetzService.deleteGesetzByID(id);
    }

}
