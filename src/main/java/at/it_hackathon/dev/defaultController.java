package at.it_hackathon.dev;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class defaultController {

    @GetMapping
    public String returnMessage(){
        return "Success";
    }
}
