package at.it_hackathon.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmailValidator {

    public boolean isValid(String email){

        return true;
    }
}
