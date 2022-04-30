package at.it_hackathon.frage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class FrageConfig {


    @Bean
    CommandLineRunner commandLineRunnerFrage(FrageRepository repository){
        return args -> {
            Frage frage1 = new Frage("Was würdest du tun", new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen", null);
            Frage frage2 = new Frage("Was würdest du tun", new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen",null);
            repository.saveAll(List.of(frage1, frage2));
        };
    }




}
